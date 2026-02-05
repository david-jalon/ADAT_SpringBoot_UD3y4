package org.example.adat_actividad3y4_davidjalon.controller;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar la entidad Game.
 * Proporciona los puntos de entrada (endpoints) para realizar operaciones
 * CRUD y consultas personalizadas sobre el catálogo de videojuegos.
 */

@RestController
@RequestMapping("/apiv1/game")
class GameController {

    /**
     * Constructor para la inyección de dependencias.
     * * @param gameService Servicio que contiene la lógica de negocio de juegos.
     */
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Obtiene la lista completa de videojuegos.
     * * @return List de objetos {@link Game} con todos los registros.
     */
    @GetMapping("/allGames")
    public List<Game> findAllGames() {
        return gameService.findAll();
    }

    /**
     * Busca un videojuego por su identificador único.
     * * @param game_id Identificador numérico del juego.
     * @return El objeto {@link Game} encontrado o null si no existe.
     */
    @GetMapping("/id/{game_id}")
    public Game findGameById(@PathVariable Integer game_id) {
        return gameService.findGameById(game_id).orElse(null);
    }
    /**
     * Recupera únicamente los títulos de todos los videojuegos registrados.
     * * @return Lista de Strings con los nombres de los juegos.
     */
    @GetMapping("/allGames/title")
    public List<String> findAllGamesByTitle() {
        return gameService.findAllGamesByTitle();
    }

    /**
     * Consulta los títulos de los juegos que pertenecen a un usuario concreto.
     * * @param user_id Identificador del usuario propietario de los juegos.
     * @return Lista de Strings con los títulos asociados al usuario.
     */
    @GetMapping("/user/{user_id}/titles")
    public List<String> findAllGamesByUserId(@PathVariable Integer user_id) {
        return gameService.findGamesByUserId(user_id);
    }

    /**
     * Registra un nuevo videojuego en el sistema.
     * * @param game Objeto {@link Game} enviado en el cuerpo de la petición.
     * @return El objeto {@link Game} guardado, incluyendo su ID generado.
     */
    @PostMapping("/newGame/")
    public Game newGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    /**
     * Actualiza la información de un videojuego existente.
     * * @param id Identificador del juego a modificar.
     * @param gameDetails Objeto con los nuevos datos del juego.
     * @return El objeto {@link Game} actualizado tras persistir los cambios.
     */
    @PutMapping("/update/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game gameDetails) {
        return gameService.updateGame(id, gameDetails);
    }

    /**
     * Elimina un videojuego de la base de datos de forma permanente.
     * * @param id Identificador del juego que se desea borrar.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteGameById(@PathVariable Integer id) {
        gameService.deleteGame(id);
    }
}

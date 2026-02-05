package org.example.adat_actividad3y4_davidjalon.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.repository.GameRepository;
import org.example.adat_actividad3y4_davidjalon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio de la entidad Game.
 * Actúa como intermediario entre el controlador y el repositorio,
 * gestionando las operaciones de persistencia y las reglas de negocio.
 */
@Service
public class GameService {

    /** Repositorio para el acceso a datos de juegos */
    GameRepository gameRepository;

    /**
     * Constructor para la inyección de dependencias del repositorio.
     * * @param gameRepository Repositorio de juegos.
     */
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * Recupera todos los videojuegos almacenados en el sistema.
     * * @return List de {@link Game} con todos los registros encontrados.
     */
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    /**
     * Busca un videojuego por su identificador único.
     * * @param game_id Clave primaria del juego.
     * @return Un {@link Optional} que contiene el juego si se encuentra, o vacío si no.
     */
    public Optional<Game> findGameById(int game_id) {
        return gameRepository.findById(game_id);
    }

    /**
     * Obtiene una lista únicamente con los títulos de todos los videojuegos.
     * * @return List de Strings con los nombres de los juegos.
     */
    public List<String> findAllGamesByTitle() {
        return gameRepository.findAllTitle();
    }

    /**
     * Obtiene los títulos de los videojuegos que han sido registrados por un usuario.
     * * @param user_id ID del usuario para filtrar los juegos.
     * @return List de Strings con los títulos de los juegos del usuario.
     */
    public List<String> findGamesByUserId(Integer user_id) {
        return gameRepository.findGamesByUserId(user_id);
    }

    /**
     * Guarda un nuevo videojuego en la base de datos.
     * * @param game Objeto con la información del juego a persistir.
     * @return El objeto {@link Game} ya guardado con su ID generado.
     */
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * Actualiza los datos de un videojuego existente.
     * * @param id Identificador del juego que se desea modificar.
     * @param gameDetails Objeto que contiene los nuevos valores para el juego.
     * @return El objeto {@link Game} actualizado tras ser guardado en la base de datos.
     * @throws EntityNotFoundException Si no se encuentra ningún juego con el ID proporcionado.
     */
    public Game updateGame(Integer id, Game gameDetails) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        game.setTitle(gameDetails.getTitle());
        game.setPlatform(gameDetails.getPlatform());
        game.setGenre(gameDetails.getGenre());
        game.setReleaseYear(gameDetails.getReleaseYear());
        game.setDeveloper(gameDetails.getDeveloper());
        game.setPublisher(gameDetails.getPublisher());
        game.setIsSpecialEdition(gameDetails.getIsSpecialEdition());
        game.setStatus(gameDetails.getStatus());
        game.setEstimatedValue(gameDetails.getEstimatedValue());
        game.setNotes(gameDetails.getNotes());
        return gameRepository.save(game);
    }

    /**
     * Elimina un videojuego del sistema por su ID.
     * * @param id Identificador del juego a eliminar.
     */
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}

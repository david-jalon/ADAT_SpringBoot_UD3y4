package org.example.adat_actividad3y4_davidjalon.controller;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST
 */

@RestController
@RequestMapping("/apiv1/game")
class GameController {

    private GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET
    @GetMapping("/allGames")
    public List<Game> findAllGames() {
        return gameService.findAll();
    }
    
    @GetMapping("/id/{game_id}")
    public Game findGameById(@PathVariable Integer game_id) {
        return gameService.findGameById(game_id).orElse(null);
    }

    @GetMapping("/allGames/title")
    public List<String> findAllGamesByTitle() {
        return gameService.findAllGamesByTitle();
    }

    @GetMapping("/user/{user_id}/titles")
    public List<String> findAllGamesByUserId(@PathVariable Integer user_id) {
        return gameService.findGamesByUserId(user_id);
    }

    //POST
    @PostMapping("/newGame/")
    public Game newGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    //PUT
    @PutMapping("/update/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game gameDetails) {
        return gameService.updateGame(id, gameDetails);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteGameById(@PathVariable Integer id) {
        gameService.deleteGame(id);
    }
}

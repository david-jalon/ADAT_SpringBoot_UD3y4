package org.example.adat_actividad3y4_davidjalon.controller;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/apiv1/game")
class GameController {

    private GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /*@GetMapping("/test")
    public String saludo() {
        return "Get funciona";
    }*/

    @GetMapping("/allGames")
    public List<Game> findAllGames() {
        return gameService.findAll();
    }

    @GetMapping("/allGames/title")
    public List<String> findAllGamesByTitle() {
        return gameService.findAllGamesByTitle();
    }

}

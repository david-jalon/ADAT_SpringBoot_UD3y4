package org.example.adat_actividad3y4_davidjalon.services;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public List<String> findAllGamesByTitle() {
        return gameRepository.findAllTitle();
    }
}

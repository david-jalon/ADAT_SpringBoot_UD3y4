package org.example.adat_actividad3y4_davidjalon.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.repository.GameRepository;
import org.example.adat_actividad3y4_davidjalon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    //Constructor
    GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //Funciones
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findGameById(int game_id) {
        return gameRepository.findById(game_id);
    }

    public List<String> findAllGamesByTitle() {
        return gameRepository.findAllTitle();
    }

    public List<String> findGamesByUserId(Integer user_id) {
        return gameRepository.findGamesByUserId(user_id);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

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

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}

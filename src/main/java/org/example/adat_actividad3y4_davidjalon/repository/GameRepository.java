package org.example.adat_actividad3y4_davidjalon.repository;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    //findAll() viene ya includido en el repositorio

    @Query ("SELECT g.title FROM Game g")
    public List<String> findAllTitle();
}

package org.example.adat_actividad3y4_davidjalon.repository;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    //findAll() viene ya includido en el repositorio
    //Los metodos save basicos ya existen
    //Los metodos delete basicos ya existen

    @Query ("SELECT g.title FROM Game g")
    List<String> findAllTitle();

    // Aqui no hay que mandar el id principal porque hibernate lo genera,
    // a parte el user_id se manda asi {"id":1}
    @Query("SELECT g.title FROM Game g WHERE g.user.id = :user_id")
    List<String> findGamesByUserId(@Param("user_id") int user_id);

}

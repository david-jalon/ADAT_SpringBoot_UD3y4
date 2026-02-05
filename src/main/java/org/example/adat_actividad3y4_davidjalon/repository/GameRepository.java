package org.example.adat_actividad3y4_davidjalon.repository;

import org.example.adat_actividad3y4_davidjalon.entities.Game;
import org.example.adat_actividad3y4_davidjalon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Game.
 * Proporciona el acceso a datos mediante Spring Data JPA. Incluye las operaciones
 * básicas CRUD heredadas de {@link JpaRepository} y consultas personalizadas mediante JPQL.
 */
public interface GameRepository extends JpaRepository<Game, Integer> {

    /**
     * Obtiene una lista con todos los títulos de los videojuegos registrados.
     * * @return List de cadenas de texto con los títulos.
     */
    @Query ("SELECT g.title FROM Game g")
    List<String> findAllTitle();

    /**
     * Obtiene los títulos de los videojuegos asociados a un usuario específico.
     * Esta consulta utiliza el ID del usuario como filtro a través de la relación.
     * * @param user_id Identificador único del usuario.
     * @return List de cadenas de texto con los títulos de los juegos que pertenecen al usuario.
     */
    @Query("SELECT g.title FROM Game g WHERE g.user.id = :user_id")
    List<String> findGamesByUserId(@Param("user_id") int user_id); // Aqui no hay que mandar el id principal porque hibernate lo genera,
    // a parte el user_id se manda asi {"id":1}

}

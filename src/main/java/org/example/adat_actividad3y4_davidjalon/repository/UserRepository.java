package org.example.adat_actividad3y4_davidjalon.repository;

import org.example.adat_actividad3y4_davidjalon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer> {
}

package org.example.adat_actividad3y4_davidjalon.controller;

import org.example.adat_actividad3y4_davidjalon.entities.User;
import org.example.adat_actividad3y4_davidjalon.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar la entidad User.
 * Proporciona los puntos de entrada (endpoints) para realizar operaciones
 * CRUD y gestión de cuentas de usuario en el sistema.
 */
@RestController
@RequestMapping("/apiv1/user")
class UserController {

    /**
     * Constructor para la inyección de dependencias.
     * @param userService Servicio que contiene la lógica de negocio de usuarios.
     */
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    /**
     * Obtiene la lista completa de todos los usuarios
     * @return List de objetos {@link User} con todos los registros
     */
    @GetMapping("/allusers")
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * Obtiene la lista completa de todos los usuarios registrados.
     * @return List de objetos {@link User} con todos los registros encontrados.
     */
    @GetMapping("/id/{user_id}")
    public User getUserById(@PathVariable Integer user_id) {
        return userService.findUserById(user_id).orElse(null);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * @param user Objeto {@link User} con la información del nuevo perfil.
     * @return El objeto {@link User} persistido en la base de datos.
     */
    @PostMapping("/newUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Actualiza la información de un usuario existente.
     * @param id Identificador del usuario que se desea modificar.
     * @param userDetails Objeto con los nuevos datos (nombre, email, etc.).
     * @return El objeto {@link User} actualizado tras guardar los cambios.
     */
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    /**
     * Elimina un usuario del sistema de forma permanente.
     * @param id Identificador del usuario que se va a borrar.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

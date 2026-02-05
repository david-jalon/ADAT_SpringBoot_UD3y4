package org.example.adat_actividad3y4_davidjalon.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.adat_actividad3y4_davidjalon.entities.User;
import org.example.adat_actividad3y4_davidjalon.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio de la entidad User.
 * Proporciona métodos para la administración de usuarios, validando las
 * operaciones antes de persistirlas a través del repositorio.
 */
@Service
public class UserService {

    /**
     * Constructor para la inyección de dependencias del repositorio.
     * @param userRepository Repositorio de usuarios.
     */
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    /**
     * Recupera la lista de todos los usuarios registrados en el sistema.
     * @return List de {@link User} con todos los registros.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su identificador único.
     * @param user_id Clave primaria del usuario.
     * @return Un {@link Optional} que contiene el usuario si existe, o vacío en caso contrario.
     */
    public Optional<User> findUserById(Integer user_id) {
        return userRepository.findById(user_id);
    }

    /**
     * Crea o guarda un usuario en la base de datos.
     * @param user Objeto con la información del usuario a guardar.
     * @return El objeto {@link User} persistido.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Actualiza la información de un usuario existente.
     * En esta implementación, se actualiza principalmente el correo electrónico.
     * * @param id Identificador del usuario a modificar.
     * @param userDetails Objeto que contiene los nuevos datos del usuario.
     * @return El objeto {@link User} actualizado y guardado.
     * @throws EntityNotFoundException Si no se encuentra el usuario con el ID especificado.
     */
    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    /**
     * Elimina un usuario del sistema mediante su identificador.
     * @param id Identificador del usuario a eliminar.
     */
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
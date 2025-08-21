package org.project.Service;

import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.project.Entity.UserEntity;
import org.project.Exception.UserNotFoundException;
import org.project.Repository.UserRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity CreateUser(UserEntity userEntity) {
        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> FindAll(Integer page, Integer pageSize) {
        return userRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public UserEntity findById(UUID userId) {
        return (UserEntity) userRepository.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public UserEntity UpdateUser(UUID userId, UserEntity userEntity) {
        var user = findById(userId);

        user.setUsername(userEntity.getUsername());

        userRepository.persist(user);

        return user;
    }

    public void DeleteById(UUID userId) {
        var user = findById(userId);
        userRepository.deleteById(user.getUserId());
    }
}

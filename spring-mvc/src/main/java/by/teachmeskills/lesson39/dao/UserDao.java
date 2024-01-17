package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    void save(User user);

    void remove(User user);

    Optional<User> findById(Long id);

    User findById(UUID id);

    Optional<User> findByLogin(String login);

    void createNewUser();

    List<User> findAll();
}

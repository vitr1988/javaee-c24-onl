package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.User;

import java.util.Optional;

public interface UserDao {

    void save(User user);

    void remove(User user);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);

    void createNewUser();
}

package by.teachmeskills.lesson39.service.impl;

import by.teachmeskills.lesson39.dao.UserDao;
import by.teachmeskills.lesson39.dto.UserDto;
import by.teachmeskills.lesson39.entity.User;
import by.teachmeskills.lesson39.exception.CustomException;
import by.teachmeskills.lesson39.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j
@Service // @Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public String name() {
        return "User!";
    }

    @Override
    public String generateName(Long id) {
        return "User" + id;
    }

    @Override
    public void registration(String login, String password, String email, Integer age) {
        log.info("login => %s, password => ***, email => %s, age => %d".formatted(login, email, age));
        if (age > 55) {
            throw new CustomException("User is not matched for our requirements");
        }
    }

    @Override
    public void create(UserDto userDto) {
        userDao.save(new User(userDto));
    }

    @Override
    public void update(UserDto userDto) {
        userDao.findByLogin(userDto.getLogin())
                .map(it -> it.update(userDto))
                .ifPresent(userDao::save);
    }

    @Override
    public void remove(Long id) {
        userDao.findById(id).ifPresent(userDao::remove);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userDao.findById(id);
        user.ifPresent(it -> log.info("user %s".formatted(it)));
        return user.map(it -> new UserDto(it.getId(), it.getUserName(), it.getLogin(), it.getPassword(), it.getRole()));
    }

    @Override
    public void createNewUser() {
        userDao.createNewUser();
    }
}

package by.teachmeskills.lesson39.service.impl;

import by.teachmeskills.lesson39.exception.CustomException;
import by.teachmeskills.lesson39.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service // @Component
public class UserServiceImpl implements UserService {

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
}

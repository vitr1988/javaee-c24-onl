package by.teachmeskills.lesson39.service.impl;

import by.teachmeskills.lesson39.service.UserService;
import org.springframework.stereotype.Service;

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
}

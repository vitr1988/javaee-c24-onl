package by.teachmeskills.lesson46.repository;

import by.teachmeskills.lesson46.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<UserDto> users = new ArrayList<>();

    public List<UserDto> getAll() {
        return users;
    }

    public Optional<UserDto> getById(Long id) {
        return getAll().stream().filter(it -> Objects.equals(id, it.getId())).findFirst();
    }

    public UserDto create(UserDto userDto) {
        userDto.setId(users.size() + 1L);
        users.add(userDto);
        return userDto;
    }

    public void update(Long id, UserDto response) {
        if (id <= 0) return;
        users.set(Math.toIntExact(id) - 1, response);
    }

    public void deleteById(Long id) {
        if (id < 0) return;
        getById(id).ifPresent(user -> {
            user.setActive(false);
            update(id, user);
        });
    }
}

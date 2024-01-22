package by.teachmeskills.lesson46.service.impl;

import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.repository.UserRepository;
import by.teachmeskills.lesson46.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userRepository.create(userDto);
    }

    @Override
    public void update(Long id, UserDto response) {
        userRepository.update(id, response);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userRepository.getById(id);
    }
}

package by.teachmeskills.lesson46.service.impl;

import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.repository.UserRepository;
import by.teachmeskills.lesson46.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    @SneakyThrows
    public List<UserDto> getAllByHttp() {
        return restTemplate.getForObject(new URI("http://localhost:8080/api/users"), List.class);
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
    public UserDto getById(Long id) {
        return userRepository.getById(id)
//                .orElseThrow(() -> new NotFoundException("Пользователь с идентификатором %d не найден".formatted(id), id));
                .orElseThrow(() -> new RuntimeException("Пользователь с идентификатором %d не найден".formatted(id)));
    }
}

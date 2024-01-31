package by.teachmeskills.lesson46.service.impl;

import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.entity.User;
import by.teachmeskills.lesson46.mapper.UserMapper;
import by.teachmeskills.lesson46.repository.UserJpaRepository;
import by.teachmeskills.lesson46.repository.UserRepository;
import by.teachmeskills.lesson46.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserJpaRepository userJpaRepository;
    private final RestTemplate restTemplate;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toDtos(userJpaRepository.findAll());
    }

    @Override
    public List<UserDto> getAll(Pageable pageable) {
        return userMapper.toDtos(userJpaRepository.findContent(pageable));
//        Page<User> all = userJpaRepository.findAll(pageable);
//        return userMapper.toDtos(all.getContent());
    }

    @Override
    @SneakyThrows
    public List<UserDto> getAllByHttp() {
        return restTemplate.getForObject(new URI("http://localhost:8080/api/users"), List.class);
    }

    @Override
    public List<UserDto> findByName(String name) {
        return userMapper.toDtos(userJpaRepository.findByName(name));
    }

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userJpaRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void update(Long id, UserDto response) {
        userRepository.update(id, response);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public UserDto getById(Long id) {
        return userJpaRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Пользователь с идентификатором %d не найден".formatted(id)));
    }
}

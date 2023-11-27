package lesson32.dao;

import lesson32.dto.UserDto;
import lesson32.entity.User;
import lesson32.mapper.UserMapper;
import lesson32.mapper.impl.UserMapperImpl;

public class UserDao {

    private static final UserMapper userMapper = new UserMapperImpl();// Mappers.getMapper(UserMapper.class);

    private Long counter = 1L;

    public User save(User user) {
//        User user = userMapper.toEntity(userDto);
        user.setId(counter++);
        return user;
    }
}

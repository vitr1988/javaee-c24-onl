package lesson32.dao;

import lesson32.entity.User;
import lesson32.mapper.UserMapper;
import org.mapstruct.factory.Mappers;

public class UserDao {

    private static final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private Long counter = 1L;

    public User save(User user) {
//        User user = userMapper.toEntity(userDto);
        user.setId(counter++);
        return user;
    }
}

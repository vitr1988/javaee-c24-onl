package lesson32.service;

import lesson32.entity.User;
import lesson32.mapper.UserMapper;
import lesson32.dao.UserDao;
import lesson32.dto.UserDto;
import lesson32.mapper.impl.UserMapperImpl;
import org.mapstruct.factory.Mappers;

public class UserService {

    private static final UserService INSTANCE = new UserService();
    private static final UserMapper userMapper = new UserMapperImpl();//Mappers.getMapper(UserMapper.class);

    private UserDao userDao = new UserDao();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public UserDto save(UserDto userDto) {
        User save = userDao.save(userMapper.toEntity(userDto));
        return userMapper.toDto(save);
    }
}

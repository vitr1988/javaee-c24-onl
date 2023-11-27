package lesson32.mapper.impl;

import lesson32.dto.UserDto;
import lesson32.entity.User;
import lesson32.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto user) {
        User userEntity = new User();
        userEntity.setId(user.getId());
        userEntity.setFullName(user.getFullName());
        return userEntity;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        return userDto;
    }
}

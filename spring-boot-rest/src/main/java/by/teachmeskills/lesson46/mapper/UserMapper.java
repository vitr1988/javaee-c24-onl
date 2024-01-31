package by.teachmeskills.lesson46.mapper;

import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(source = "userName", target = "name")
    UserDto toDto(User user);

    @Mapping(source = "name", target = "userName")
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto user);

    default List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }

    default List<User> toEntites(List<UserDto> users) {
        return users.stream().map(this::toEntity).toList();
    }
}

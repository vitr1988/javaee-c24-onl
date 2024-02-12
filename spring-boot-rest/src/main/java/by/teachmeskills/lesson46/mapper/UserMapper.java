package by.teachmeskills.lesson46.mapper;

import by.teachmeskills.lesson46.dto.CreateUserDto;
import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.entity.User;
import by.teachmeskills.lesson46.service.RoleService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(source = "userName", target = "name")
    @Mapping(target = "role", ignore = true)
    UserDto toDto(User user);

    @Mapping(source = "name", target = "userName")
    @Mapping(target = "role", ignore = true)
    User toEntity(CreateUserDto user, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder);

    @AfterMapping
    default void postConstruct(CreateUserDto userDto, @MappingTarget User user,
                               @Context RoleService roleService, @Context PasswordEncoder passwordEncoder) {
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        roleService.findByName(userDto.getRole()).ifPresent(user::setRole);
//        roleService.findByName(RoleEnum.GUEST.name()).ifPresent(user::setRole);
    }

    default List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }

    default List<User> toEntites(List<UserDto> users, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder) {
        return users.stream().map(it -> toEntity(it, roleService, passwordEncoder)).toList();
    }
}

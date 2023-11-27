package lesson32.mapper;

import lesson32.dto.UserDto;
import lesson32.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "fullName", source = "user.fullName")
    })
    User toEntity(UserDto user);

    UserDto toDto(User user);
}

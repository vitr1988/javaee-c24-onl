package lesson32.mapper;

import lesson32.dto.UserDto;
import lesson32.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

//    @Mappings({
//            @Mapping(target = "id", source = "user.id"),
//            @Mapping(target = "fullName", source = "user.fullName"),
//            @Mapping(target = "sex", source = "user.sex"),
//    })
    User toEntity(UserDto user);

    UserDto toDto(User user);
}

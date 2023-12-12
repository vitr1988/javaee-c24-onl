package lesson34.log.dto;

import lombok.Data;

@Data
public class RoleDto implements Cloneable {
    private Long id;
    private String name;

    private UserDto[] users = new UserDto[] {new UserDto(), new UserDto()};

    public RoleDto(RoleDto roleDto) {
        this.id = roleDto.getId();
        this.name = roleDto.getName();
    }

    @Override
    protected RoleDto clone() throws CloneNotSupportedException {
        return (RoleDto) super.clone();
    }
}

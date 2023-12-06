package lesson34.log.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@NoArgsConstructor
public class UserDto implements Cloneable {

    private Long id;
    private String fullName;
    private boolean sex;
    private RoleDto roleDto;

    public UserDto(UserDto userDto) {
        this.id = userDto.id;
        this.fullName = userDto.fullName;
        this.sex = userDto.sex;
//        this.roleDto = userDto.roleDto.clone();
        this.roleDto = new RoleDto(userDto.roleDto);
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package lesson32.dto;

import lesson32.entity.Role;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class UserDto implements Cloneable {

    private Long id;
    private String fullName;
    private boolean sex;
    @Setter
    private Role role;
    private List<String> roles;

    public UserDto(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }


    public Long getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public boolean isSex() {
        return this.sex;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (sex != userDto.sex) return false;
        if (!Objects.equals(id, userDto.id)) return false;
        return Objects.equals(fullName, userDto.fullName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (sex ? 1 : 0);
        return result;
//        return Objects.hash(id, fullName, sex);
    }

    @Override
    public String toString() {
        return "UserDto(id=" + this.getId() + ", fullName=" + this.getFullName() + ", sex=" + this.isSex() + ", roles=" + this.getRoles() + ")";
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        UserDto clone = (UserDto) super.clone();
//        clone.setRole(this.role.clone());
//        return clone;
//    }

    public static void main(String[] args) throws Exception {
        UserDto newUser = new UserDto(1L, "Vitaly");
        UserDto cloneUser = (UserDto) newUser.clone();
        System.out.println(cloneUser);
    }
}

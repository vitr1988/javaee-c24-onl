package lesson34.log.dto;

public class UserDto {

    private Long id;
    private String fullName;
    private boolean sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", sex=" + sex +
                '}';
    }
}

package lesson32.entity;

import lombok.Data;

@Data
public class Role implements Cloneable {
    private Long id;
    private String name;

    @Override
    public Role clone() throws CloneNotSupportedException {
        return (Role) super.clone();
    }
}

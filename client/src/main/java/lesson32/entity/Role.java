package lesson32.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Cloneable {
    private Long id;
    private String name;

    @Override
    public Role clone() throws CloneNotSupportedException {
        return (Role) super.clone();
    }
}

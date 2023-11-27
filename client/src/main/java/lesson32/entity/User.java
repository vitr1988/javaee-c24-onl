package lesson32.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String fullName;
    private boolean sex;
}

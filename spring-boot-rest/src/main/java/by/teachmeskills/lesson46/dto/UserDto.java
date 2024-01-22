package by.teachmeskills.lesson46.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private boolean active = true;
}

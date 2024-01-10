package by.teachmeskills.lesson39.dto;

import by.teachmeskills.lesson39.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String login;
    private String password;
    private Role role;
}

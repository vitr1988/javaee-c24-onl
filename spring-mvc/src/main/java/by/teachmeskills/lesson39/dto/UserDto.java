package by.teachmeskills.lesson39.dto;

import by.teachmeskills.lesson39.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String userName;
    private String login;
    private String password;
    private Role role;
}

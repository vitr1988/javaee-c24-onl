package lesson32.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String fullName;
    private List<String> roles;
}

package by.teachmeskills.lesson41.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 10)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 10)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 10)
    private String password;
}

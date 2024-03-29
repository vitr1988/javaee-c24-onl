package by.teachmeskills.lesson46.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserDto {

    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    private String login;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    private String status;

    @Nullable
    private String role;

    private boolean active = true;

    @JsonIgnore
    private byte[] avatar;
}

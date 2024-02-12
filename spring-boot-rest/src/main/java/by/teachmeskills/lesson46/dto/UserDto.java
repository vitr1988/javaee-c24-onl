package by.teachmeskills.lesson46.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto extends CreateUserDto {

    @Override
    @JsonIgnore
    public String getPassword() {
        return super.getPassword();
    }
}

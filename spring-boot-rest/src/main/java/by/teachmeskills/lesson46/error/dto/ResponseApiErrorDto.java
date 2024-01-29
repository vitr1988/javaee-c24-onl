package by.teachmeskills.lesson46.error.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseApiErrorDto {

    private ApiError error;

    public ResponseApiErrorDto(String code, String message) {
        this.error = new ApiError();
        this.error.setCode(code);
        this.error.setMessage(message);
    }
}

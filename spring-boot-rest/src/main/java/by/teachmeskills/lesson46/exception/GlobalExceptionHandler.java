package by.teachmeskills.lesson46.exception;

import by.teachmeskills.lesson46.error.dto.ResponseApiErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Component
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        log.warn("Exception handled", ex);
        ResponseApiErrorDto apiErrorDto = new ResponseApiErrorDto("VALIDATION_FAILED", "Нарушена валидация входящего запроса");
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                apiErrorDto.getError().addField(fieldName, errorMessage);
            } else {
                apiErrorDto.getError().setMessage(error.getDefaultMessage());
            }
        });
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ResponseApiErrorDto> handleNotFound(NotFoundException notFoundException) {
//        ResponseApiErrorDto responseApiErrorDto =
//                new ResponseApiErrorDto("RESOURCE_NOT_FOUND", "Данный пользователь с id %d не найден".formatted(notFoundException.getUserId()));
//        return new ResponseEntity<>(responseApiErrorDto, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseApiErrorDto handleNotFound(NotFoundException notFoundException) {
        return new ResponseApiErrorDto("RESOURCE_NOT_FOUND", "Данный пользователь с id %d не найден".formatted(notFoundException.getUserId()));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseApiErrorDto handleNotFound(RuntimeException runtimeException) {
        return new ResponseApiErrorDto("EXCEPTION_HAPPENED", runtimeException.getMessage());
    }
}

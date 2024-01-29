package by.teachmeskills.lesson46.error.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private String code;
    private String message;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }

    public void addField(String name, String message) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        fields.add(new Field(name, message));
    }
}


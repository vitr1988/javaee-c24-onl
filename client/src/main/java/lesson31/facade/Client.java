package lesson31.facade;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@ToString(of = "fullName")
public class Client {

    private String fullName;
    private Integer age;
    private boolean sex;
    private BigDecimal money;

}

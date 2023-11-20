package lesson31.facade;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class Credit {

    private String clientId;
    private BigDecimal value;
}

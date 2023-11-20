package lesson31.facade;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VerificationService {

    private static final BigDecimal THRESHOLD = new BigDecimal(1000);

    private static final VerificationService INSTANCE = new VerificationService();

    public boolean isValid(Client client) {
        return client.getAge() >= 18
                && client.getMoney().compareTo(THRESHOLD) > 0;
    }

    public static VerificationService getInstance() {
        return INSTANCE;
    }
}

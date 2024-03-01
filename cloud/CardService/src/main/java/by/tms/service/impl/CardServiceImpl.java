package by.tms.service.impl;

import by.tms.generator.CardNumberGenerator;
import by.tms.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardNumberGenerator cardNumberGenerator;

    @Override
    public String generateCardNumber() {
        return cardNumberGenerator.generate();
    }
}

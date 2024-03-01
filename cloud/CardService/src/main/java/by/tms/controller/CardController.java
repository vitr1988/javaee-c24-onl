package by.tms.controller;

import by.tms.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/create")
    String generateCardNumber() {
        return cardService.generateCardNumber();
    }
}

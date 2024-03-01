package by.tms.service;

import by.tms.dto.ProcessingDto;

import java.math.BigDecimal;

public interface ProcessingService {
    ProcessingDto issueCard(Long accountId);

    void spendMoney(String cardNumber, BigDecimal sum);

    ProcessingDto getProcessing(Long accountId);
}

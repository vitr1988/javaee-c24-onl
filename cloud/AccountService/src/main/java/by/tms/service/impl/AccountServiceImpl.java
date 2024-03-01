package by.tms.service.impl;

import by.tms.domain.Account;
import by.tms.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.tms.feign.ClientServiceClient;
import by.tms.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ClientServiceClient clientServiceClient;

    @Override
    @Transactional
    public Long createAccount(Long clientId) {
        val clientDto = clientServiceClient.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Has no client with id: " + clientId));
        Account accountEntity = new Account(clientDto.getId());
        accountRepository.save(accountEntity);
        return accountEntity.getId();
    }

    @Override
    @Transactional
    public void depositAccount(Long accountId, BigDecimal money) {
        accountRepository.addBalance(accountId, money);
    }

    @Override
    @Transactional
    public void withdrawAccount(Long accountId, BigDecimal money) {
        accountRepository.addBalance(accountId, money.multiply(BigDecimal.valueOf(-1)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
}

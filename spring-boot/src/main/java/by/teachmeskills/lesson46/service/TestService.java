package by.teachmeskills.lesson46.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
//@Profile(LOCAL)
@ConditionalOnProperty("app.setting.enabled")
public class TestService {
}

package by.teachmeskills.lesson41.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static by.teachmeskills.lesson41.util.Profiles.LOCAL;

@Service
//@Profile(LOCAL)
@ConditionalOnProperty("app.setting.enabled")
public class TestService {
}

package by.teachmeskills.lesson46.repository;

import by.teachmeskills.lesson46.entity.User;
import by.teachmeskills.lesson46.entity.type.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы с пользователями на основе JPA должен ")
@DataJpaTest
//@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @DisplayName("уметь получать список всех пользователей")
    @Test
    public void shouldReturnCorrectAllUserList() {
        List<User> users = userJpaRepository.findAll();
        assertThat(users).isNotNull().hasSize(3)
                .allMatch(not(it -> it.getLogin().isEmpty()))
                .allMatch(not(it -> it.getUserName().isEmpty()));
        users.forEach(System.out::println);
    }

    @DisplayName("уметь получать информацию о конкретном пользователе по его идентификатору")
    @Test
    public void shouldFindExpectedUserById(){
        Long userId = 1L;
        User actualUser = userJpaRepository.findById(userId).orElseThrow();
        assertThat(actualUser).isNotNull()
                .hasFieldOrPropertyWithValue("id", userId)
                .hasFieldOrPropertyWithValue("userName", "admin");
    }

    @DisplayName("уметь создавать пользователя")
    @Test
    public void shouldSaveAndLoadCorrectUser() {
        User expectedUser = new User();
        expectedUser.setLogin("Test100");
        expectedUser.setUserName("Тестовый пользователь");
        expectedUser.setPassword("test100");
        expectedUser.setStatus(Status.OK);
        User actualUser = userJpaRepository.save(expectedUser);
        assertThat(actualUser).isEqualTo(expectedUser);
        assertThat(actualUser).isNotNull()
                .hasFieldOrPropertyWithValue("id", expectedUser.getId());
    }


    @DisplayName("уметь обновлять пользователя в БД")
    @Test
    public void shouldUpdateUser() {
        Long userId = 1L;
        User expectedUser = userJpaRepository.findById(userId).orElseThrow();
        assertThat(expectedUser).isNotNull();
        String newName = "Test1";
        expectedUser.setUserName(newName);
        userJpaRepository.save(expectedUser);
        User actualUser = userJpaRepository.findById(userId).orElseThrow();
        assertThat(actualUser).isNotNull()
                .hasFieldOrPropertyWithValue("userName", newName);
    }

    @DisplayName("уметь удалять пользователя")
    @Test
    public void shouldDeleteUser() {
        Integer userCountBefore = userJpaRepository.findAll().size();
        User newUser = new User();
        newUser.setId(1000L);
        newUser.setLogin("unknown");
        newUser.setUserName("Несуществующий пользователь");
        newUser.setPassword("awkward");
        newUser.setStatus(Status.OK);
        User user = userJpaRepository.save(newUser);
        userJpaRepository.delete(user);
        Integer genreCountAfter = userJpaRepository.findAll().size();

        assertThat(userCountBefore).isEqualTo(genreCountAfter);
    }
}

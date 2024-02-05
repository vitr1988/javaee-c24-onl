package by.teachmeskills.lesson46.repository;

import by.teachmeskills.lesson46.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("select user from User user")
    List<User> findContent(Pageable page);

    @Query(nativeQuery = true, value = "select * from users where user_name like :userName || '%'")
    List<User> findByName(@Param("userName") String name);

    @EntityGraph(value = "User.role")
    Optional<User> findByLogin(String login);
}

package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class HibernateUserDao implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public void remove(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.remove(user);
        user.setDeletable(true);
        currentSession.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return Optional.ofNullable(currentSession.get(User.class, id));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("select user from User user where user.login = :login", User.class);
        query.setParameter("login", login);
        return query.getResultStream().findAny();
    }
}

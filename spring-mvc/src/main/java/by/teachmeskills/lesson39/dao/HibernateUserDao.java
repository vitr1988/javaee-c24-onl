package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Phone;
import by.teachmeskills.lesson39.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j
@Repository
@Transactional(readOnly = true)//(noRollbackFor = RuntimeException.class)
@RequiredArgsConstructor
public class HibernateUserDao implements UserDao {

    private final SessionFactory sessionFactory;
    private final PhoneDao phoneDao;

    @Override
    @Transactional
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (user.getId() == null) {
//            Phone savedPhone = phoneDao.save(new Phone("77777777"));
            Phone savedPhone = new Phone("77777777");
            savedPhone.setUser(user);
//            user.getPhones().add(savedPhone);
            currentSession.save(user);
            phoneDao.save(savedPhone);
            log.info("user %s".formatted(user));
        } else {
            currentSession.update(user);
        }

//        try (Session currentSession = sessionFactory.openSession()) {
//            Transaction transaction = currentSession.beginTransaction();
//            if (user.getId() == null) {
//                currentSession.save(user);
//            } else {
//                currentSession.update(user);
//            }
//            transaction.commit();
//        }
    }

    @Override
    @Transactional
    public void remove(User user) {
//        Session currentSession = sessionFactory.getCurrentSession();
////        currentSession.remove(user);
//        user.setDeletable(true);
//        currentSession.update(user);
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Optional<User> user = Optional.ofNullable(currentSession.get(User.class, id));
        List<Phone> phones = user.get().getPhones();
        return user;
    }

    @Override
//    @Transactional(readOnly = true)
    public Optional<User> findByLogin(String login) {
        try(Session currentSession = sessionFactory.openSession()) {
            Query<User> query = currentSession.createQuery("from User user where user.login = :login", User.class);
            query.setParameter("login", login);
        }

        try(Session newSession = sessionFactory.openSession()) {
            Query<User> query2 = newSession.createQuery("from User user where user.login = :login", User.class);
            query2.setParameter("login", login);
            return query2.getResultStream().findAny();
        }
    }

    @Override
    public void createNewUser() {
        User user = new User();
        String vitr = "vitr";
        user.setLogin(vitr);
        user.setUserName("Vitalii");
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword("qwerty");

        try(Session currentSession = sessionFactory.openSession()) {
            Transaction transaction = currentSession.beginTransaction();
            currentSession.save(user);
            currentSession.flush();
            transaction.commit();
        }

        try (Session currentSession2 = sessionFactory.openSession()) {
            Transaction tran = currentSession2.beginTransaction();
            Query<User> query = currentSession2.createQuery("from User where login = :login", User.class);
            query.setParameter("login", vitr);
            User singleResult = query.getSingleResult();
            log.info("User %s".formatted(singleResult));
            tran.commit();
        }

        user.setUserName("Vitalii Ivanov");
    }
}

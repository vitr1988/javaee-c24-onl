package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Phone;
import by.teachmeskills.lesson39.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j
@Repository
@Transactional(readOnly = true)//(noRollbackFor = RuntimeException.class)
@RequiredArgsConstructor
public class JpaUserDao implements UserDao {

    //    private final SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    private final PhoneDao phoneDao;
    private final AuthorityDao authorityDao;

    @Override
    @Transactional
    public void save(User user) {
//        Session currentSession = sessionFactory.getCurrentSession();
        if (user.getId() == null) {
//            Phone savedPhone = phoneDao.save(new Phone("77777777"));
            Phone savedPhone = new Phone("495", "77777777");
            savedPhone.setUser(user);
            user.setAuthority(authorityDao.save(user.getAuthority()));
//            user.getPhones().add(savedPhone);
            phoneDao.save(savedPhone);
//            currentSession.save(user);
            entityManager.persist(user);
            log.info("user %s".formatted(user));
        } else {
//            currentSession.update(user);
            entityManager.merge(user);
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
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.remove(user);
        entityManager.remove(user);
    }

    @Override
    public User findById(UUID id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Optional<User> findById(Long id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Optional<User> user = Optional.ofNullable(entityManager.find(User.class, id));
//        Optional<User> user = Optional.ofNullable(currentSession.get(User.class, id));
//        user.map(User::getAuthority).ifPresent(log::info);
//        List<Phone> phones = user.get().getPhones();
//        Query<User> query = currentSession.createQuery(
        TypedQuery<User> query = entityManager.createQuery(
                """
                            select user from User user
                            join fetch user.authority
                            left join fetch user.phones
                            where user.id = :id
                        """, User.class);
        query.setParameter("id", id);
//        return Optional.ofNullable(query.getSingleResult());
        return query.getResultStream().findAny();
    }

    @Override
//    @Transactional(readOnly = true)
    public Optional<User> findByLogin(String login) {
//        try(Session currentSession = sessionFactory.openSession()) {
//            Query<User> query = currentSession.createQuery("from User user where user.login = :login", User.class);
//            query.setParameter("login", login);
//        }
//
//        try(Session newSession = sessionFactory.openSession()) {
//            Query<User> query2 = newSession.createQuery("from User user where user.login = :login", User.class);
//            query2.setParameter("login", login);
//            return query2.getResultStream().findAny();
//        }

        TypedQuery<User> query = entityManager.createQuery("select user from User user where user.login = :login", User.class);
        query.setParameter("login", login);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void createNewUser() {
        User user = new User();
        String vitr = "vitr";
        user.setLogin(vitr);
        user.setUserName("Vitalii");
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword("qwerty");

//        try(Session currentSession = sessionFactory.openSession()) {
        EntityTransaction transaction = entityManager.getTransaction();
//        Transaction transaction = currentSession.beginTransaction();
        entityManager.persist(user);
        entityManager.flush();
        transaction.commit();
//    }
//        try (Session currentSession2 = sessionFactory.openSession()) {
        transaction = entityManager.getTransaction();
//        Transaction tran = currentSession2.beginTransaction();
        TypedQuery<User> query = entityManager.createQuery("select user from User user where user.login = :login", User.class);
        query.setParameter("login", vitr);
        User singleResult = query.getSingleResult();
        log.info("User %s".formatted(singleResult));
        transaction.commit();
//        }

        user.setUserName("Vitalii Ivanov");
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.selectAll", User.class);
        return query.getResultList();
    }
}

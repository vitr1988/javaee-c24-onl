package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class AuthorityDao {

//    private final SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Authority save(Authority authority) {
//        Session currentSession = sessionFactory.getCurrentSession();
        if (authority.getId() == null) {
            entityManager.persist(authority);
        } else {
            entityManager.merge(authority);
        }
        return authority;
    }
}

package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class PhoneDao {

    //    private final SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Phone save(Phone phone) {
//        Session currentSession = sessionFactory.getCurrentSession();
        if (phone.getId() == null) {
            entityManager.persist(phone);
        } else {
            entityManager.merge(phone);
        }
        return phone;
    }

}

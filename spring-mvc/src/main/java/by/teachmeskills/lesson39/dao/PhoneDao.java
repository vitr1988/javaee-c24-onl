package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Phone;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PhoneDao {

    private final SessionFactory sessionFactory;

    @Transactional
    public Phone save(Phone phone) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (phone.getId() == null) {
            currentSession.save(phone);
        } else {
            currentSession.update(phone);
        }
        return phone;
    }

}

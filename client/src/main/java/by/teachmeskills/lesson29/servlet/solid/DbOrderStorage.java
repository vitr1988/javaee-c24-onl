package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DbOrderStorage implements OrderStorage {

    private static OrderStorage orderStorage = new DbOrderStorage();

    public boolean save(Order order) {
//        DriverManager.getConnection("")
        return true;
    }

    public static OrderStorage getInstance() {
        return orderStorage;
    }
}

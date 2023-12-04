package lesson34.log.service;

import lesson34.log.dao.UserDao;
import lesson34.log.dto.UserDto;
import org.apache.log4j.Logger;

import java.util.Random;

public class UserService {

    //    private static final Logger LOGGER = Logger.getLogger(UserService.class.getSimpleName());
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(UserService.class);
    private static final UserDao userDao = new UserDao();

    public void save(UserDto userDto) {
//        LOGGER.log(Level.INFO, "try to save user " + userDto);
        LOGGER.info("try to save user " + userDto);
        try {
            userDao.save(userDto);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error("Exception happens", e);
        }
        if (new Random().nextBoolean()) {
//            LOGGER.log(Level.WARNING, "pay attention to user " + userDto);
            LOGGER.warn("pay attention to user " + userDto);
        } else {
//            LOGGER.log(Level.SEVERE, "error happens during user saving " + userDto);
            LOGGER.error("error happens during user saving " + userDto);
        }
    }
}

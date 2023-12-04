package lesson34.log;

import lesson34.log.dto.UserDto;
import lesson34.log.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

@Slf4j
public class LoggerRunner {

//    private static final Logger LOGGER = Logger.getLogger(LoggerRunner.class.getSimpleName());
    private static final Logger LOGGER = Logger.getLogger(LoggerRunner.class);

    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFullName("Vitaly Ivanov");
//        LOGGER.log(Level.INFO, userDto + "");
        LOGGER.info(userDto);
        userService.save(userDto);
    }
}

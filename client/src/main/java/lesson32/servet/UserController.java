package lesson32.servet;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson32.dto.UserDto;
import lesson32.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);

        Object object = userDto;
        Object array = new int[]{ 1, 2, 3};

        UserDto userFromDb = userService.save(userDto);
        setUserId(userFromDb);
        System.out.println(userFromDb);


        UserDto reflectionUser = createUser(25L, "Test test");
        UserDto reflectionUser2 = createUser(25L, "Test test");
        System.out.println(reflectionUser.equals(reflectionUser2));
    }

    private static void setUserId(UserDto userFromDb) {
        Class<? extends UserDto> userDtoClass = userFromDb.getClass();
        try {
            Field id = userDtoClass.getDeclaredField("id");
            id.setAccessible(true);
            id.set(userFromDb, 2L);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserDto createUser(Long userId, String userName) {
        Class<? extends UserDto> userDtoClass = UserDto.class;
        try {
            Constructor<? extends UserDto> constructor = userDtoClass.getConstructor(long.class, String.class);
            return constructor.newInstance(userId, userName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}

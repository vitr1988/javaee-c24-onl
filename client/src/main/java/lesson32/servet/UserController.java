package lesson32.servet;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson32.dto.UserDto;
import lesson32.entity.User;
import lesson32.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);
        UserDto userFromDb = userService.save(userDto);
        System.out.println(userFromDb);
    }
}

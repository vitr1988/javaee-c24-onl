package by.teachmeskills.lesson46.controller;

import by.teachmeskills.lesson46.config.JwtHelper;
import by.teachmeskills.lesson46.service.AuthenticationHandler;
import by.teachmeskills.lesson46.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@DisplayName("REST-контроллер для работы с пользователями должен ")
@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final String USERS_URI = "/api/users";

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private AuthenticationHandler authenticationHandler;

    @BeforeEach
    public void init() {
        Mockito.when(userService.getAll(any())).thenReturn(Collections.emptyList());
    }

    @WithMockUser(username = "admin", authorities = "ADMIN")
    @Test
    @DisplayName("уметь получать список всех пользователей")
    public void getUsers() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(USERS_URI)
                .accept(MediaType.APPLICATION_XML_VALUE)
        ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);
    }
}

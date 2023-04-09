package ma.learning.cicdimpl.controllers;

import ma.learning.cicdimpl.entities.User;
import ma.learning.cicdimpl.repositories.UserRepository;
import ma.learning.cicdimpl.services.UserService;
import ma.learning.cicdimpl.servicesImpl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;



    private UserService userService = Mockito.mock(UserServiceImpl.class);
    private UserRepository userRepository = Mockito.mock(UserRepository.class);


    private UserController userController;


    User userRecored1 = new User(1L,"mehdi Alilou", "mehdia@glaim.cm","pass");
    User userRecored2 = new User(2L,"mehdi Alilou2", "mehdia2@glaim.cm","pass2");
    User userRecored3 = new User(3L,"mehdi Alilou3", "mehdia@glaim.cm3","pass3");



    @BeforeEach
    void setUp() {


        MockitoAnnotations.openMocks(this);

        userController = new UserController(userService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    void getAllUsers() throws Exception {

        List<User> userList = new ArrayList<>(Arrays.asList(userRecored1,userRecored2,userRecored3));


        Mockito.when(userService.getAllUsers()).thenReturn(userList);

        assertEquals(3,userService.getAllUsers().size());


        mockMvc.perform(MockMvcRequestBuilders.get("/users").contentType(
                MediaType.APPLICATION_JSON
        )).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email",is("mehdia@glaim.cm")))
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                    .andDo(print());




    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
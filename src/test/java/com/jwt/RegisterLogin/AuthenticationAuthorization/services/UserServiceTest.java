package com.jwt.RegisterLogin.AuthenticationAuthorization.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jwt.RegisterLogin.AuthenticationAuthorization.models.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class UserServiceTest {
    @InjectMocks
    UserService userService;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testUserServiceConstructor() {

        List<User> users = userService.getUsers();
        assertNotNull(users);
        assertEquals(4, users.size());
    }
}
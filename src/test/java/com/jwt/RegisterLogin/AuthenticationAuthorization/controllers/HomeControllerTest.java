package com.jwt.RegisterLogin.AuthenticationAuthorization.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.*;

import com.jwt.RegisterLogin.AuthenticationAuthorization.models.User;
import com.jwt.RegisterLogin.AuthenticationAuthorization.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HomeControllerTest {
    @InjectMocks
    private HomeController homeController;
    @Mock
    UserService userService;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetUser() {
        // Create some dummy users
        List<User> dummyUsers = Arrays.asList(
                new User(UUID.randomUUID().toString(), "User1", "user1@example.com"),
                new User(UUID.randomUUID().toString(), "User2", "user2@example.com")
        );

        // Mock the userService.getUsers() method
        when(userService.getUsers()).thenReturn(dummyUsers);

        // Call the getUser() method
        List<User> result = homeController.getUser();

        // Assertions
        assertEquals(dummyUsers.size(), result.size());
    }
}

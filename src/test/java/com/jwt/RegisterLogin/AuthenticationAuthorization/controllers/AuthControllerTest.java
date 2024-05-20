package com.jwt.RegisterLogin.AuthenticationAuthorization.controllers;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

import com.jwt.RegisterLogin.AuthenticationAuthorization.models.JwtRequest;
import com.jwt.RegisterLogin.AuthenticationAuthorization.models.JwtResponse;
import com.jwt.RegisterLogin.AuthenticationAuthorization.models.User;
import com.jwt.RegisterLogin.AuthenticationAuthorization.security.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private AuthenticationManager manager;

    @Mock
    private JwtHelper helper;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Test
    public void testLogin() {
        // Mock user details
        User user = new User("testUser", "password", "test@gmail.com");
        // Mock JWT token
        String mockToken = "mockedToken";
    Authentication t = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);

        // Mocking authentication
        when(manager.authenticate(Mockito.any())).thenReturn(t);
        when(userDetailsService.loadUserByUsername(anyString())).thenReturn(userDetails);
        when(helper.generateToken(any(UserDetails.class))).thenReturn(mockToken);

        // Call the login method
        JwtRequest jwtRequest = new JwtRequest("testUser", "password");
        ResponseEntity<JwtResponse> responseEntity = authController.login(jwtRequest);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}

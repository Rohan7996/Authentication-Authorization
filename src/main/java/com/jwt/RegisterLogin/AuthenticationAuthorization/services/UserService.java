package com.jwt.RegisterLogin.AuthenticationAuthorization.services;

import com.jwt.RegisterLogin.AuthenticationAuthorization.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();
    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Rohan Saini","rohan@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Rishi Sharma","rishi@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Sonu Saini","sonu@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Gautam Saini","gautam@dev.in"));
    }
    public List<User> getUsers(){
        return this.store;
    }
}

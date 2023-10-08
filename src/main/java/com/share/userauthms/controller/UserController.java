package com.share.userauthms.controller;

import com.share.userauthms.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();
        User user = new User();
        users.add(user);

        User user1 = new User();
        users.add(user1);

        return users;
    }
}

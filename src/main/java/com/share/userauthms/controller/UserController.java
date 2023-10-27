package com.share.userauthms.controller;

import com.share.userauthms.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("usercontroller")
public class UserController {

    @Operation(summary = "Get Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "No users found",
                    content = @Content) })
    @GetMapping(value = "/users")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();
        User user = new User("devoamos");
        users.add(user);

        User user1 = new User("devoamos1");
        users.add(user1);

        return users;
    }

    @Operation(summary = "Get user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping(value = "/users/{userId}")
    public User getUsers(@PathVariable String userId) {
        return new User("devonte");
    }

    @PostMapping(value = "/users")
    public String createUser(@Valid @RequestBody User user){
        return "User created " + user.getUserName();
    }
}

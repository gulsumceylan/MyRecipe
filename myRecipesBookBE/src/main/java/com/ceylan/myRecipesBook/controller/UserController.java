package com.ceylan.myRecipesBook.controller;

import com.ceylan.myRecipesBook.entity.concrete.User;
import com.ceylan.myRecipesBook.entity.dto.UserDto;
import com.ceylan.myRecipesBook.entity.request.create.LoginRequest;
import com.ceylan.myRecipesBook.entity.request.create.RegisterRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteUserRequest;
import com.ceylan.myRecipesBook.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        super();
        this.userManager = userManager;
    }

    @PostMapping("/login")
    public User delete(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
        return this.userManager.login(loginRequest);
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest registerRequest) {
        return this.userManager.register(registerRequest);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userManager.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public UserDto getById(int userId) {
        return this.userManager.getById(userId);
    }

    @DeleteMapping("/delete")
    public User delete(@Valid @RequestBody DeleteUserRequest deleteUserRequest) {
        return this.userManager.delete(deleteUserRequest);
    }
}

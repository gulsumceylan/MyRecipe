package com.ceylan.myRecipesBook.service;

import com.ceylan.myRecipesBook.entity.concrete.User;
import com.ceylan.myRecipesBook.entity.dto.UserDto;
import com.ceylan.myRecipesBook.entity.request.create.LoginRequest;
import com.ceylan.myRecipesBook.entity.request.create.RegisterRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteUserRequest;
import com.ceylan.myRecipesBook.repository.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager {

    private final UserDao userDao;
    private ModelMapper modelMapper;

    public UserManager(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getAll() {
        List<User> users = this.userDao.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        return userDtos;
    }

    public UserDto getById(int id) {
        User user = this.userDao.getById(id);
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public User login(LoginRequest loginRequest) throws Exception {

        if (this.userDao.getByEmail(loginRequest.getEmail()) == null ||
                !this.userDao.getByEmail(loginRequest.getEmail()).getPassword().equals(loginRequest.getPassword())) {
            throw new Exception("Hatalı giriş.Bilgilerinizi kontrol edin.");
        } else {
            User user = modelMapper.map(loginRequest, User.class);
            return user;
        }
    }

    public User register(RegisterRequest registerRequest) {
        User user = modelMapper.map(registerRequest, User.class);
        this.userDao.save(user);
        return user;
    }

    public User delete(DeleteUserRequest deleteUserRequest) {
        User user = modelMapper.map(deleteUserRequest, User.class);
        this.userDao.delete(user);
        return user;
    }

}

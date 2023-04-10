package rikkei.academy.controller;

import rikkei.academy.model.User;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMP;

import java.util.List;

public class UserController {
    IUserService userService = new UserServiceIMP();
    public List<User> findAll (){
       return userService.findAll();
    }
    public void create(User user){
        userService.save(user);
    }
    public void update(User user){
        userService.save(user);
    }
    public User findById(int id){
       return userService.findById(id);
    }
    public User login(String username, String password){
        return userService.login(username, password);
    }
    public boolean changeStatus(int id){
        return userService.changeUserStatus(id);
    }
    public boolean checkUserNameExit(String userName){

        return userService.checkUserNameExit(userName);
    }

}

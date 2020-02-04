package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.User;
import edu.miu.cs.cs544.a202001.wind.domain.User;
import edu.miu.cs.cs544.a202001.wind.service.IUserService;
import edu.miu.cs.cs544.a202001.wind.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PostMapping(value = "/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(value = "/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping(value = "/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }


    public UserController() {
    }

    public IUserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}

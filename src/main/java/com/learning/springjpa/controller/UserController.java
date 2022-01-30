package com.learning.springjpa.controller;

import com.learning.springjpa.entities.UserAccount;
import com.learning.springjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void createUser(@RequestBody UserAccount userAccount){
        userService.addUser(userAccount);
    }

    @GetMapping("/{id}")
    public UserAccount fetchUser(@PathVariable Long id) {
        Optional<UserAccount> user = userService.fetchUser(id);
        if (user.isPresent()) {
            return user.get();
        } else { user.orElse(new UserAccount());
        }
        return null;
    }

    @GetMapping("/fetch/all")
    public List<UserAccount> getAllUserInfo(){
        return userService.fetchAllUsers();
    }

    @PutMapping("/{id}")
    public UserAccount updateUserDetail(@PathVariable Long id,@RequestBody UserAccount userAccount){
        return userService.updateUser(id,userAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}

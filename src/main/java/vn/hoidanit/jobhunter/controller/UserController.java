package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/")
    public User createNewUser(
        @RequestBody User postManUser)
        {

        User createUser = this.userService.handlerCreateUser(postManUser);

        return createUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id)
        {

        this.userService.handlerDeleteUser(id);

        return "delete user";
    }


   @GetMapping("/user/{id}")
   public User getUserById(@PathVariable long id) {
        // User getUser = this.userService.handlerGetUserById(id);   
    return this.userService.handlerGetUserById(id);
   }
    
   @GetMapping("/user")
   public List<User> getAllUser() {
        // User getUser = this.userService.handlerGetUserById(id);   
    return this.userService.fetchAllUser();
   }
   
}

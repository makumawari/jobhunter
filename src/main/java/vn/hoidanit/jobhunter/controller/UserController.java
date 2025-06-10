package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Create user
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(
        @RequestBody User postManUser)
        {
        User createUser = this.userService.handlerCreateUser(postManUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
        }

    // Delete user by id
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id)
        {
        this.userService.handlerDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    // Get user by id
   @GetMapping("/users/{id}")
   public ResponseEntity<User> getUserById(@PathVariable long id) {
    User getUser = this.userService.handlerGetUserById(id);   
    return ResponseEntity.status(HttpStatus.OK).body(getUser);
   }
    
    // Get all user
   @GetMapping("/users")
   public ResponseEntity<List<User>> getAllUser() {
        // User getUser = this.userService.handlerGetUserById(id);   
    return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser());
   }
   
   // Update user
   @PutMapping("/users")
   public ResponseEntity<User> updateUser(@RequestBody User user) {
    User updateUserVar = this.userService.handlerUpdateUser(user);   
    return ResponseEntity.status(HttpStatus.OK).body(updateUserVar);
   }   
}

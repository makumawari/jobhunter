package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User handlerCreateUser(User user){
        return this.userRepository.save(user);
    }

    public void handlerDeleteUser(long id){
        this.userRepository.deleteById(id);
    }

    public User handlerGetUserById(long id){
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
            
        }
        return null;
    }

    public List<User> fetchAllUser(){
        return this.userRepository.findAll();
    }    

    public User handlerUpdateUser(User reqUser){
        User currentUser = this.handlerGetUserById(reqUser.getId());
        if (currentUser != null) {
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setName(reqUser.getName());
            currentUser.setPassword(reqUser.getPassword());
            currentUser = this.userRepository.save(currentUser);
            
        }
        return currentUser;
    }

}


package com.ragainfotech.validation.service;

import com.ragainfotech.validation.dto.UserRequest;
import com.ragainfotech.validation.entity.User;
import com.ragainfotech.validation.exception.UserNotFoundException;
import com.ragainfotech.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
                userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user!= null){
            return user;
        }else {
            throw new UserNotFoundException("User not found for the given Id: "+id);
        }

    }
}

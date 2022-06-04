package com.homework.homework.user.service;

import com.homework.homework.user.UserRepository.UserRepository;
import com.homework.homework.user.domain.User;
import com.homework.homework.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long saveUser(UserDto userDto) {
        User user = new User(userDto.getNickname());
        return userRepository.save(user).getId();
    }

}

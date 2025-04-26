package com.triosss.userservice.service;

import com.triosss.userservice.dto.UserDto;
import com.triosss.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto createUser(User user);
    public UserDto getUserByContactNo(User user);
    public UserDto updateUser(User user);
    public UserDto deleteUser(String contactNo);

}

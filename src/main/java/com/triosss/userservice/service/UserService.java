package com.triosss.userservice.service;

import com.triosss.userservice.dto.UserDto;
import com.triosss.userservice.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User createUser(User user);
    public User getUserByContactNo(String contactNo);
    public User updateUser(User user);
    public boolean deleteUser(String contactNo);

}

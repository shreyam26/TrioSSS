package com.triosss.userservice.service;

import com.triosss.userservice.model.User;
import com.triosss.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService{

 @Autowired
 private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setPasswordExpiry(LocalDate.now().plusDays(30));
        return userRepository.save(user);

    }
//
    @Override
    public User getUserByContactNo(String contactNo) {
        return userRepository.findByContactNo(contactNo);

    }

    @Override
    public User updateUser(User user) {
        User us = userRepository.findByContactNo(user.getContactNo());
        us.setName(user.getName());
        us.setAddress(user.getAddress());
        us.setContactNo(user.getContactNo());
        us.setUserType(user.getUserType());
        us.setEmailId(user.getEmailId());
        us.setPassword(user.getPassword());
        us.setModifiedTime(LocalDate.now());
        User modifiedUser = userRepository.save(us);

        return userRepository.save(modifiedUser);
    }

    @Override
    public boolean deleteUser(String contactNo) {
        userRepository.deleteByContactNo(contactNo);
        return true;
    }
}

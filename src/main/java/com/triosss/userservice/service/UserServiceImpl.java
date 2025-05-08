package com.triosss.userservice.service;

import com.triosss.userservice.model.User;
import com.triosss.userservice.passwordEncoder.AESUtil;
import com.triosss.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService{



 @Autowired
 private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        System.out.println(user.toString());
        user.setPasswordExpiry(LocalDate.now().plusDays(30));
        String hashedPassword = null;
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            hashedPassword = AESUtil.encrypt(user.getPassword());
            System.out.println(hashedPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        user.setPassword(hashedPassword);


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
        try {
            us.setPassword(AESUtil.encrypt(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error = "+e.getMessage());
        }
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

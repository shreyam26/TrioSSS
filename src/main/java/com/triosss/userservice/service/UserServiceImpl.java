package com.triosss.userservice.service;

import com.triosss.userservice.dto.DtoToObject;
import com.triosss.userservice.dto.UserDto;
import com.triosss.userservice.model.User;
import com.triosss.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public UserDto createUser(User user) {
        User user1 = userRepository.save(user);
        return new DtoToObject().convertUserToUserDto(user1, new UserDto());

    }

    @Override
    public UserDto getUserByContactNo(User user) {
        User user2 = userRepository.findByContactNo(user.getContactNo());
        return new DtoToObject().convertUserToUserDto(user2, new UserDto());
    }

    @Override
    public UserDto updateUser(User user) {
        return null;
    }

    @Override
    public UserDto deleteUser(String contactNo) {

        User user3 = userRepository.deleteByContactNo(contactNo);
        return new DtoToObject().convertUserToUserDto(user3, new UserDto());
    }
}

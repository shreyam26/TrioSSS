package com.triosss.userservice.dto;

import com.triosss.userservice.model.User;

public class DtoToObject {

    public UserDto convertUserToUserDto(User user, UserDto userDto){
        userDto.setName(user.getName());
        userDto.setContactNo(user.getContactNo());
        userDto.setEmailId(user.getEmailId());

        return userDto;
    }


}

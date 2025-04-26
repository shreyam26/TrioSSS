package com.triosss.userservice.controller;

import com.triosss.userservice.dto.UserDto;
import com.triosss.userservice.model.User;
import com.triosss.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/getUser")
    public ResponseEntity<UserDto> getUser(@Valid @RequestBody User user){
        UserDto userDto = this.userService.getUserByContactNo(user);
        if(userDto == null)
            new UserDto().setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(userDto);
    }


    @PostMapping(value = "/createUser")
    private ResponseEntity<UserDto> createUser(@RequestBody User user){

        UserDto userDto = this.userService.createUser(user);
        userDto.setStatus(CREATED);

        return ResponseEntity.ok().body(userDto);

    }



    @PostMapping(value = "/deleteUser")
    private ResponseEntity<UserDto> deleteUser(@Valid @PathVariable String contactNo){
        UserDto userDto = userService.deleteUser(contactNo);
        userDto.setStatus(CREATED);
        return ResponseEntity.ok().body(userDto);
    }
}

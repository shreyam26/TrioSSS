package com.triosss.userservice.controller;

import com.triosss.userservice.dto.UserDto;
import com.triosss.userservice.model.User;
import com.triosss.userservice.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.CREATED;



@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

  @Autowired
   private UserService userService;

   @GetMapping(value = "/getUser")
   public ResponseEntity<UserDto> getUser(@RequestParam String contactNo){
        User user2 = userService.getUserByContactNo(contactNo);
        UserDto userDto = modelMapper.map(user2,UserDto.class);
        if(userDto != null)
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDto);
   }


    @PostMapping("/createUser")
    private ResponseEntity<UserDto> createUser(@Valid @RequestBody User user){

        User user1 = userService.createUser(user);
        UserDto userDto = modelMapper.map(user1,UserDto.class);
        if(user1 != null)
        return ResponseEntity.status(CREATED).body(userDto);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDto);
    }


    @DeleteMapping(value = "/deleteUser")
    private HttpStatus deleteUser(@RequestParam @Valid String contactNo){


        User user4 = userService.getUserByContactNo(contactNo);

        if(user4 != null)
         userService.deleteUser(user4.getContactNo());
        else
            return HttpStatus.NOT_FOUND;

        return HttpStatus.OK;

    }

    @PutMapping(value = "/updateUser")
    private ResponseEntity<UserDto> updateUser(@Valid @RequestBody User user){
       User user5 = userService.updateUser(user);
       UserDto dto = modelMapper.map(user5,UserDto.class);
       return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
}

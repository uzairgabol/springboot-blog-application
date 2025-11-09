package com.uzairgabol.blog.controllers;

import com.uzairgabol.blog.payloads.ApiResponse;
import com.uzairgabol.blog.payloads.UserDto;
import com.uzairgabol.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updateUserDto = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUserDto);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserbyId(@PathVariable int userId){
        UserDto user = this.userService.getUserbyId(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

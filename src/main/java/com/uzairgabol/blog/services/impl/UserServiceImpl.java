package com.uzairgabol.blog.services.impl;

import com.uzairgabol.blog.entities.User;
import com.uzairgabol.blog.exceptions.ResourceNotFoundException;
import com.uzairgabol.blog.payloads.UserDto;
import com.uzairgabol.blog.repositories.UserRepo;
import com.uzairgabol.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User convertedUser = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(convertedUser);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserbyId(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        return this.userRepo.findAll()
                .stream()
                .map(this::userToDto)
                .toList();
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }


    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;
    }


    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId((user.getId()));
        userDto.setName((user.getName()));
        userDto.setEmail((user.getEmail()));
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());

        return userDto;
    }
}

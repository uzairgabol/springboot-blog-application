package com.uzairgabol.blog.services;

import com.uzairgabol.blog.payloads.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, int id);
    UserDto getUserbyId(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(int userId);

}

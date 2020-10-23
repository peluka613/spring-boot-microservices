package edu.spring.boot.api.users.services;

import edu.spring.boot.api.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}

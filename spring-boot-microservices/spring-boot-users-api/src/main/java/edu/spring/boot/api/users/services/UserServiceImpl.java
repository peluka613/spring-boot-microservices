package edu.spring.boot.api.users.services;

import edu.spring.boot.api.users.model.data.User;
import edu.spring.boot.api.users.repository.UserRepository;
import edu.spring.boot.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userDto, User.class);

        user.setEncryptedPassword("test");
        userRepository.save(user);

        userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }
}

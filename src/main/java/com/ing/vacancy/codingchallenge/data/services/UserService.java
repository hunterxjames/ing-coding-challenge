package com.ing.vacancy.codingchallenge.data.services;

import com.ing.vacancy.codingchallenge.data.entities.Role;
import com.ing.vacancy.codingchallenge.data.entities.User;
import com.ing.vacancy.codingchallenge.data.repositories.UserRepository;
import com.ing.vacancy.codingchallenge.dto.UserCredentialsDto;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import com.ing.vacancy.codingchallenge.dto.mapper.UserMapper;
import com.ing.vacancy.codingchallenge.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserService implements IUserService{

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto retrieve(long id) {
        User user = getUserById(id);
        return userMapper.convertToDto(user);
    }

    @Transactional
    @Override
    public UserDto update(UserDto userDto, long id) {
        log.info("Updating user details: {}", userDto);
        User user = getUserById(id);
        userMapper.copyProperties(userDto, user);
        User updatedUser = userRepository.save(user);
        UserDto updatedUserDto = userMapper.convertToDto(updatedUser);
        log.info("Updated user details: {}", updatedUserDto);
        return updatedUserDto;
    }

    @Override
    public UserCredentialsDto getByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()){
            return null;
        }
        User user = userOptional.get();
        return UserCredentialsDto.builder()
                .username(user.getUsername())
                .passwordSupplier(() -> user.getPassword())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .build();

    }

    private User getUserById(long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}

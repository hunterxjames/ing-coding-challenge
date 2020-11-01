package com.ing.vacancy.codingchallenge.data.services;

import com.ing.vacancy.codingchallenge.data.entities.Address;
import com.ing.vacancy.codingchallenge.data.entities.User;
import com.ing.vacancy.codingchallenge.data.repositories.UserRepository;
import com.ing.vacancy.codingchallenge.dto.AddressDto;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import com.ing.vacancy.codingchallenge.dto.mapper.UserMapper;
import com.ing.vacancy.codingchallenge.exceptions.UserNotFoundException;
import com.ing.vacancy.codingchallenge.util.TestUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService subject;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    public void testRetrieve_NotFound(){
        long userId = 1l;
        doReturn(Optional.empty()).when(userRepository).findById(userId);
        assertThrows(UserNotFoundException.class, () -> subject.retrieve(1l));
    }

    @Test
    public void testRetrieve_Found(){
        long userId = 1l;
        User user = TestUtility.createUser(userId);

        doReturn(Optional.of(user)).when(userRepository).findById(userId);
        subject.retrieve(userId);
        verify(userMapper, times(1)).convertToDto(user);
    }

    @Test
    public void testUpdate_NotFound(){
        long userId = 1l;
        UserDto userDto = TestUtility.createUserDto();
        assertThrows(UserNotFoundException.class, () -> subject.update(userDto, userId));
    }

    @Test
    public void testUpdate_Found(){
        long userId = 1l;
        UserDto userDto = TestUtility.createUserDto();
        User user = TestUtility.createUser(userId);
        User updatedUser = TestUtility.createUser(userId);
        updatedUser.setLastName("Douglas");

        doReturn(Optional.of(user)).when(userRepository).findById(userId);
        doReturn(updatedUser).when(userRepository).save(user);
        UserDto result = subject.update(userDto, userId);
        verify(userMapper, times(1)).copyProperties(userDto, user);
        verify(userMapper, times(1)).convertToDto(updatedUser);
        verify(userRepository, times(1)).save(user);
    }






}
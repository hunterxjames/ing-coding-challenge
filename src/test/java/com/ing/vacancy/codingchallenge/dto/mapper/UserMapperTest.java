package com.ing.vacancy.codingchallenge.dto.mapper;

import com.ing.vacancy.codingchallenge.data.entities.Address;
import com.ing.vacancy.codingchallenge.data.entities.User;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import com.ing.vacancy.codingchallenge.util.TestUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @InjectMocks
    private UserMapper subject;

    @BeforeEach
    public void init(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        ReflectionTestUtils.setField(subject, "modelMapper", modelMapper);
    }

    @Test
    public void testConvertToDto(){
        User user = TestUtility.createUser(1);
        user.getAddress().setPostcode(null);
        UserDto userDto = subject.convertToDto(user);
        assertNotNull(userDto);
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getAddress().getCity(), userDto.getAddress().getCity());
    }

    @Test
    public void testCopyProperties(){
        String newFirstName = "Jane";
        String newTitle = "Ms";
        UserDto userDto = TestUtility.createUserDto();
        userDto.setFirstName(newFirstName);
        userDto.setTitle(newTitle);
        User user = TestUtility.createUser(1);
        subject.copyProperties(userDto, user);
        assertEquals(newFirstName, user.getFirstName());
        assertEquals(newTitle, user.getTitle());
        assertEquals("Doe", user.getLastName());
    }
}
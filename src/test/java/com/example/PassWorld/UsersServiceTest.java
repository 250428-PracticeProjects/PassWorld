package com.example.PassWorld;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PassWorld.models.Users;
import com.example.PassWorld.repositories.UsersRepository;
import com.example.PassWorld.services.UsersService;

@ExtendWith(MockitoExtension.class)
public class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    private Users user;

    @BeforeEach
    public void setUp () {
        user = new Users();

        user.setUserId(1L);
        user.setEmail("fake@mail.com");
        user.setPassword("1234564789");
    }
    

    @Test
    public void testFindUserById () {
        when(usersRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

        Users gotUser = assertDoesNotThrow(() -> usersService.finUserById(user.getUserId()));

        System.out.println(user.getUserId());
        System.out.println(gotUser.getUserId());
        assertEquals(1L, gotUser.getUserId());
        assertEquals(user.getEmail(), "fake@mail.com");

    }
}

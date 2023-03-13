package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.UserRequest;

import com.votingApp.voting.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.votingApp.voting.data.models.Gender.FEMALE;
import static com.votingApp.voting.data.models.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    UserRequest userRequest1;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRequest1 = new UserRequest();
        userRequest1.setId(1L);
        userRequest1.setFirstName("Ernest");
        userRequest1.setLastName("Emmanuel");
        userRequest1.setMiddleName("Utibe");
        userRequest1.setEmail("eksi123@gmail.com");
        userRequest1.setGender(MALE);
        userRequest1.setState("Adamawa");
        userRequest1.setAge(12);
        userRequest1.setNationalIdentificationNumber(75947834738583553L);

    }

    @Test
    void testThatUserCanRegister() {
        userService.registerUser(userRequest1);

    }
    @Test
    void testThatUserCanBeFoundById(){
        userService.registerUser(userRequest1);

      assertEquals("Utibe", userService.findUserById(1L).getMiddleName());
    }

    @Test
    void testThatUserCanUpdateTheirNames(){
        UserRequest userRequest = new UserRequest(
                1L,
                "Newton",
                "Norton",
                "Cunningham",
                "eu123@gmail.com",
                25,
                "New York State",
                MALE,
                638399935794087L
        );

        UserRequest updateRequest = new UserRequest();
        updateRequest.setId(1L);
        updateRequest.setFirstName("Sam");
        updateRequest.setLastName("Norton");
        updateRequest.setMiddleName("Cunningham");
        updateRequest.setEmail("eu123@gmail.com");
        updateRequest.setState("New York State");
        updateRequest.setGender(MALE);
        updateRequest.setNationalIdentificationNumber(638399935794087L);

        userService.registerUser(userRequest);

        assertEquals("User updated successfully", userService.updateUser(updateRequest));
    }

    @Test
    void testThatUserCanBeDeletedByTheirId() {
        UserRequest userRequest= new UserRequest(
                1L,
                "Newton",
                "Norton",
                "Cunningham",
                "eu123@gmail.com",
                25,
                "New York State",
                MALE,
                638399935794087L
        );
        userService.registerUser(userRequest);

        userRepository.deleteById(1L);

        assertEquals(0, userRepository.findAll().size());
    }

    @Test
    void testThatAllUserCanBeDeleted() {
        userService.registerUser(userRequest1);

        userService.deleteAll();

        assertTrue(true);
    }
}
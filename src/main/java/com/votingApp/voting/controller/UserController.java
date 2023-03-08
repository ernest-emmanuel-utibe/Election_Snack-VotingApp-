package com.votingApp.voting.controller;

import com.votingApp.voting.data.dto.request.UserRequest;
import com.votingApp.voting.data.dto.response.ApiResponse;
import com.votingApp.voting.exception.GlobalException;
import com.votingApp.voting.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        try{
            var response = userService.registerUser(userRequest);
            return ResponseEntity.ok(response);
        }catch (GlobalException e){
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .message(e.getMessage())
                            .build()

            );
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        var foundUser = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserRequest updatedUser) {
        updatedUser.setId(id);
        userService.updateUser(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    @PostMapping("api/v1/castVote")
//    public String castVote(@RequestBody UserRequest userRequest){
//
//    }




}

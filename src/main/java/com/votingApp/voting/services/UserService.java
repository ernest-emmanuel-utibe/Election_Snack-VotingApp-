package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.UserRequest;
import com.votingApp.voting.data.models.User;

public interface UserService {
    User registerUser(UserRequest userRequest);

    User getUserById(Long userId);
     String updateUser(UserRequest updatedUser);

     void deleteUserById(Long id);

     void deleteAll();

    long countUsers();

    User findUserById(long id);
}

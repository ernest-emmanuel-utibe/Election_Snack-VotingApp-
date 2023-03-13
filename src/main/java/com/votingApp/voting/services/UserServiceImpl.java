package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.UserRequest;
import com.votingApp.voting.data.models.User;
import com.votingApp.voting.data.repositories.UserRepository;
import com.votingApp.voting.exception.GlobalException;
import com.votingApp.voting.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
//@Slf4j
@Data
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User registerUser(UserRequest userRequest) throws GlobalException {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setMiddleName(userRequest.getMiddleName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setAge(userRequest.getAge());
        user.setGender(userRequest.getGender());
        user.setNationalIdentificationNumber(userRequest.getNationalIdentificationNumber());
        User savedUser = userRepository.save(user);
        user.message("Registration successful");
        return savedUser;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException(
                        String.format("User with id %d is not found", userId)));
    }

    @Override
    public String updateUser(UserRequest updatedUser) {
        Optional<User> userOptional = userRepository.findById(updatedUser.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserId(updatedUser.getId());
            user.setFirstName(updatedUser.getFirstName());
            user.setMiddleName(updatedUser.getMiddleName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setState(updatedUser.getState());
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found with ID: " + updatedUser.getId());
        }
        return "User updated successfully";
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(()->  new IllegalStateException("User not found"));
    }
}

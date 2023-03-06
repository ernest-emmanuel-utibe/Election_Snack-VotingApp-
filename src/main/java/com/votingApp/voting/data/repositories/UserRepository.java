package com.votingApp.voting.data.repositories;

import com.votingApp.voting.data.dto.request.UserRequest;
import com.votingApp.voting.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
//    String update(UserRequest userRequest);

//    int findUserById(long id);
}

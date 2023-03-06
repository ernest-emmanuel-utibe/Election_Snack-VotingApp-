package com.votingApp.voting.data.repositories;

import com.votingApp.voting.data.models.VoterRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface VoterRegistrationRepository extends JpaRepository<VoterRegistration, Long> {
//    int save();
}

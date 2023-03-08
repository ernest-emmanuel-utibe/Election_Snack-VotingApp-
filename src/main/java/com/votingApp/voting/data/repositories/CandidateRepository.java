package com.votingApp.voting.data.repositories;

import com.votingApp.voting.data.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
//    int save();
}

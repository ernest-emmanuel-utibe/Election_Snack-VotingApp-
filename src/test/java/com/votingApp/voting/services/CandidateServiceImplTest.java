package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.CandidateRequest;
import com.votingApp.voting.data.dto.response.Response;
import com.votingApp.voting.data.repositories.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.votingApp.voting.data.models.Party.APC;
import static com.votingApp.voting.data.models.Party.LP;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CandidateServiceImplTest {
    @Autowired
    private CandidateService candidateService;

    private CandidateRequest candidateRequest;

    @Autowired
    private CandidateRepository candidateRepository;

    @BeforeEach
    void setUp() {}

    @Test
    void candidateRegistrationTest() {
        candidateRequest = new CandidateRequest();
        candidateRequest.setName("John Maxwell");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(29383746478982839L);
        candidateRequest.setCandidateName("Peter Obi");
        candidateRequest.setLocalDateTime(LocalDateTime.now());
        Response response = candidateService.voterRegistration(candidateRequest);
        assertEquals("Voter successfully registered",  response.getMessage());
    }

    @Test
    void castVote() {
        candidateRequest = new CandidateRequest();
        candidateRequest.setName("John Maxwell");
        candidateRequest.setCandidateName("Peter Obi");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(75847366474735347L);
        candidateService.castVote(candidateRequest);

        assertEquals("Peter Obi", candidateRepository.findById(1L).get().getCandidateName());
    }

    @Test
    void testThatVotesCanBeFoundById() {
        candidateRequest = new CandidateRequest();
        candidateRequest.setName("John Maxwell");
        candidateRequest.setCandidateName("Peter Obi");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(75847366474735347L);
        candidateService.castVote(candidateRequest);

        assertEquals("Peter Obi", candidateRepository.findById(1L).get().getCandidateName());
    }

    @Test
    void testThatVotesCanBeDeletedById() {
        candidateRequest = new CandidateRequest();
        candidateRequest.setName("John Maxwell");
        candidateRequest.setCandidateName("Peter Obi");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(75847366474735347L);
        candidateService.castVote(candidateRequest);
        candidateRepository.deleteById(1L);
        assertEquals(0, candidateRepository.findAll().size());
    }


}
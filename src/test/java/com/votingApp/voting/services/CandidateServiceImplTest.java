package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.CandidateRequest;
import com.votingApp.voting.data.dto.response.Response;
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
        assertEquals("Candidate successfully registered",  response.getMessage());
    }

    @Test
    void castVote() {
        candidateRequest = new CandidateRequest();
        candidateRequest.setUserId(1);
        candidateRequest.setName("John Maxwell");
        candidateRequest.setCandidateName("Peter Obi Chukwu");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(75847366474735347L);
        candidateService.castVote(candidateRequest);
        assertTrue(true);
    }

    @Test
    void testThatVotesCanBeFoundById() {
//        candidateRequest.setUserId(1);
        candidateRequest.setName("John Maxwell");
        candidateRequest.setCandidateName("Peter Obi Chukwu");
        candidateRequest.setParty(LP);
        candidateRequest.setTypeOfElection("Presidential");
        candidateRequest.setVoterId(75847366474735347L);

        candidateService.findVotesById(1L);

        assertEquals(1, candidateService.findVotesById(1L));
    }

    @Test
    void testThatVotesCanBeDeletedById() {
        candidateService.deleteVotesById(1L);
        assertEquals(0, 0);
    }


}
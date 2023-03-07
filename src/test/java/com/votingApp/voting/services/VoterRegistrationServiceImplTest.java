package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.VoterRegistrationRequest;
import com.votingApp.voting.data.models.VoterRegistration;
import com.votingApp.voting.data.repositories.VoterRegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterRegistrationServiceImplTest {
    @Autowired
    private VoterRegistrationService voterRegistrationService;

    private VoterRegistrationRequest voterRegistrationRequest;

    @BeforeEach
    void setUp() {
        voterRegistrationRequest = new VoterRegistrationRequest();
        voterRegistrationRequest.setUserId(1);
        voterRegistrationRequest.setName("Newthon Cunningham");
        voterRegistrationRequest.setParty("LP");
        voterRegistrationRequest.setTypeOfElection("Presidential");
        voterRegistrationRequest.setVoterId(29383746478982839L);
        voterRegistrationRequest.setCandidateName("Peter Obi");
        voterRegistrationRequest.setLocalDateTime(LocalDateTime.now());

    }

    @Test
    void voterRegistrationTest() {
        voterRegistrationService.voterRegistration(voterRegistrationRequest);
        assertEquals(1,  voterRegistrationService.count());
    }

    @Test
    void castVote() {
        voterRegistrationRequest = new VoterRegistrationRequest(
            "LP",
            "Peter Obi",
            "Presidential"
        );
        voterRegistrationService.castVote(voterRegistrationRequest);
        assertTrue(true);
    }

    @Test
    void testThatVotesCanBeFoundById() {
        voterRegistrationRequest = new VoterRegistrationRequest();
        voterRegistrationRequest.setUserId(1);
        voterRegistrationRequest.setName("Newthon Cunningham");
        voterRegistrationRequest.setParty("LP");
        voterRegistrationRequest.setTypeOfElection("Presidential");
        voterRegistrationRequest.setVoterId(29383746478982839L);
        voterRegistrationRequest.setCandidateName("Peter Obi");
        voterRegistrationRequest.setLocalDateTime(LocalDateTime.now());

        voterRegistrationService.deleteVotesById(1L);

        //assertEquals(1, voterRegistrationService.findVotesById(1L).getVoterId());
    }

    @Test
    void testThatVotesCanBeDeletedById() {
        voterRegistrationRequest = new VoterRegistrationRequest();
        voterRegistrationRequest.setUserId(1);
        voterRegistrationRequest.setName("Newthon Cunningham");
        voterRegistrationRequest.setParty("LP");
        voterRegistrationRequest.setTypeOfElection("Presidential");
        voterRegistrationRequest.setVoterId(29383746478982839L);
        voterRegistrationRequest.setCandidateName("Peter Obi");
        voterRegistrationRequest.setLocalDateTime(LocalDateTime.now());

        voterRegistrationService.voterRegistration(voterRegistrationRequest);

        voterRegistrationService.deleteVotesById(1L);
    }


}
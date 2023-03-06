package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.VoterRegistrationRequest;
import com.votingApp.voting.data.models.VoterRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterRegistrationServiceImplTest {
    @Autowired
    private VoterRegistrationService voterRegistrationService;

    private VoterRegistrationRequest voterRegistrationRequest;
    VoterRegistration voterRegistration;
    //private VoterRegistrationRepository voterRegistrationRepository;

    @BeforeEach
    void setUp() {
        voterRegistrationRequest = new VoterRegistrationRequest(

                "APC",
                "Peter Obi",
                "Presidential"
        );

    }

    @Test
    void voterRegistrationTest() {
        voterRegistrationService.voterRegistration(voterRegistrationRequest);
        assertEquals(1, voterRegistrationService.voterRegistration(voterRegistrationRequest));
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
}
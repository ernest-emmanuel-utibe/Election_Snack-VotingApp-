package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.VoterRegistrationRequest;
import com.votingApp.voting.data.models.VoterRegistration;

public interface VoterRegistrationService {
    VoterRegistration voterRegistration(VoterRegistrationRequest voterRegistrationRequest);
    void castVote(VoterRegistrationRequest voterRegistrationRequest);
}

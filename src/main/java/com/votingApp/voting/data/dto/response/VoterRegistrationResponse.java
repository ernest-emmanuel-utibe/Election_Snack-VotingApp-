package com.votingApp.voting.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class VoterRegistrationResponse {
    private String userId;
    private String party;
    private String candidateName;
    private String typeOfElection;
}

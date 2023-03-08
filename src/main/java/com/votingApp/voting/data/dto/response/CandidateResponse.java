package com.votingApp.voting.data.dto.response;

import com.votingApp.voting.data.models.Party;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CandidateResponse {
    private String userId;
    private Party party;
    private String candidateName;
    private String typeOfElection;
}

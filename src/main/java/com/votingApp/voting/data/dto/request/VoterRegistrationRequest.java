package com.votingApp.voting.data.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class VoterRegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String party;
    private String name;
    private long voterId;
    private String candidateName;
    private String typeOfElection;
    private LocalDateTime localDateTime;

    public VoterRegistrationRequest(String party, String candidateName, String typeOfElection) {
//        this.userId = userId;
        this.party = party;
        this.candidateName = candidateName;
        this.typeOfElection = typeOfElection;
        this.localDateTime = LocalDateTime.now();
    }
}

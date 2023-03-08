package com.votingApp.voting.data.dto.request;

import com.votingApp.voting.data.models.Party;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class CandidateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private Party party;
    private String name;
    private long voterId;
    private String candidateName;
    private String typeOfElection;
    private LocalDateTime localDateTime;

//    public CandidateRequest(Party party, String candidateName, String typeOfElection) {
////        this.userId = userId;
//        this.party = party;
//        this.candidateName = candidateName;
//        this.typeOfElection = typeOfElection;
//        this.localDateTime = LocalDateTime.now();
//    }
}

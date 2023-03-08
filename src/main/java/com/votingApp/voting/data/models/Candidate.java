package com.votingApp.voting.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private Party party;
    private String candidateName;
    private long voterId;
    private String typeOfElection;
    private LocalDateTime localDateTime;
}

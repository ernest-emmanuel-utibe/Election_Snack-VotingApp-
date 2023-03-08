package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.CandidateRequest;
import com.votingApp.voting.data.dto.response.Response;
import com.votingApp.voting.data.models.Candidate;
import com.votingApp.voting.data.repositories.CandidateRepository;
import com.votingApp.voting.data.repositories.UserRepository;
import com.votingApp.voting.exception.GlobalException;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@ToString
@Slf4j
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    @Override
    public Response voterRegistration(CandidateRequest candidateRequest) throws GlobalException {
        Candidate candidate = new Candidate();
//        voterRegistration.setUserId(voterRegistrationRequest.getUserId());
        candidate.setVoterId(candidateRequest.getVoterId());
        candidate.setCandidateName(candidateRequest.getCandidateName());
        candidate.setTypeOfElection(candidateRequest.getTypeOfElection());
        candidate.setLocalDateTime(candidateRequest.getLocalDateTime());
        candidateRepository.save(candidate);
        Response response = new Response();
        response.setId(candidate.getUserId());
        response.setStatusCode(201);
        response.setMessage("Voter successfully registered");
        return response;
    }

    @Override
    public void castVote(CandidateRequest candidateRequest) {
       Candidate candidate = new Candidate();
       candidate.setUserId(candidate.getUserId());
       candidate.setParty(candidateRequest.getParty());
       candidate.setTypeOfElection(candidateRequest.getTypeOfElection());
       candidate.setLocalDateTime(candidateRequest.getLocalDateTime());
       candidateRepository.save(candidate);
       candidateRepository.count();
    }

    @Override
    public Candidate findVotesById(long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new IllegalStateException("Votes not found"));
    }

    @Override
    public void deleteVotesById(long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public long count() {
        return candidateRepository.count();
    }

    @Override
    public void deleteAllVotes() {
        candidateRepository.deleteAll();
    }

}

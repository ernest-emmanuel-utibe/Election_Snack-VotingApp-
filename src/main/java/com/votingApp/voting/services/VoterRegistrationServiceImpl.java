package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.VoterRegistrationRequest;
import com.votingApp.voting.data.models.VoterRegistration;
import com.votingApp.voting.data.repositories.VoterRegistrationRepository;
import com.votingApp.voting.exception.GlobalException;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@ToString
@Slf4j
public class VoterRegistrationServiceImpl implements VoterRegistrationService{
    private final VoterRegistrationRepository voterRegistrationRepository;

    @Override
    public VoterRegistration voterRegistration(VoterRegistrationRequest voterRegistrationRequest) throws GlobalException {
        VoterRegistration voterRegistration = new VoterRegistration();
        voterRegistration.setUserId(voterRegistrationRequest.getUserId());
        voterRegistration.setName(voterRegistrationRequest.getName());
        voterRegistration.setVoterId(voterRegistrationRequest.getVoterId());
        voterRegistration.setCandidateName(voterRegistrationRequest.getCandidateName());
        voterRegistration.setTypeOfElection(voterRegistrationRequest.getTypeOfElection());
        voterRegistration.setLocalDateTime(voterRegistrationRequest.getLocalDateTime());
        VoterRegistration savedVoterRegistration = voterRegistrationRepository.save(voterRegistration);
        voterRegistration.message("Voter successfully registered");
        return savedVoterRegistration;
    }

    @Override
    public void castVote(VoterRegistrationRequest voterRegistrationRequest) {
       VoterRegistration voterRegistration = new VoterRegistration();
       voterRegistration.setUserId(voterRegistration.getUserId());
       voterRegistration.setParty(voterRegistrationRequest.getParty());
       voterRegistration.setTypeOfElection(voterRegistrationRequest.getTypeOfElection());
       voterRegistration.setLocalDateTime(voterRegistrationRequest.getLocalDateTime());
       voterRegistrationRepository.save(voterRegistration);
       voterRegistrationRepository.count();
    }

    @Override
    public VoterRegistration findVotesById(Long id) {
        return voterRegistrationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Votes not found"));
    }

    @Override
    public long count() {
        return voterRegistrationRepository.count();
    }

    @Override
    public void deleteVotesById(Long id) {
        voterRegistrationRepository.deleteById(id);
    }

    @Override
    public void deleteAllVotes() {
        voterRegistrationRepository.deleteAll();
    }

}

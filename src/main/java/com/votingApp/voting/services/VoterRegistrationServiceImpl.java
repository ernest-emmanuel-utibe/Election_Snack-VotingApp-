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
//    @Autowired
//   private  VoterRegistration voterRegistration;
    @Override
    public VoterRegistration voterRegistration(VoterRegistrationRequest voterRegistrationRequest) throws GlobalException {
        VoterRegistration voterRegistration = new VoterRegistration();
        voterRegistration.setUserId(Long.valueOf(voterRegistrationRequest.getUserId()));
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
}

package com.votingApp.voting.services;

import com.votingApp.voting.data.dto.request.CandidateRequest;
import com.votingApp.voting.data.dto.response.Response;
import com.votingApp.voting.data.models.Candidate;

import java.util.List;

public interface CandidateService {
    Response voterRegistration(CandidateRequest candidateRequest);

    void castVote(CandidateRequest candidateRequest);
    List<Candidate> getAllCandidates();

    long count();

    void deleteAllVotes();

    Candidate findVotesById(long id);

    void deleteVotesById(long id);
}

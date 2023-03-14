package com.votingApp.voting.controller;

import com.votingApp.voting.data.dto.request.CandidateRequest;
import com.votingApp.voting.data.dto.response.ApiResponse;
import com.votingApp.voting.data.models.Candidate;
import com.votingApp.voting.exception.GlobalException;
import com.votingApp.voting.services.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/candidate")
public class CandidateController {
    private CandidateService candidateService;
    @PostMapping("/register")
    public ResponseEntity<?> votersRegister(@RequestBody CandidateRequest request)  {
        try{
            var response = candidateService.voterRegistration(request);
            return ResponseEntity.ok(response);
        }catch (GlobalException e){
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .message(e.getMessage())
                            .build()
            );
        }
    }

    @GetMapping("/votesCasted")
    public ResponseEntity<?> voterCastVote(CandidateRequest request) {
        candidateService.castVote(request);
        return (ResponseEntity<?>) candidateService;
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVoteById(@PathVariable("id") Long id) {
        candidateService.deleteVotesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

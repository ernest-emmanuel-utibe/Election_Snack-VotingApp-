package com.votingApp.voting.controller;

import com.votingApp.voting.data.dto.request.VoterRegistrationRequest;
import com.votingApp.voting.data.dto.response.ApiResponse;
import com.votingApp.voting.data.dto.response.VoterRegistrationResponse;
import com.votingApp.voting.exception.GlobalException;
import com.votingApp.voting.services.VoterRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voting")
public class VoterController {
//    @Autowired
    private VoterRegistrationService voterRegistrationService;
    @PostMapping("/register")
    public ResponseEntity<?> votersRegister(@RequestBody VoterRegistrationRequest request)  {
        try{
            var response = voterRegistrationService.voterRegistration(request);
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
    public ResponseEntity<?> voterCastVote(VoterRegistrationRequest request) {
        voterRegistrationService.castVote(request);
        return (ResponseEntity<?>) voterRegistrationService;
    }

}

package com.votingApp.voting.data.dto.response;

import com.votingApp.voting.data.models.Gender;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserResponse {
    @Id
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String state;
    private Gender gender;
    private Integer nationalIdentificationNumber;
}

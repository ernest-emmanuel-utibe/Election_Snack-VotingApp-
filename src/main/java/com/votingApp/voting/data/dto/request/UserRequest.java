package com.votingApp.voting.data.dto.request;

import com.votingApp.voting.data.models.Gender;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class UserRequest {
    @Id
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private int age;
    private String state;
    private Gender gender;
    private long nationalIdentificationNumber;

}

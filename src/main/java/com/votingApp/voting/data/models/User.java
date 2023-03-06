package com.votingApp.voting.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private int age;
    private String state;
    private Gender gender;
    private long nationalIdentificationNumber;
    private long voterIdentificationNumber;


    public void message(String successful) {
        String message = new String("message");
    }

    public void setGender(Gender male, Gender female, String gender) {
        this.gender = Gender.valueOf(gender);
    }
}

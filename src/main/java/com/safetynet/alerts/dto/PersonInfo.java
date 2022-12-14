package com.safetynet.alerts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {

    private String firstName;
    private String lastName;
    private String address;
    private short age;
    private String email;
    private List<String> medications;
    private List<String> allergies;
}

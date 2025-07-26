package com.patientservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {

    private UUID id;

    private String name;

    private String email;

    private String address;

    private String dateOfBirth;

}

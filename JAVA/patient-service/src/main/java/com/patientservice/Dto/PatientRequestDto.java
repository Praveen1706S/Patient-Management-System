package com.patientservice.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {

    @NotNull(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;


    @NotNull(message = "Email is required")
    @Email(message =  " email should be valid")
    private String email;


    @NotNull(message =  "Address is required")
    private String address;

    @NotNull(message = "Date of birth required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Registered date is required")
    private LocalDate registerDate;

}

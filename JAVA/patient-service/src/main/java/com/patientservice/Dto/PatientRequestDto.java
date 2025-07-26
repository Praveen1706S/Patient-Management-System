package com.patientservice.Dto;

import com.patientservice.Dto.validation.CreatePatientValidationGroup;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;


    @NotBlank(message = "Email is required")
    @Email(message =  " email should be valid")
    private String email;


    @NotBlank(message =  "Address is required")
    private String address;

    @NotBlank(message = "Date of birth required")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registered date is required")
    private String registerDate;

}

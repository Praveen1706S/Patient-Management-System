package com.patientservice.mapper;

import com.patientservice.Dto.PatientRequestDto;
import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.entity.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class PatientMapper {

    public PatientResponseDto toPatientDto(Patient patient){

        PatientResponseDto patientDto = new PatientResponseDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;
    }

    public Patient toPatient(PatientResponseDto patientDto){

        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientDto.getDateOfBirth()));

        return patient;
    }


    public Patient toPatientsrequest( PatientRequestDto patientRequestDto){
        Patient patientDto = new Patient();
        patientDto.setName(patientRequestDto.getName());
        patientDto.setEmail(patientRequestDto.getEmail());
        patientDto.setAddress(patientRequestDto.getAddress());
        patientDto.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patientDto.setRegisterDate(LocalDate.parse(patientRequestDto.getRegisterDate()));

        return patientDto;
    }
}

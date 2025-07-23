package com.patientservice.service;

import com.patientservice.Dto.PatientRequestDto;
import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.entity.Patient;
import com.patientservice.exceptions.EmailAlreadyExistException;
import com.patientservice.mapper.PatientMapper;
import com.patientservice.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;


    // To add the patient to DB
    public PatientResponseDto addPatient(@Valid PatientRequestDto patient){

        if(patientRepository.existsByEmail(patient.getEmail())){

            throw new EmailAlreadyExistException("Patient already exist with the email : "
                    +patient.getEmail() + " please use another email" );
        }

        Patient savedPatient = patientRepository.save(patientMapper.toPatientsrequest(patient));

        return patientMapper.toPatientDto(savedPatient);

    }


    // To get all the patient from the database

    public List<PatientResponseDto> getAllPatients(){

        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> patientMapper.toPatientDto(patient))
                                                       .toList();
    }
}

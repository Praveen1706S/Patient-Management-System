package com.patientservice.service;

import com.patientservice.Dto.PatientRequestDto;
import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.entity.Patient;
import com.patientservice.exceptions.EmailAlreadyExistException;
import com.patientservice.exceptions.PatientNotFoundException;

import com.patientservice.mapper.PatientMapper;
import com.patientservice.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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


    // TO update the patient
    public PatientResponseDto  updatePatient(UUID id, PatientRequestDto patientRequestDto){

        Patient patient = patientRepository.findById(id)
                .orElseThrow( ()-> new PatientNotFoundException("Patient with id: "+ id + " Not Found"));


        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){

            throw new EmailAlreadyExistException("Patient already exist with the email : "
                    +patient.getEmail() + " please use another email" );
        }


        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setRegisterDate(LocalDate.parse(patientRequestDto.getRegisterDate()));
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));

        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.toPatientDto(savedPatient);
    }



    // To delete the patient
    public void deletePatient(UUID id){

        patientRepository.deleteById(id);
    }
}

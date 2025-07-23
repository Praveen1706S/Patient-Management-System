package com.patientservice.service;

import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.entity.Patient;
import com.patientservice.mapper.PatientMapper;
import com.patientservice.repository.PatientRepository;
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
    public PatientResponseDto addPatient(Patient patient){

        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.toPatientDto(patient);

    }


    // To get all the patient from the database

    public List<PatientResponseDto> getAllPatients(){

        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDto> patientResponseDtos = patients.stream()
                                                       .map(patient -> patientMapper.toPatientDto(patient))
                                                       .toList();

        return patientResponseDtos;
    }
}

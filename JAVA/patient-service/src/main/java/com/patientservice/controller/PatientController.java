package com.patientservice.controller;

import com.patientservice.Dto.PatientRequestDto;
import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.entity.Patient;
import com.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;



    @PostMapping("/addpatient")
    public ResponseEntity<?> addPatient(@Valid @RequestBody PatientRequestDto patient){

        System.out.println(patient);

        PatientResponseDto patientResponseDto = patientService.addPatient(patient);

        return ResponseEntity.ok(patientResponseDto);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients(){

        List<PatientResponseDto> patientResponseDtos = patientService.getAllPatients();

        return ResponseEntity.ok(patientResponseDtos);
    }


}

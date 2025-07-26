package com.patientservice.controller;

import com.patientservice.Dto.PatientRequestDto;
import com.patientservice.Dto.PatientResponseDto;
import com.patientservice.Dto.validation.CreatePatientValidationGroup;
import com.patientservice.entity.Patient;
import com.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patient")
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {


    @Autowired
    private PatientService patientService;



    @PostMapping("/add/patient")
    @Operation(summary = "Create a Patient")
    public ResponseEntity<?> addPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class})
            @Valid @RequestBody PatientRequestDto patient){

        System.out.println(patient);

        PatientResponseDto patientResponseDto = patientService.addPatient(patient);

        return ResponseEntity.ok(patientResponseDto);
    }


    @GetMapping("/all")
    @Operation(summary = "GetPatients")
    public ResponseEntity<?> getAllPatients(){

        List<PatientResponseDto> patientResponseDtos = patientService.getAllPatients();

        return ResponseEntity.ok(patientResponseDtos);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a Patient")
    public ResponseEntity<?> updatePatient(@PathVariable UUID id, @Validated({Default.class})@RequestBody PatientRequestDto patientRequestDto){

           PatientResponseDto patientResponseDto =  patientService.updatePatient(id, patientRequestDto);

           return ResponseEntity.ok().body(patientResponseDto);
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<?> deletePatient(@PathVariable UUID id){


        patientService.deletePatient(id);

        return  ResponseEntity.noContent().build();
    }

}

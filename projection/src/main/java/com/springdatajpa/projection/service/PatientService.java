package com.springdatajpa.projection.service;

import com.springdatajpa.projection.repository.PatientRepository;
import com.springdatajpa.projection.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional //One call for duplicate ID
    public void testPatientTransaction() {
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + " " + p2);
        System.out.println(p1 == p2); //Not referencing same reference
    }

    @jakarta.transaction.Transactional
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }
}

package com.springdatajpa.projection.service;

import com.springdatajpa.projection.entity.Patient;
import com.springdatajpa.projection.repository.PatientRepository;
import com.springdatajpa.projection.entity.Insurance;
import com.springdatajpa.projection.repository.InsuranceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //Optional, In order to maintain bi-directional consistency
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfPatient(Insurance insurance, long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //Optional, In order to maintain bi-directional consistency
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceOfPatient(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);
        return patient;
    }
}

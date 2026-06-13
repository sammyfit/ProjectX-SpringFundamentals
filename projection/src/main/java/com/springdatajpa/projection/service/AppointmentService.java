package com.springdatajpa.projection.service;

import com.springdatajpa.projection.entity.Appointment;
import com.springdatajpa.projection.entity.Doctor;
import com.springdatajpa.projection.entity.Patient;
import com.springdatajpa.projection.repository.AppointmentRepository;
import com.springdatajpa.projection.repository.DoctorRepository;
import com.springdatajpa.projection.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }

}

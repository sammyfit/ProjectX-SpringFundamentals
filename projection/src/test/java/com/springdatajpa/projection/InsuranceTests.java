package com.springdatajpa.projection;

import com.springdatajpa.projection.entity.Appointment;
import com.springdatajpa.projection.entity.Insurance;
import com.springdatajpa.projection.service.AppointmentService;
import com.springdatajpa.projection.service.InsuranceService;
import com.springdatajpa.projection.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_234G")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 06, 03, 11, 00, 00))
                .reason("Fever")
                .build();

        var updatedAppointment = appointmentService.createANewAppointment(appointment, 1L, 2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }
}

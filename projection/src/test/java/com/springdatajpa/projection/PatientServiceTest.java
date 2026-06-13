package com.springdatajpa.projection;

import com.springdatajpa.projection.dto.BloodGroupStats;
import com.springdatajpa.projection.dto.CPatientInfo;
import com.springdatajpa.projection.dto.IPatientInfo;
import com.springdatajpa.projection.entity.Patient;
import com.springdatajpa.projection.repository.PatientRepository;
import com.springdatajpa.projection.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient(){
        List<Patient> patientList = patientRepository.findAll();

        for(Patient p : patientList){
            System.out.println(p);
        }
    }

    @Test
    public void testPatient2(){
        List<IPatientInfo> iPatientList = patientRepository.getAllPatientInfo();

        for(IPatientInfo iPl : iPatientList){
            System.out.println(iPl.getId() + " | " + iPl.getName() + " | " + iPl.getEmail());
        }
    }

    @Test
    public void testCPatient3(){
        List<CPatientInfo> cPatientList = patientRepository.getAllPatientsInfoConcrete();

        for(CPatientInfo cPl : cPatientList){
            System.out.println(cPl.getId() + " | " + cPl.getName());
        }
    }

    @Test
    public void testCPatientBGS(){
        List<BloodGroupStats> bgs = patientRepository.getBloodGroupStats();

        for(var b : bgs){
            System.out.println(b);
        }
    }

    @Test
    public void updatePatientTest(){
        int rowsAffected = patientRepository.updatePatientNameById("Ronnie Mehta", 3L);

        System.out.println(rowsAffected + "row affected");
    }

    @Test
    public void testDemo() {
        Patient patient = new Patient(); // Currently in transient state
        patientRepository.save(patient); // This will call the save -> persist method from JpaRepository (Have methods for Save or Update)
    }

    @Test
    public void testPatientService() {
        patientService.testPatientTransaction();
    }
}

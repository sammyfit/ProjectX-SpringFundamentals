package com.codingshuttle.prod_ready_features;

import com.codingshuttle.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void getEmployeesById() {
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	void createNewEmployeeTest() {
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Sharvari", "AlphaNo2@gmail.com", 22, "USER", 50000.0, LocalDate.of(2021, 12, 1), true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}

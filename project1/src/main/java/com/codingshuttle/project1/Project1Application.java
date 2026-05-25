package com.codingshuttle.project1;

import com.codingshuttle.project1.Impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	/*final NotificationService notificationService; //dependency injection

	public Project1Application(NotificationService notificationService) {
		this.notificationService = notificationService; //constructor dependency injection //preferred
	}*/
	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//notificationService.send("Hello!");

		for(var notificationService : notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}
	}
}

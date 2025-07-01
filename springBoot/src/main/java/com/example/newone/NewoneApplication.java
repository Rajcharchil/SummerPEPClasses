package com.example.newone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewoneApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(NewoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser(new User(null, "Raj Charchil", "raj@example.com", "9876543210"));
		userService.createUser(new User(null, "laxmi", "laxmi@example.com", "9123456780"));
		userService.createUser(new User(null, "shyam", "shyam,@example.com", "913456780"));
		userService.createUser(new User(null, "ram", "ram@example.com", "123456780"));
		System.out.println("Dummy users created.");
	}

}

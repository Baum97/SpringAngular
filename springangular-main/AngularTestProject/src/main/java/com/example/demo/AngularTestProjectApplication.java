package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngularTestProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AngularTestProjectApplication.class, args);
	}

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public void run(String... args) {
		taskRepo.save(new Task("nameStamp", "commentStamp"));
		taskRepo.save(new Task("new", "comment"));
		taskRepo.save(new Task("works", "comment"));
		taskRepo.save(new Task("other task", "comment"));
		taskRepo.save(new Task("filler", "comment"));

	}

}

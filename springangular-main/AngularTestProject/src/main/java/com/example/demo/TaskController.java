package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskRepository taskRepo;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return this.taskRepo.findAll();
	}
	
	@PutMapping("/tasks/{id}")
	public void updateTask(Task task, @PathVariable long id) {
		this.taskRepo.save(task);
	}
	
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable long id) {
		this.taskRepo.deleteById(id);
	}

	@PostMapping("/tasks")
	public void postTask(@RequestBody Task task) {
		task.setTime(task.fetchTime());
		this.taskRepo.save(task);
	}
}

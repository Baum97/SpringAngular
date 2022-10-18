import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';


@Component({
	selector: 'app-task',
	templateUrl: './task.component.html',
	styleUrls: ['./task.component.css']
})

export class TaskComponent implements OnInit {

	tasks: Task[] | undefined;
	task = new Task;
	time = new Date();
	constructor(private taskService: TaskService) { }

	ngOnInit(): void {
		this.getTasks();
	}

	public edit(id: any) {
		console.log("edit");
		this.taskService.updateTask(id);
		this.getTasks();
	}

	public delete(id: any) {
		this.taskService.deleteTask(id).subscribe({
			next: (data) => {
			}
		});
		this.getTasks();
	}

	public updateStatus(id: any) {
		this.task.status = !this.task.status;
		this.taskService.updateTask(id).subscribe({
			next: () => {
			}
		})
	}


	public getTasks(): void {
		setTimeout(() => {
			this.taskService.getTasks().subscribe(((data: Task[] | undefined) => {
				this.tasks = data;
			}));
		}, 300);
	}

	public deleteGet(id: any) {
		this.delete(id);
		this.getTasks();
	}

	public createTask(): void {
		this.task.name = (<HTMLInputElement>document.getElementById("inputName")).value;
		this.task.comment = (<HTMLInputElement>document.getElementById("inputComment")).value;
		this.task.status = false;
		this.taskService.postTask(this.task).subscribe(() => { });
		this.getTasks();
	}
}

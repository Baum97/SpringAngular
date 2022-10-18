import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from "./task";
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class TaskService {

	private url: string;

	constructor(private http: HttpClient) {
		this.url = "http://localhost:8080/api/tasks";
	}

	getTasks(): Observable<Task[]> {
		return this.http.get<Task[]>(`${this.url}`);
	}

	postTask(task: Task): Observable<Task> {
		console.log(task);
		return this.http.post<Task>(`${this.url}`, task);
	}

	deleteTask(id: any): Observable<any> {
		return this.http.delete(`${this.url}/${id}`);
	}

	updateTask(id: any): Observable<any> {
		return this.http.put(`${this.url}/${id}`, id);
	}
}

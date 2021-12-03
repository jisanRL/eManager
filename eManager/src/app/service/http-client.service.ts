import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private http: HttpClient) { }

  // gets the employees
  getEmployees() {
    return this.http.get<Employee[]>('http://localhost:8080/user/employee');
  }

  // adds employee
  addEmployees(employee: Employee) {
    return this.http.post<Employee>('http://localhost:8080/user/add/', employee);
  }

  // updates the employee info
  updateEmployees(employee: Employee) {
    return this.http.put<Employee>('http://localhost:8080/user/update/', employee);
  }

  // deletes employee
  deleteEmployee(id: number) {
    return this.http.delete<void>('http://localhost:8080/user/delete/' + id);
  }

  // search employee 
  searchEmployee(name: String)  {
    return this.http.get<Employee>('http://localhost:8080/user/get/' + name);
  }
  
}

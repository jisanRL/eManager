import { Component, OnInit } from '@angular/core';
import { Employee } from './model/employee';
import { HttpClientService } from './service/http-client.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'eManager';

  employees: Employee[] = [];  //  holds all the employee coming from the backend 
  editEmployee: Employee = new Employee();
  deleteEmployee: Employee = new Employee();

  // constructers injects service and calls from the backend
  constructor(private httpService: HttpClientService) {}

  ngOnInit(){
    // call the get employee when ever its loaded 
    this.getEmployees();
  }


  // gets the employees from the backend 
  getEmployees(): void {
    // subscribes notifies when some data comes back from the server 
    this.httpService.getEmployees().subscribe(
      // if data is returned then that is the response 
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      }, 
      // error response if there is no data
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  // add the employee to the server
  onAddEmployees(addForm: NgForm):void {

  }

  // updates the employee
  onUpdateEmployee(employee:Employee):void {

  }

  // deletes the employee
  onDeleteEmployee(employeeID: number):void {

  }

  // searches the employee
  searchEmployee(key: String):void {

  }

  // opens the forms for adding and editing the employee
  onOpenModal(employee: Employee, mode: String): void {
    const container = document.getElementById('main-container');
    const button  = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';      // hides the button
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editEmployee = employee;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }

    container?.appendChild(button);
    button.click();       // this will open the appropirate modal
  }
  
}

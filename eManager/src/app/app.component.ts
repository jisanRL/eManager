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
    // this helps in getting the the data instatly from the back end 
    document.getElementById('add-employee-form')?.click();

    // value -> json representation of all the inputs in the form
    this.httpService.addEmployees(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();        // this gets the employee in realtime
        addForm.reset();      // clears the form
      }, 
      // error response
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();   
      }
    )
  }

  // updates the employee
  onUpdateEmployee(employee:Employee):void {
    this.httpService.updateEmployees(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      }, 
      // error response
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

  }

  // deletes the employee
  onDeleteEmployee(employeeID: number):void {
    this.httpService.deleteEmployee(employeeID).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  // searches the employee
  searchEmployee(key: String):void {
    const resArr: Employee[] = [];

    // loop thorugh the res
    for (const employee of this.employees) {
      // if there is a match between any elements push to to resArr
      if (employee.name.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1 || 
      employee.email.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1 ||
      employee.phone.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1 || 
      employee.jobTitle.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1) 
      {
        resArr.push(employee);
      }
    }
    this.employees = resArr;

    if (resArr.length === 0 || !key) {
      this.getEmployees();
    }
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

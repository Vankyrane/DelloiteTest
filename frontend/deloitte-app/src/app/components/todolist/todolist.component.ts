import { Component, OnInit } from '@angular/core';
import { HttpdataService } from 'src/app/services/httpdata.service';

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})
export class TodolistComponent implements OnInit {

  model: any = {};
  todoItems;
  constructor(private httpdService: HttpdataService) { }

  ngOnInit() {
    this.getUserTodos();
  }

  getUserTodos() {
    // this.loaderStatus = this.loaderserviceService.showLoader();

    let sessionToken = localStorage.getItem("sessionToken");
    this.httpdService.getUserTodos(sessionToken).subscribe(

      (data: any[]) => {
        if (this.httpdService.isServiceSuccesfull(data)) {
          this.todoItems = data.resultSet;

        } else {
          alert("SOMETHING WENT WRONG");
        }

      },
      (catchError) => {
        console.log('HTTP Error', catchError);
        // this.loaderStatus = this.loaderserviceService.hideLoader();
      },
      () => {
        // this.loaderStatus = this.loaderserviceService.hideLoader();
      })
  }
  element: HTMLElement;
  currentElement;
  showHideDescription(id) {
    if (this.currentElement != undefined) {
      this.currentElement.style.display = 'none';
    }

    this.element = document.getElementById(id) as HTMLElement;
    this.element.style.display = 'block';
    this.currentElement = this.element;
  }
}

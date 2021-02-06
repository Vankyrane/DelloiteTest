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
  showform=false;
  formLabel="";
  itemId=null;
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


  createItem(form) {
    let APIUrl='';
    if(this.itemId!=null){
      APIUrl = 'editUserItem';
    }else{
      APIUrl = 'createItem';
      this.itemId=null;
    }
    const postdata = {
      "description": this.model.description,
      "userId": localStorage.getItem('userId'),
      "title":this.model.title,
      "done":this.model.isDone,
      'id':this.itemId
    }

    this.httpdService.createItem(postdata,localStorage.getItem("sessionToken"),APIUrl).subscribe(

      (data: any[]) => {
        if (this.httpdService.isServiceSuccesfull(data)) {
          form.reset();
          this.showCreateForm();
          this.getUserTodos();

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

  editItem(itemData){
    this.formLabel="Update";
    this.model.description = itemData.description;
    this.model.title = itemData.title;
    this.model.isDone = itemData.done;
    this.itemId=itemData.id;
    this.showform=!this.showform;
    this.scrollToTop();
  }

  showCreateForm(){
    this.itemId=null;
    this.formLabel="Create";
    this.showform=!this.showform;
    this.scrollToTop();

  }

scrollToTop(){
  window.scroll({
    top: 0,
    left: 0,
    behavior: 'smooth'
  });
}
  deleteItem(itemId) {
    const postdata = {
      "id": itemId,
      "userId": localStorage.getItem('userId')
    }

    this.httpdService.deleteItem(postdata,localStorage.getItem("sessionToken")).subscribe(

      (data: any[]) => {
        if (this.httpdService.isServiceSuccesfull(data)) {

          this.getUserTodos();

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
  closeForm(form){
    this.showform=!this.showform;
    form.reset();
  }
}

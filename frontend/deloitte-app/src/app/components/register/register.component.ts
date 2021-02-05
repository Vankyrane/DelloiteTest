import { Component, OnInit } from '@angular/core';
import { HttpdataService } from 'src/app/services/httpdata.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: any = { };
  constructor(private httpdService: HttpdataService) { }

  ngOnInit() {
  }

  registerUSer(form){
    // this.loaderStatus = this.loaderserviceService.showLoader();

    const postdata = {
      "emailId": this.model.email,
      "password": this.model.password,
      "name": this.model.name
    }

    this.httpdService.registerUSer(postdata).subscribe(

      (data: any[]) => {

        form.reset();

      },
      (catchError) => {
        console.log('HTTP Error', catchError);
        // this.loaderStatus = this.loaderserviceService.hideLoader();
      },
      () => {
        // this.loaderStatus = this.loaderserviceService.hideLoader();
      })
  }


}

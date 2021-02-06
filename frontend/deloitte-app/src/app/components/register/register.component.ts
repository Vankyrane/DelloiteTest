import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpdataService } from 'src/app/services/httpdata.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: any = { };
  constructor(private httpdService: HttpdataService,
    private router: Router) { }

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
        if(this.httpdService.isServiceSuccesfull(data)){
          form.reset();
          this.router.navigate(['login']);
        }else{
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


}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpdataService } from 'src/app/services/httpdata.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {};
  constructor(private httpdService: HttpdataService,
    private router: Router) { }

  ngOnInit() {
  }

  loginUser(form) {
    // this.loaderStatus = this.loaderserviceService.showLoader();

    const postdata = {
      "emailId": this.model.email,
      "password": this.model.password
    }

    this.httpdService.loginUser(postdata).subscribe(

      (data:any) => {
        if (this.httpdService.isServiceSuccesfull(data)) {
          form.reset();
          localStorage.setItem("emailId",data.resultSet.emailId);
          localStorage.setItem("userId",data.resultSet.id);
          localStorage.setItem("sessionToken",data.resultSet.sessionToken);
          localStorage.setItem("name",data.resultSet.name);
          this.router.navigate(['todolists']);
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
  navigateToRegister(){
    this.router.navigate(['register']);
  }
}

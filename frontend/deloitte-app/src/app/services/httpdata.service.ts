import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class HttpdataService {

  constructor(private httpClient: HttpClient) { }
  private BASE_URL = "http://localhost:8080/Deloitte/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    //window.alert(errorMessage);
    return throwError(errorMessage);
  }

  //posting new comment for the blog post
  public registerUSer(postData) {
    return this.httpClient.post(this.BASE_URL + "registerUser", JSON.stringify(postData), this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }
}

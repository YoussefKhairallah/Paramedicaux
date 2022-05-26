import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../models/user.module';

const AUTH_API = 'http://localhost:8080/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient) { }
  login(email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      email,
      password
    }, httpOptions);
  }
  register(username: string, prenom: string, email: string, password: string, tel: string, dateNaissance: string ): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username,
      prenom,
      tel,
      dateNaissance,
      email,
      password
    }, httpOptions);
  }
}

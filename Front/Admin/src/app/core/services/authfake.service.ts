import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable } from 'rxjs';


const AUTH_API = 'http://localhost:8080/api/auth/';
const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable({ providedIn: 'root' })
export class AuthfakeauthenticationService {

    constructor(private http: HttpClient) { }

  login(Mail: string, Mdp: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      Mail,
      Mdp
    }, httpOptions);
  }
  register(Nom: string, prenom: string, Tel:string, DateNaissance:string, Mail: string, Mdp: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      Nom,
      prenom,
      Tel,
      DateNaissance,
      Mail,
      Mdp
    }, httpOptions);
  }
}


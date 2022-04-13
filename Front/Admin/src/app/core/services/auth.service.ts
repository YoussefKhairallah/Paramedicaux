import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/auth.models';
import { TokenStorageService } from './token-storage.service';

const AUTH_API = 'http://localhost:8080/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {

    user: User;

    /**
    /**
     * Performs the auth
     * @param prenom
     * @param NumTel
     * @param dateNaissace
     * @param email email of user
     * @param password password of user
     */

    constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) { }
  login(email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      email,
      password
    }, httpOptions);
  }
  register(username: string, prenom: string, NumTel:string, dateNaissace:string, email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username,
      prenom,
      NumTel,
      dateNaissace,
      email,
      password
    }, httpOptions);
  }
  /**
     * Logout the user
    */
   logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}

    /**
     * Reset password
     * @param email email
   
    resetPassword(email: string) {
        return getFirebaseBackend().forgetPassword(email).then((response: any) => {
            const message = response.data;
            return message;
        });
    }
    */
    

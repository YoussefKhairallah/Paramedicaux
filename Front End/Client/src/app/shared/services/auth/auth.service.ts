import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { GoogleAuthProvider, FacebookAuthProvider} from '@angular/fire/auth';
import { catchError, map } from 'rxjs/operators';

import { User } from '../../models/auth.models';
import { UserService } from './user.service';
import { Router } from '@angular/router';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient, private userservive: UserService) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')!));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }


    // Returns true when user is looged in and email is verified
  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('currentUser')!);
    return user !== null ? true : false;
  }

     login(username: string, password: string): Observable<any> {      
        return this.http.post<any>('http://127.0.0.1:8080/api/auth/signin', {username: username, password: password})
          .pipe(
            map(user => {
              // login successful if there's a jwt accessToken in the response
              console.log(user);
              
              if (user) {
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                 this.getUser(user.id);
                //this.router.navigate(['/dashboard']);
                return user;
              }
              
            })
          );
      }
      

       getUser(userId: number){
         console.log('userId',userId);
        this.userservive.getUserByID(userId).subscribe(userdata => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          console.log('userdata',userdata);
          localStorage.setItem('userInfo', JSON.stringify(userdata));
        });
      }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        localStorage.removeItem('userInfo');
        this.currentUserSubject.next(null!);
    }

  //Sign in with google
  /*googleSignIn(){
    return this.fireauth.signInWithPopup(new GoogleAuthProvider).then(res =>{
      this.router.navigate(['/dashboard']);
      localStorage.setItem('token',JSON.stringify(res.user));
    }, err =>{
      alert(err.message);
    })
  }*/
}

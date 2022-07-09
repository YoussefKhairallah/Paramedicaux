import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { User } from '../../models/auth.models';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient, private userservive: UserService, private router: Router) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

     login(username: string, password: string): Observable<User> {
        return this.http.post<any>('http://127.0.0.1:8080/api/auth/signin', {username: username, password: password})
          .pipe(
            map(user => {
              // login successful if there's a jwt accessToken in the response
              console.log(user);
              
              if (user) {
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                 this.getUser(user.id);
                this.router.navigate(['/dashboard']);
                return user;
              }
              
            }),
            catchError(error => {
              this.router.navigate(['newpage']);
              console.log(error);
              return of(false);
            })
          );
      }

       getUser(userId){
        this.userservive.getUserByID(userId).subscribe(userdata => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          console.log(userdata);
          localStorage.setItem('userInfo', JSON.stringify(userdata));
          this.router.navigate(['/dashboard']);
        });
      }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        localStorage.removeItem('userInfo');
        this.currentUserSubject.next(null);
    }
}

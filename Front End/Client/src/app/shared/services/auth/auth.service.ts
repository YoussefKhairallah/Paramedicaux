import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { GoogleAuthProvider, FacebookAuthProvider, user} from '@angular/fire/auth';
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
   public catUrl = 'http://localhost:8080/api/users';
  signin(_params: { id: any; doctor_name: string; password: string; prenom: string; datenaissance: string; mail: string; tel: string; }) {
    throw new Error('Method not implemented.');
  }


  private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient, private userservive: UserService,
      private router: Router) {
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

     login(email: string, password: string): Observable<any> {
        return this.http.post<any>('http://127.0.0.1:8080/api/auth/signin', {username: email, password: password})
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

signup(users: Object): Observable<User> {
  return this.http.post<User>('http://127.0.0.1:8080/api/auth/signup', users)
}
       getUser(userId: number){
         console.log('userId',userId);
        this.userservive.getUserByID(userId).subscribe(userdata => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          console.log('userdata',userdata);
          localStorage.setItem('userInfo', JSON.stringify(userdata));
          this.router.navigate(['/home']);
        });
      }
      createuser(user: Object,role:number): Observable<Object> {
        return this.http.post(`${this.catUrl}/${role}`, user);
      }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        localStorage.removeItem('userInfo');
        // this.currentUserSubject.next(null!);
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')!));
     this.currentUser = this.currentUserSubject.asObservable();
     console.log(this.currentUser);
     this.router.navigate(['/home'])
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

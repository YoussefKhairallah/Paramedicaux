import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthfakeauthenticationService } from 'src/app/core/services/authfake.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  
  f: any = {
    username: null,
    prenom: null,
    telephone: null,
    dateNaissance: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  signupForm: FormGroup;
  submitted = false;
  error = '';
  successmsg = false;

  // set the currenr year
  year: number = new Date().getFullYear();

  // tslint:disable-next-line: max-line-length
  constructor(private formBuilder: FormBuilder, private authService: AuthfakeauthenticationService) { }
  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      telephone: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }
  get form() {
    return this.signupForm.controls;
  }
  onSubmit(): void {
    if(this.signupForm.valid){
    const Nom = this.signupForm.get('username').value;
      const prenom = this.signupForm.get('prenom').value;
      const dateNaissance = this.signupForm.get('dateNaissance').value;
      const email = this.signupForm.get('email').value;
      const Mdp = this.signupForm.get('password').value;
      const Tel = this.signupForm.get('phone').value;
    }
    /*this.authService.register(Nom, prenom, Tel, dateNaissance, email, Mdp).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    });*/
  }

}

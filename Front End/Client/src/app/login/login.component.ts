import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CommonServiceService } from '../common-service.service';

import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../shared/services/auth/auth.service';
import { TokenStorageService } from '../shared/services/auth/token-storage.service';

declare const $: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  
  loginForm!: FormGroup;
  submitted = false;
  error = '';
  returnUrl!: string;

  // set the currenr year
  year: number = new Date().getFullYear();

  constructor(private router: Router,
    private formBuilder: FormBuilder, private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  // convenience getter for easy access to form fields
  get form() { return this.loginForm.controls; }

  
  onSubmit(): void {
    this.submitted = true;
    console.log(this.loginForm.value);
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    this.authService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe({
      next: data => {
        console.log(data);
        this.tokenStorage.saveToken(data.accessToken );
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.authService.getUser(data.id);
        
      },
      error: err => {
        this.errorMessage = err;
        this.isLoginFailed = true;
      }
    });
  }
  
  signinWithGoogle(){
    //this.authService.googleSignIn();
  }
}

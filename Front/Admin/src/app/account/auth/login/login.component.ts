import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthfakeauthenticationService } from '../../../core/services/authfake.service';

import { TokenStorageService } from 'src/app/core/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

/**
 * Login component
 */
export class LoginComponent implements OnInit {
  form: any = {
    email: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  
  loginForm: FormGroup;
  submitted = false;
  error = '';
  returnUrl: string;

  // set the currenr year
  year: number = new Date().getFullYear();

  constructor(private formBuilder: FormBuilder, private authService: AuthfakeauthenticationService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }

  }

 
  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

 /**
   * Form submit
   */
  onSubmit(): void {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    const { email, password } = this.form;
    this.authService.login(email, password).subscribe({
      next: data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }
  reloadPage(): void {
    window.location.reload();
  }
  
}




/*
ngOnInit() {
  this.loginForm = this.formBuilder.group({
    email: ['admin@themesbrand.com', [Validators.required, Validators.email]],
    password: ['123456', [Validators.required]],
  });

  // reset login status
  // this.authenticationService.logout();
  // get return url from route parameters or default to '/'
  // tslint:disable-next-line: no-string-literal
  this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
}
onSubmit() {
  this.submitted = true;

  // stop here if form is invalid
  if (this.loginForm.invalid) {
    return;
  } else {
    if (environment.defaultauth === 'firebase') {
      this.authenticationService.login(this.f.email.value, this.f.password.value).then((res: any) => {
        this.router.navigate(['/dashboard']);
      })
        .catch(error => {
          this.error = error ? error : '';
        });
    } else {
      this.authFackservice.login(this.f.email.value, this.f.password.value)
        .pipe(first())
        .subscribe(
          data => {
            this.router.navigate(['/dashboard']);
          },
          error => {
            this.error = error ? error : '';
          });
    }
  }
  */
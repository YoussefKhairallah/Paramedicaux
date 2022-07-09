import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CommonServiceService } from '../common-service.service';

import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../shared/services/auth/auth.service';
import { param } from 'jquery';
import { FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from '../shared/models/user.model';

declare const $: any;
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  nom = '';
  password = '';
  prenom ='';
  dateNaissance ='';
  email ='';
  tel = '';
  adresse = '';
  ville = '';
  codePostal ='';

  formData!: FormGroup;
  isPatient: boolean = true;

  value: any;
  constructor(
    private toastr: ToastrService,
    public authServices: AuthService,
    public router: Router,
    private modalService: NgbModal
  ) {}
user=new User();
  ngOnInit(): void {

  }

  get form() {
    return this.formData.controls;
  }
  signup() {
      console.log("Form object: " + this.user);

      this.authServices.createuser(this.user,3)
      .subscribe( res => {
        this.modalService.dismissAll();
        Swal.fire({
          position: 'top-end',
          title: 'Thank you...',
          text: 'Utilisateur ajoute avec succes!',
          icon: 'success'});
        this.user=new User();
    }, error => {
      error = console.error();
      Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: 'Oops...',
        text: "il y a un erreur avec l'ajout!!"
      })
    });
    
  }



}

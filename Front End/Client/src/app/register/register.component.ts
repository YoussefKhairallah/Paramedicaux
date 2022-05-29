import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CommonServiceService } from '../common-service.service';

import { ToastrService } from 'ngx-toastr';

declare const $: any;
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  name = '';
  mobile = '';
  password = '';
  lastname ='';
  dateNaissance ='';
  email ='';
  phone = '';
  adresse = '';
  ville = '';
  pays = '';
  codePostal ='';

  isPatient: boolean = true;
  doctors: any = [];
  patients: any = [];
  reg_type = 'Patient Register';
  doc_patient = 'Are you a Doctor?';
  value: any;
  constructor(
    private toastr: ToastrService,
    public commonService: CommonServiceService,
    public router: Router
  ) {}

  ngOnInit(): void {
    this.getpatients();
    this.getDoctors();
    if($('.floating').length > 0 ){
      $('.floating').on('focus blur',  (e: { type: string; }) => {
      $(this).parents('.form-focus').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
      }).trigger('blur');
    }
  }

  changeRegType() {
    if (this.reg_type === 'Doctor Register') {
      this.reg_type = 'Patient Register';
      this.doc_patient = 'Are you a Doctor?';
      this.isPatient = true;
    } else {
      this.reg_type = 'Doctor Register';
      this.doc_patient = 'Not a Doctor?';
      this.isPatient = false;
    }
  }

  signup() {
    if (this.name === '' || this.mobile === '' || this.password === '' || this.lastname === '' || this.dateNaissance === '' || this.email === '' || this.phone === '' || this.adresse || this.codePostal || this.ville || this.pays) {
      this.toastr.error('', 'Veuillez saisir le champ obligatoire !');
    } else {
      if (!this.isPatient) {
        let params = {
          id: this.doctors.length + 1,
          doctor_name: this.name,
          password: this.password,
          prenom: this.lastname,
          datenaissance: this.dateNaissance,
          mail: this.email,
          tel: this.phone

        };
        this.commonService.createDoctor(params).subscribe((res) => {
          this.toastr.success('', 'Register successfully!');
          this.router.navigate(['/doctor-register-step1']);
        });
      } else {
        let params = {
          id: this.patients.length + 1,
          name: this.name,
          password: this.password,
        };
        this.commonService.createPatient(params).subscribe((res) => {
          this.toastr.success('', 'Register successfully!');
          this.router.navigate(['/patient-register-step1']);
        });
      }
    }
  }

  getDoctors() {
    this.commonService.getDoctors().subscribe((res) => {
      this.doctors = res;
    });
  }

  getpatients() {
    this.commonService.getpatients().subscribe((res) => {
      this.patients = res;
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {
  userData: Array<User> = [];
  constructor(public Router : Router) { }

  ngOnInit(): void {
  }
  addBilling() {
    this.Router.navigateByUrl('/patients/add-billing');
  }
  editBilling() {
    this.Router.navigateByUrl('/patients/edit-billing');
  }
  addPrescription() {
    this.Router.navigateByUrl('/patients/add-prescription');
  }
  editPrescription() {
    this.Router.navigateByUrl('/patients/edit-prescription');
  }
}

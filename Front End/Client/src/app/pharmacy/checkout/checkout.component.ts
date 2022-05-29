import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  nom='';
  prenom = '';
  email = '';
  phone = '';
  chekbox1 = '';
  chekbox2 = '';
  radio1 = '';
  radio2 ='';

  constructor(private toastr: ToastrService, public router: Router) { }

  ngOnInit(): void {
  }
  confirmer(){
    if (this.nom === '' || this.prenom === '' || this.email === '' || this.phone === '' || this.chekbox1 === '' || this.chekbox2 === '' || this.radio1 === '' || this.radio2 === '') {
      this.toastr.error('', 'Veuillez saisir les champs obligatoire !');
      //this.router.navigate(['/pharmacy/success']);
    }
  }

}

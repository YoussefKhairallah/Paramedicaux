
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Roles } from 'src/app/core/models/roles.model';
import { UserService } from 'src/app/core/services/auth/user.service';

import Swal from 'sweetalert2';
import { User } from '../../../core/models/user.model';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.scss']
})

/**
 * Contacts user-list component
 */
export class UserlistComponent implements OnInit {
  rolesData: Roles[];
  breadCrumbItems: Array<{}>;
  term: any;
  formData: FormGroup;
  submitted = false;
  UserData: User[];
  // page
  currentpage: number;

  
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Liste des administrateurs', active: true }];
    this.formData = this.formBuilder.group({
      nom: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      tel: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      roles: ['', [Validators.required]],
    });

    this.currentpage = 1;
    this.getAllUser();
  }
    /**
   * Open modal
   * @param content modal content
   */
     openModal(content: any) {
      this.modalService.open(content);
    }
  get form() {
    return this.formData.controls;
  }
  validSubmit(){
    this.submitted = true;
    const formData = new FormData();
    formData.append('name', this.formData.get('nom').value);
    formData.append('name', this.formData.get('prenom').value);
    formData.append('name', this.formData.get('dateNaissance').value);
    formData.append('name', this.formData.get('email').value);
    formData.append('name', this.formData.get('password').value);
    formData.append('name', this.formData.get('tel').value);
    formData.append('name', this.formData.get('roles').value);
    formData.append('name', this.formData.get('adresse').value);
    }


  saveUser() {
    console.log(this.formData.value);
    if (this.validSubmit){
      this.userService.createuser(this.formData.value)
        .subscribe(res => {
          this.getAllUser();
          this.modalService.dismissAll();
          Swal.fire({
            position: 'top-end',
            title: 'Thank you...',
            text: 'Utilisateur ajoute avec succes!',
            icon: 'success'});
          this.formData.reset(); 
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
  
  getAllUser(){
    this.userService.getUsers()
    .subscribe(data=>{
      this.UserData=data
      console.log(data)
    })
  }

  //Supprimer un utilisateur

  confirmSupp(id: number){
    Swal.fire({  
      title: 'Voulez-vous vraiment supprimer ?',   
      icon: 'warning',  
      showCancelButton: true,  
      confirmButtonText: 'Oui, supprimez-le !',  
      cancelButtonText: 'Non, gardez-le'  
    }).then((result) => {  
      if (result.value) { 
        this.delete(id);
        Swal.fire(  
          'Supprimé !',  
          'Votre admin a été supprimée.',  
          'success'  
        )  
      } else if (result.dismiss === Swal.DismissReason.cancel) {  
        Swal.fire(  
          'Annulé',  
          'Votre admin est sécurisée :)',  
          'error'  
        )  
      }  
    })  
  }

  delete(id: number) {
    this.userService.deleteuser(id).subscribe(data => {
      console.log(data);
      this.getAllUser();
    }
    );
  }

}



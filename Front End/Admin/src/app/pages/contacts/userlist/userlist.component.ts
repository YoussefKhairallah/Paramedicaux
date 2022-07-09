
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  breadCrumbItems: Array<{}>;
  term: any;
  formData: FormGroup;
  submitted = false;
  UserData: any[];
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
    formData.append('nom', this.formData.get('nom').value);
    formData.append('prenom', this.formData.get('prenom').value);
    formData.append('dateNaissance', this.formData.get('dateNaissance').value);
    formData.append('email', this.formData.get('email').value);
    formData.append('password', this.formData.get('password').value);
    formData.append('tel', this.formData.get('tel').value);
    formData.append('role', this.formData.get('role').value);
    }

    saveUser() {
      if (this.validSubmit){
       this.userService.createuser(this.formData.value,3)
        .subscribe({
          next: (res) => {
            Swal.fire({
              position: 'top-end',
              title: 'Thank you...',
              text: 'Utilisateur ajoute avec succes!',
              icon: 'success'
            });
            this.formData.reset();
            console.log(this.formData);
            location.reload();

          },
            error:() => {
              Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: 'Oops...',
                text: "il y a un erreur avec l'ajout!!"
              })
            }
        });
      }
    }

  getAllUser(){
    this.userService.getUsers()
    .subscribe(data=>{
      this.UserData=data;
      this.UserData = this.UserData.filter(user=>user.roles[0].name == 'ROLE_ADMIN')
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
    }
    );
  location.reload();
}
  modifier(id: number){}
}



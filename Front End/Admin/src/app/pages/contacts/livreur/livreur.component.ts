import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/core/models/user.model';
import { UserService } from 'src/app/core/services/auth/user.service';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-livreur',
  templateUrl: './livreur.component.html',
  styleUrls: ['./livreur.component.scss']
})
export class LivreurComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  term: any;
  formData: FormGroup;
  submitted = false;
  UserData: User[];

  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private userService:UserService) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Liste des livreurs', active: true }];
    this.formData = this.formBuilder.group({
      username: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      role: ['', [Validators.required]],
    });
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
      formData.append('name', this.formData.get('phone').value);
      formData.append('name', this.formData.get('role').value);
      }

    saveUser() {
      if (this.validSubmit){
       this.userService.createuser(this.formData.value)
        .subscribe({
          next: (res) => {
            Swal.fire({
              position: 'top-end',
              title: 'Thank you...',
              text: 'Utilisateur ajoute avec succes!',
              icon: 'success'
              
            });
            this.formData.reset();
            
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
            'Votre livreur a été supprimée.',  
            'success'  
          )  
        } else if (result.dismiss === Swal.DismissReason.cancel) {  
          Swal.fire(  
            'Annulé',  
            'Votre livreur est sécurisée :)',  
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

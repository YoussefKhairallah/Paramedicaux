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
  UserData: any[];
  users: any[]=[];

  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private userService:UserService) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Liste des livreurs', active: true }];
    this.formData = this.formBuilder.group({
      username: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      tel: ['', [Validators.required]],
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


    saveUser() {
      this.submitted = true;
      if(this.formData.invalid){
        return;
      }
      else{
        console.log(this.formData.value);
        let user = this.formData.value;
        user['nom'] = this.formData.value.username;
       this.userService.createuser(user,2)
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
      location.reload();
    }

    getAllUser(){
      this.userService.getUsers()
      .subscribe(data=>{
        this.UserData=data
       for(let us of this.UserData)
       {
        for(let rl of us.roles)
        {
          if(rl.name=="ROLE_LIVREUR")
          this.users.push(us);
        }

       }
        console.log(this.UserData,this.users)
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
      }

      );
location.reload();
    }
}

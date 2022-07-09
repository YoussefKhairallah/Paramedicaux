import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/core/models/user.model';
import { UserService } from 'src/app/core/services/auth/user.service';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

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
      nom: ['', [Validators.required]],
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
        this.UserData=data
       for(let us of this.UserData)
       {
        for(let rl of us.roles)
        {
          if(rl.name=="ROLE_CLIENT")
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
          'Votre client a été supprimée.',
          'success'
        )
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Annulé',
          'Votre client est sécurisée :)',
          'error'
        )
      }
    })
  }

  delete(id: number) {

    Promise.resolve(this.userService.deleteuser(id).subscribe(data => {
      console.log(data);
      this.getAllUser();

    })
    );
  location.reload();

}
}

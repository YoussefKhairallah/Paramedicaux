import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/core/models/user.module';
import { UserService } from 'src/app/core/services/Ecommerce/User/user.service';
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
       this.userService.createUser(this.formData.value)
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
      .subscribe({
        next:(res)=>{
          console.log(res);
        },
        error:()=>{
          Swal.fire({  
            position: 'top-end',
            icon: 'error',  
            title: 'Oops...',  
            text: 'Quelque chose est mal passé !',
            timer: 2500
          }) 
        }
      })
    }
    

}


import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from 'src/app/core/services/Ecommerce/User/user.service';
import Swal from 'sweetalert2';
import { User } from '../../../core/models/user.module';

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
  UserData: User[];
  // page
  currentpage: number;

  
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Liste des administrateurs', active: true }];
    this.formData = this.formBuilder.group({
      username: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      role: ['', [Validators.required]],
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
            timer: 1500
          }) 
        }
      })
  }
  

}



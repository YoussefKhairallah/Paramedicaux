import { state } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from 'src/app/core/services/Ecommerce/User/user.service';
import { User } from '../user.module';
import { UserData } from './data';
@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.scss']
})

/**
 * Contacts user-list component
 */
export class UserlistComponent implements OnInit {
  // bread crumb items
  breadCrumbItems: Array<{}>;
  term: any;
  formData: FormGroup;
  submitted = false;
  UserData: User[];
  // page
  currentpage: number;
  users: User ={
    id: 0,
    Nom: '',
    Prenom: '',
    DateNaissance: '',
    Tel: '',
    Mail: '',
    Mdp: '',
    Role: ''
  }
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Users List', active: true }];
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
    if (this.formData.valid) {
      const Nom = this.formData.get('username').value;
      const Prenom = this.formData.get('prenom').value;
      const DateNaissance = this.formData.get('dateNaissance').value;
      const Mail = this.formData.get('email').value;
      const Mdp = this.formData.get('password').value;
      const Tel = this.formData.get('phone').value;
      const Role = this.formData.get('role').value;

      const data = {
        nom: this.users.Nom,
        prenom: this.users.Prenom,
        mail: this.users.Mail,
        tel: this.users.Tel,
        dateNaissance: this.users.DateNaissance,
        role: this.users.Role,
        mdp: this.users.Mdp
      };

      this.userService.create(data)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.submitted = true;
          },
          error: (e) => console.error(e)
        });
    }
    this.submitted = false;
    
    this.users = {
      id: this.UserData.length + 1,
      Nom: '',
      Prenom: '',
      DateNaissance: '',
      Tel: '',
      Mail: '',
      Mdp: '',
      Role: ''
    };
  }
}

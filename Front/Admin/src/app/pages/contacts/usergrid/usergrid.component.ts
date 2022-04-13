import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { User } from './usergrid.model';

import { userData } from './data';

@Component({
  selector: 'app-usergrid',
  templateUrl: './usergrid.component.html',
  styleUrls: ['./usergrid.component.scss']
})

/**
 * Contacts user grid component
 */
export class UsergridComponent implements OnInit {
  // bread crumb items
  breadCrumbItems: Array<{}>;

  user: User[];
  selected;
  userForm: FormGroup;
  submitted = false;
  items: FormArray;
  // Select2 Dropdown
  selectValue: string[];
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.selectValue = ['Admin', 'Client', 'Livreur'];

    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Users Grid', active: true }];
    this.userForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      dateNaissance: ['', [Validators.required]],
      prenom:['', [Validators.required]],
      NumTel:['', [Validators.required]],
      email: ['', [Validators.required]]

    });
    /**
     * fetches data
     */
    this._fetchData();
  }

  get form() {
    return this.userForm.controls;
  }

  /**
   * Open modal
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content);
  }

  /**
   * User grid data fetches
   */
  private _fetchData() {
    this.user = userData;
  }

  /**
   * Save user
   */
  saveUser() {
    if (this.userForm.valid) {
      const name = this.userForm.get('name').value;
      const prenom = this.userForm.get('prenom').value;
      const Tel = this.userForm.get('NumTel').value;
      const dateNaissance = this.userForm.get('dateNaissance').value;
      const email = this.userForm.get('email').value;
       this.user.push({
         id: this.user.length + 1,
         name,
         prenom,
         dateNaissance,
         Tel,
         email,
         Role: this.selected
       })
       this.modalService.dismissAll()
    }
    this.submitted = true
  }
}

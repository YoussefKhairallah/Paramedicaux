import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Customers } from './customers.model';
import { customersData } from './data';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss']
})

/**
 * Ecomerce Customers component
 */
export class CustomersComponent implements OnInit {

  // bread crumb items
  breadCrumbItems: Array<{}>;
  formData: FormGroup;
  submitted = false;
  customersData: Customers[];
  term: any;

  // page
  currentpage: number;

  constructor(private modalService: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Customers', active: true }];

    this.formData = this.formBuilder.group({
      username: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      dateNaissance: ['', [Validators.required]],
      role: ['', [Validators.required]]
    });

    this.currentpage = 1;

    /**
     * Fetches the data
     */
    this._fetchData();
  }

  /**
   * Customers data fetches
   */
  private _fetchData() {
    this.customersData = customersData;
  }
  get form() {
    return this.formData.controls;
  }

  /**
   * Open modal
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content);
  }

  saveCustomer() {
    if (this.formData.valid) {
     const username = this.formData.get('username').value;
     const prenom = this.formData.get('prenom').value;
     const dateNaissance = this.formData.get('dateNaissance').value;
     const email = this.formData.get('email').value;
     const phone = this.formData.get('phone').value;
     const role = this.formData.get('role').value;

      this.customersData.push({
        id: this.customersData.length + 1,
        username,
        prenom,
        email,
        phone,
        dateNaissance,
        role
      })
      this.modalService.dismissAll()
    }
    this.submitted = true
  }
  modifierUser(): void{

  }

  supprimerUser(){
    console.log()
  }
}

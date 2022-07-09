import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Categorie } from 'src/app/core/models/categorie.model';
import { CategorieService } from 'src/app/core/services/Ecommerce/Categorie/categorie.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  categorieForm: FormGroup;
  submitted = false;
  term: any;
  categorieData:Array<Categorie> =[]
  router: any;
  editable = false;
  id: number;
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private categorieServices: CategorieService, router:Router) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Categorie', active: true }];
    
    this.categorieForm = this.formBuilder.group({
      nom: ['', [Validators.required]],
    })
    this.getAll();
  }
  get form() {
    return this.categorieForm.controls;
  }
   /**
   * Open modal
   * @param content modal content
   */
    openModal(content: any) {
      this.modalService.open(content);
    }
  
  validSubmit() {
    this.submitted = true;
    const formData = new FormData();
    formData.append('nom', this.categorieForm.get('nom').value);
  }

  edit(categorie,content){
    this.categorieForm.patchValue({
      nom: categorie.nom
    });
    this.id = categorie.id;
    this.editable = true;
    this.modalService.open(content);
  }


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
          'Votre catégorie a été supprimée.',  
          'success'  
        )  
      } else if (result.dismiss === Swal.DismissReason.cancel) {  
        Swal.fire(  
          'Annulé',  
          'Votre catégorie est sécurisée :)',  
          'error'  
        )  
      }  
    })  
  }

  delete(id: number) {
    this.categorieServices.deletecategorie(id).subscribe(data => {
      console.log(data);
      this.getAll();
    }
    );
  }

  getAll():void{
    this.categorieServices.getCategories()
    .subscribe(data=>{
      this.categorieData=data
      console.log(data)
    })
  }
  
  saveCategorie(): void {
    console.log(this.categorieForm.value);
    if(this.editable)
    {
      this.categorieServices.updatecategorie(this.id,this.categorieForm.value)
      .subscribe(res => {
        this.getAll();
        this.modalService.dismissAll();
        this.categorieForm.reset();
      }, error => {
        error: error = console.error()
      });
    }
    else{
      this.categorieServices.createcategorie(this.categorieForm.value)
        .subscribe(res => {
          this.getAll();
          this.modalService.dismissAll();
          this.categorieForm.reset();
        }, error => {
          error: error = console.error()
        });
    }
   }
}

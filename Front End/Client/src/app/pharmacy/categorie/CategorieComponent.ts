import { Component, OnInit } from '@angular/core';
import { ProduitService } from '../../shared/services/Ecommerce/Produit/produit.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from '../../shared/models/produit.model';

import { DetailCommande } from '../../shared/models/detail-commande.models';
import Swal from 'sweetalert2';
import { Categorie } from 'src/app/shared/models/categorie.model';



@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css']
})
export class CategorieComponent implements OnInit {
  id!: number;
  produits: any;
  article!: Produit;
  categorieData:Array<Categorie> =[]
  quantity: number = 1;
  cartItems: DetailCommande[]=[];
  error = false;
  exists: boolean =false;
  oldquantite: any;
  i!: number;
  quantite: number = 1;
  art!: DetailCommande;
  key!: number;
  constructor(private produitservice: ProduitService, private router: Router, private actRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = parseInt(this.actRouter.snapshot.paramMap.get("id")!);
    this.getProduits(this.id);
  }

  getProduits(id: number) {
    this.produitservice.getProduitsByCategories(id).subscribe(data => {
      console.log('data::',data);
      this.produits = data;
    });
  }
  addToCart(){
    /*
    let product :DetailCommande = {} as DetailCommande;
    //product = this.article;
    product.qte = this.quantity;
    product.total = parseInt(this.article.prix) * this.quantity;
    product.id_produit = this.article;
    console.log('product',product);
    this.cartItems.push(product);
    localStorage.setItem('cartItems',JSON.stringify(this.cartItems));
    */
    console.log(this.exists);
    //alert('Your product has been added to the cart!');
    if(this.quantity > this.article.qte || this.quantity < 1){
      this.error = true;
    }
    
      this.i = 0;
      this.cartItems.filter(pro  => {
        console.log(pro);
        if(pro.produit.id == this.article!.id){
          this.exists = true;
          this.oldquantite = pro.qte;
          this.key = this.i;
          this.confirm();
        }
        this.i++;
      });
      if(this.exists){
        this.cartItems[this.key].qte= this.oldquantite + this.quantity;
        this.cartItems[this.key].total= (this.oldquantite + this.quantity) * parseFloat(this.article.prix);
        console.log(this.cartItems);
        localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    }
        else{
              let product = new DetailCommande();
              product['id'] = this.article.id;
              product['qte'] = this.quantity;
              product.total = parseFloat(this.article.prix) * this.quantity;
              console.log();
              product.produit = this.article;
              console.log(product);
              this.cartItems =JSON.parse(localStorage.getItem('cartItems') || '[]');
              this.cartItems.push(product);
              localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
              this.router.navigate(['/panier']);
              this.confirm();
          }  

          
  }

  confirm() {
    Swal.fire({
      title: 'Panier',
      text: 'Votre Produit ajouter avec succé',
      icon: 'success',
      showCancelButton: true,
      confirmButtonColor: '#34c38f',
      cancelButtonColor: '#f46a6a',
      confirmButtonText: 'acceder au panier!',
      cancelButtonText: 'Continuez vos achats!'
    }).then(result => {
      if (result.value) {
        this.router.navigate(['/pharmacy/cart']);
      }
      else {
        this.router.navigate(['/home']);
      }
    });
  }
}

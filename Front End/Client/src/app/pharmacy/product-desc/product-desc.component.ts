import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from 'src/app/shared/services/Ecommerce/Produit/produit.service';
import { Produit } from '../../shared/models/produit.model';
import { Commande } from '../../shared/models/Commande.model';
import { DetailCommande } from '../../shared/models/detail-commande.models';
import Swal from 'sweetalert2';
import { Panier } from '../../shared/models/panier.model';

@Component({
  selector: 'app-product-desc',
  templateUrl: './product-desc.component.html',
  styleUrls: ['./product-desc.component.css']
})
export class ProductDescComponent implements OnInit {
  
  id!: number;
  article!: Produit;
  quantity: number = 1;
  cartItems: DetailCommande[]=[];
  error = false;
  exists: boolean =false;
  oldquantite: any;
  i!: number;
  quantite: number = 1;
  art!: DetailCommande;
  key!: number;

  constructor( private produitServices:ProduitService, private actRouter: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = parseInt(this.actRouter.snapshot.paramMap.get("id")!);
    this.getProduitId(this.id);
    this.cartItems = JSON.parse(localStorage.getItem('cartItems') || '[]');
    console.log(this.cartItems);
  }

  getProduitId(id: number){
    this.produitServices.getProduitByID(id)
    .subscribe(data=>{
      this.article=data
      console.log('produits',data)
    })
  }

  minus(){
    if(this.quantity>1){
      this.quantity--;
    }
  }
  plus(){
    if(this.quantity< this.article.qte){
    this.quantity++;
    }
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

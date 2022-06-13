import { Component, OnInit } from '@angular/core';
import { Commande } from 'src/app/shared/models/Commande.model';
import { DetailCommandeService } from 'src/app/shared/services/Ecommerce/Commande/detailcommande.service';

import { CommandeService } from '../../shared/services/Ecommerce/Commande/commande.service';
import { Panier } from '../../shared/models/panier.model';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { DetailCommande } from 'src/app/shared/models/detail-commande.models';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems: DetailCommande[]=[];
  quantity: number[]=[];
  total!:number;
  tva= 10;
  livraison = 10;
  user: any;
  totale!: number;
  ln!: number;
  
  constructor(private toastr: ToastrService, public router: Router,
    private commandeservice: CommandeService, private detail: DetailCommandeService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('userInfo') || '[]');
    this.cartItems = JSON.parse(localStorage.getItem('cartItems') || '[]');
    this.ln = this.cartItems.length;
    console.log(this.ln);
    this.getTotal();
    this.getProducts();
    this.totale = this.total +((this.total + this.livraison)* this.tva)/100;
    console.log("total:",this.total);
    console.log("totale:",this.totale);
    console.log("tva:",this.tva);
  }

  getProducts(){
    
    console.log(this.cartItems);
    this.total = 0;
    this.tva = 10; 
    this.cartItems.forEach(element => {
      console.log(element);
      this.quantity.push(element.qte);
      this.total += element.total;
      console.log('total:',this.total,'tva',this.tva);
    });
    this.total = this.total +((this.total + this.livraison)* this.tva)/100;
    if(this.total>500)
    this.livraison = 0;

    this.cartItems.forEach((num1, index) => {
      const num2 = this.quantity[index];
      console.log('num1:',num1,'num2:', num2);
    });
    console.log('tva::',this.tva);
  }

  minus(i:number, prix: string){
    if(this.cartItems[i].qte>1){
      this.cartItems[i].qte--;
      this.cartItems[i].total = this.cartItems[i].qte * parseFloat(prix);
      console.log(this.cartItems[i].qte);
      localStorage.setItem('cartItems',JSON.stringify(this.cartItems));
      this.getTotal();
    }
  }

  plus(qte: number, i: number, prix: string){
    console.log(qte);
    if(this.cartItems[i].qte< qte){
      this.cartItems[i].qte++;
      this.cartItems[i].total = this.cartItems[i].qte * parseFloat(prix);
    console.log(this.cartItems[i].qte);
    localStorage.setItem('cartItems',JSON.stringify(this.cartItems));
    this.getTotal();
    }
  }

  getTotal(){
    this.total = 0;
    this.cartItems.forEach(element => {
      this.total += element.total;
    });
  }

  commander(){
      this.router.navigate(['/pharmacy/checkout']);
  }

  delete(i:number){
    //alert(i);
    delete this.cartItems[i];
    this.cartItems.splice(i,1);
    if(this.cartItems.length == 0){
      localStorage.removeItem('cartItems');
    }
    console.log(this.cartItems);
    localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    console.log(JSON.parse(localStorage.getItem('cartItems') || '[]'));
  }
}

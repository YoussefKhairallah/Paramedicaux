import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Commande } from 'src/app/shared/models/Commande.model';
import { DetailCommande } from 'src/app/shared/models/detail-commande.models';
import { CommandeService } from 'src/app/shared/services/Ecommerce/Commande/commande.service';
import { DetailCommandeService } from 'src/app/shared/services/Ecommerce/Commande/detailcommande.service';
@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  nom='';
  prenom = '';
  email = '';
  phone = '';
  chekbox1 = '';
  chekbox2 = '';
  radio1 = '';
  radio2 ='';
  cartItems: any[]=[];
  quantity: number[]=[];
  total!:number;
  tva= 19;
  livraison = 10;
  user: any;
  subtotal!: number;
  ln!: number;
  adresse!:string;

  constructor(private toastr: ToastrService, public router: Router,
    private commandeservice: CommandeService, private detail: DetailCommandeService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('userInfo') || '[]');
    this.cartItems = JSON.parse(localStorage.getItem('cartItems') || '[]');
    this.ln = this.cartItems.length;
    console.log(this.ln);
    //this.getTotal();
    this.getProducts();
    this.total = this.total +((this.subtotal + this.livraison)* this.tva)/100;
  }

  getProducts(){
    
    console.log(this.cartItems);
    this.subtotal = 0;
    this.tva = 0; 
    this.cartItems.forEach(element => {
      console.log(element);
      this.quantity.push(element.qte);
      this.subtotal += element.total;
      console.log(this.subtotal,this.tva);
    });
    this.total = this.subtotal +((this.subtotal + this.livraison)* this.tva)/100;
    if(this.total>500)
    this.livraison = 0;

    this.cartItems.forEach((num1, index) => {
      const num2 = this.quantity[index];
      console.log(num1, num2);
    });
    console.log(this.tva);
  }
  confirmer(){
    if (this.nom === '' || this.prenom === '' || this.email === '' || this.phone === '' || this.chekbox1 === '' || this.chekbox2 === '' || this.radio1 === '' || this.radio2 === '') {
      this.toastr.error('', 'Veuillez saisir les champs obligatoire !');
    this.router.navigate(['/pharmacy/success']);
    }
  }

  getTotal(){
    this.total = 0;
    this.cartItems.forEach(element => {
      this.total += element.total;
    });
  }


  commander(){
      let commande = new Commande();
      commande.id_client = this.user;
      commande.date = new Date().toISOString().slice(0,10);
      commande.etat = "En cours";
      commande.prix_totale = this.total;
      commande.adresse = this.adresse;
      console.log('commande',commande);
      this.commandeservice.createCommande(commande).subscribe(
        (data) => {
          console.log('commande',data);
          let cmd = data as Commande;
          this.cartItems.forEach(element => {
            let detail = new DetailCommande();
            detail.commande = data as Commande;
            detail.produit = element.produit;
            detail.qte = element.qte;
            detail.total = element.total;
            console.log('detailcommande',detail, 'commande::', detail.commande);
            this.detail.createDetailCommande(detail).subscribe(
              (data) => {
                console.log(data);
                this.router.navigate(['/pharmacy/success']); 
              }
            );
          });
        });

  }

}

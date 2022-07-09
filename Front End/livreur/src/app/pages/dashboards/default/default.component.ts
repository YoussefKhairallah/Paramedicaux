import { Component, OnInit, ViewChild } from '@angular/core';
import { emailSentBarChart, monthlyEarningChart } from './data';
import { ChartType } from './dashboard.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EventService } from '../../../core/services/event.service';

import { ConfigService } from '../../../core/services/config.service';
import { ProductsComponent } from './../../ecommerce/products/products.component';
import { CategorieService } from 'src/app/core/services/Ecommerce/Categorie/categorie.service';
import { ProduitService } from 'src/app/core/services/Ecommerce/Produit/produit.service';
import { CommandeService } from '../../../core/services/Ecommerce/Commande/commande.service';
import { User } from 'src/app/core/models/user.model';


@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent implements OnInit {

  isVisible: string;

  emailSentBarChart: ChartType;
  monthlyEarningChart: ChartType;
  transactions: Array<[]>;
  statData: any;
  produitData=[];
  commandes=[];
  categories=[];
  isActive: string;
  currentUser:User;
  prt=0;

  @ViewChild('content') content;
  constructor(private modalService: NgbModal, private configService: ConfigService, private eventService: EventService, private prodServices:ProduitService, private categorieServices:CategorieService,private commandesapi:CommandeService ) {
  }

  ngOnInit() {
    if(localStorage.length==0)
    {
      window.location.replace("./account/login");
    }
this.currentUser=JSON.parse(localStorage.getItem("userInfo")) as User;
console.log("current",this.currentUser);
console.log("current",this.currentUser.nom);
    /**
     * horizontal-vertical layput set
     */
     const attribute = document.body.getAttribute('data-layout');

     this.isVisible = attribute;
     const vertical = document.getElementById('layout-vertical');
     if (vertical != null) {
       vertical.setAttribute('checked', 'true');
     }
     if (attribute == 'horizontal') {
       const horizontal = document.getElementById('layout-horizontal');
       if (horizontal != null) {
         horizontal.setAttribute('checked', 'true');
         console.log(horizontal);
       }
     }

    /**
     * Fetches the data
     */
    this.getAllCategories();
    this.getAllProduit();
    this.getAllCommandes();

     this.statData= [{
      "icon": "bx bx-copy-alt",
      "title": "Commandes",
      "value": localStorage.getItem("cmds")
    }, {
      "icon": "bx bx-archive-in",
      "title": "produits",
      "value": localStorage.getItem("prods")
    }, {
      "icon": "bx bx-purchase-tag-alt",
      "title": "Catégories",
      "value": localStorage.getItem("cats")
    }]
    this.fetchData();
  }
  getAllCategories():void{
    this.categorieServices.getCategories()
    .subscribe({
      next: (data) => {
        this.categories = data;
        console.log(this.categories);
        localStorage.setItem("cats",this.categories.length.toString());
    },
    error: (e) => console.error(e),
  });

    console.log("cats",this.categories.length.toString());
  }
  getAllProduit(){
    this.prodServices.getProduits()
    .subscribe(data=>{
      this.produitData=data
      console.log(data)
      localStorage.setItem("prods",this.produitData.length.toString());
    })
  }
  getAllCommandes(){
    this.commandesapi.getCommandes()
    .subscribe(data=>{
      this.commandes=data;
      console.log(data);

      for(let cm of this.commandes)
      {
        this.prt+=cm.prix_totale;
      }
      localStorage.setItem("cmds",this.commandes.length.toString());
    })
  }
  /**
   * Fetches the data
   */
  private fetchData() {
    this.emailSentBarChart = emailSentBarChart;
    this.monthlyEarningChart = monthlyEarningChart;

    this.isActive = 'year';
    this.configService.getConfig().subscribe(data => {
      this.transactions = data.transactions;
      this.statData = this.statData;
    });
  }

  weeklyreport() {
    this.isActive = 'week';
    this.emailSentBarChart.series =
      [{
        name: 'Series A',
         data: [44, 55, 41, 67, 22, 43, 36, 52, 24, 18, 36, 48]
      }, {
        name: 'Series B',
        data: [11, 17, 15, 15, 21, 14, 11, 18, 17, 12, 20, 18]
      }, {
        name: 'Series C',
        data: [13, 23, 20, 8, 13, 27, 18, 22, 10, 16, 24, 22]
      }];
  }

  monthlyreport() {
    this.isActive = 'month';
    this.emailSentBarChart.series =
      [{
        name: 'Series A',
         data: [44, 55, 41, 67, 22, 43, 36, 52, 24, 18, 36, 48]
      }, {
        name: 'Series B',
        data: [13, 23, 20, 8, 13, 27, 18, 22, 10, 16, 24, 22]
      }, {
        name: 'Series C',
        data: [11, 17, 15, 15, 21, 14, 11, 18, 17, 12, 20, 18]
      }];
  }

  yearlyreport() {
    this.isActive = 'year';
    this.emailSentBarChart.series =
      [{
        name: 'Series A',
         data: [13, 23, 20, 8, 13, 27, 18, 22, 10, 16, 24, 22]
      }, {
        name: 'Series B',
        data: [11, 17, 15, 15, 21, 14, 11, 18, 17, 12, 20, 18]
      }, {
        name: 'Series C',
        data: [44, 55, 41, 67, 22, 43, 36, 52, 24, 18, 36, 48]
      }];
  }


  /**
   * Change the layout onclick
   * @param layout Change the layout
   */
   changeLayout(layout: string) {
    this.eventService.broadcast('changeLayout', layout);
  }
}
function next(next: any, arg1: (data: any) => void) {
  throw new Error('Function not implemented.');
}


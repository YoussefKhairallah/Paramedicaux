import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Commande } from 'src/app/core/models/Commande.model';
import { DetailCommande } from 'src/app/core/models/detailleCommande.module';
import { CommandeService } from 'src/app/core/services/Ecommerce/Commande/commande.service';
import { DetailCommandeService } from 'src/app/core/services/Ecommerce/DetailCommande/detail-commande.service';
@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})

/**
 * Invoices Detail component
 */
export class DetailComponent implements OnInit {

 // bread crumb items
 breadCrumbItems: Array<{}>;
 OrdersData: Commande[];
 commandeData: DetailCommande[];
 id:number;
  totale: number=0;
  shipping=10;
  commande: any;
 constructor(private commandeService: CommandeService, private detailCommande: DetailCommandeService,
  private actRouter: ActivatedRoute,) { }

 ngOnInit() {
   this.breadCrumbItems = [{ label: 'Facture' }, { label: 'Detail', active: true }];
   this.id = parseInt(this.actRouter.snapshot.paramMap.get("id"));
   this.getCommandeById(this.id);
  this.getDetailCommande(this.id);
  }
  getCommandeById(id: number){
    this.commandeService.getCommandeByID(id)
    .subscribe(data => {
      this.commande =  data;
      console.log(this.commande);
    })
  }
  getDetailCommande(id){
    this.detailCommande.getDetailCommande()
    .subscribe(data =>{
      this.commandeData= data
      this.commandeData = this.commandeData.filter(data => data.commande.id == id)
      this.commandeData.forEach(data=>{
        this.totale += data.total;
      })
      if(this.totale > 200) this.shipping = 0;
      console.log('Detail Commande:: ', data)
    })
  }
}


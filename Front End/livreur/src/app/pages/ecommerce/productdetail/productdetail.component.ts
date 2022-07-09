import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Produit } from 'src/app/core/models/produit.model';
import { ProduitService } from 'src/app/core/services/Ecommerce/Produit/produit.service';
import { productModel, productList } from '../product.model';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss']
})

/**
 * Ecommerce product-detail component
 */
export class ProductdetailComponent implements OnInit {

  breadCrumbItems: Array<{}>;
  public productDetail: productModel[];
  produitData: Produit;
  isImage;
  id:number;

  constructor(private route: ActivatedRoute, private produitServices:ProduitService, private actRouter: ActivatedRoute) {
    this.route.params.subscribe(params =>
      this.productDetail = productList.filter(function (product) {
        return product.id == parseInt(params.id)
      })
    );
    this.isImage = this.productDetail[0].images[0];
  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Détail du produit', active: true }];
    this.id = parseInt(this.actRouter.snapshot.paramMap.get("id"));
    this.getProduitId(this.id);
  }

  /**
   * onclick Image show
   * @param event image passed
   */
  imageShow(event) {
    const image = event.target.src;
    this.isImage = image;
    const expandImg = document.getElementById('expandedImg') as HTMLImageElement;
    expandImg.src = image;
  }

  getProduitId(id: number){
    this.produitServices.getProduitByID(id)
    .subscribe(data=>{
      this.produitData=data
      console.log('produits',data)
    })
  }
}

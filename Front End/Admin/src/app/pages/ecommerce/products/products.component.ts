import { Component, OnInit } from '@angular/core';
import { productModel, productList } from '../product.model';
import { Options } from 'ng5-slider';
import { HttpClient } from '@angular/common/http';
import { ProduitService } from 'src/app/core/services/Ecommerce/Produit/produit.service';
import { Produit } from 'src/app/core/models/produit.model';
import { Categorie } from 'src/app/core/models/categorie.model';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})

/**
 * Ecommerce products component
 */

export class ProductsComponent implements OnInit {
  
  produitData: Array<Produit> = [];
  categoriesData: Array<Categorie>= [];
  breadCrumbItems: Array<{}>;
  pricevalue = 100;
  minVal = 100;
  maxVal = 500;
  
  priceoption: Options = {
    floor: 0,
    ceil: 800,
    translate: (value: number): string => {
      return '$' + value;
    },
  };
  log = '';
  discountRates: number[] = [];
  public products: productModel[] = [];
  public productTemp: productModel[] = [];

  constructor(private http: HttpClient, private prodServices:ProduitService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Les produits', active: true }];
    this.products = Object.assign([], productList);
    this.getAllProduit();
  }

  searchFilter(e) {
    const searchStr = e.target.value;
    this.products = productList.filter((product) => {
      return product.name.toLowerCase().search(searchStr.toLowerCase()) !== -1;
    });
  }

  discountLessFilter(e, percentage) {
    if (e.target.checked && this.discountRates.length === 0) {
      this.products = productList.filter((product) => {
        return product.discount < percentage;
      });
    }
    else {
      this.products = productList.filter((product) => {
        return product.discount >= Math.max.apply(null, this);
      }, this.discountRates);
    }
  }

  discountMoreFilter(e, percentage: number) {
    if (e.target.checked) {
      this.discountRates.push(percentage);
    } else {
      this.discountRates.splice(this.discountRates.indexOf(percentage), 1);
    }
    this.products = productList.filter((product) => {
      return product.discount >= Math.max.apply(null, this);
    }, this.discountRates);
  }

  valueChange(value: number, boundary: boolean): void {
    if (boundary) {
      this.minVal = value;
    } else {
      this.maxVal = value;
      this.products = productList.filter(function (product) {
        return product.disRate <= value && product.disRate >= this;
      }, this.minVal);
    }
  }
  getAllProduit(){
    this.prodServices.getProduits()
    .subscribe(data=>{
      this.produitData=data
      console.log(data)
    })
  }
}

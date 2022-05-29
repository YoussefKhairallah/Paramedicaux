import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategorieComponent } from "./CategorieComponent";
import { CategorieRoutingModule } from './categorie-routing.module';



@NgModule({
  declarations: [ CategorieComponent ],
  imports: [
    CommonModule,
    CategorieRoutingModule
  ]
})
export class CategorieModule { }
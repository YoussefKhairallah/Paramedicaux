import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategorieComponent } from "./CategorieComponent";
import { CategorieRoutingModule } from './categorie-routing.module';
import { NgSelect2Module } from 'ng-select2';



@NgModule({
  declarations: [ CategorieComponent ],
  imports: [
    CommonModule,
    CategorieRoutingModule,
    NgSelect2Module
  ]
})
export class CategorieModule { }
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductDescComponent } from './product-desc.component';
import { ProductDescRoutingModule } from './product-desc-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ ProductDescComponent ],
  imports: [
    CommonModule,
    ProductDescRoutingModule,
    FormsModule
  ]
})
export class ProductDescModule { }

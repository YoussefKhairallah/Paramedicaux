import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PharmacyComponent } from './pharmacy.component';

const routes: Routes = [
  {
    path: '',
    component: PharmacyComponent,
    children: [
      {
        path: 'cart',
        loadChildren: () =>
          import('./cart/cart.module').then((m) => m.CartModule),
      },
      {
        path: 'checkout',
        loadChildren: () =>
          import('./checkout/checkout.module').then((m) => m.CheckoutModule),
      },
      {
        path: 'products',
        loadChildren: () =>
          import('./products/products.module').then((m) => m.ProductsModule),
      },
      {
        path: 'product-desc/:id',
        loadChildren: () =>
          import('./product-desc/product-desc.module').then((m) => m.ProductDescModule),
      },
      {
        path: 'success',
        loadChildren: () =>
          import('./success/success.module').then((m) => m.SuccessModule),
      },
      {
        path: 'categorie/:id',
        loadChildren: () =>
          import('./categorie/categorie.module').then((m) => m.CategorieModule),
      }
    ],
  },
  
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class PharmacyRoutingModule { }

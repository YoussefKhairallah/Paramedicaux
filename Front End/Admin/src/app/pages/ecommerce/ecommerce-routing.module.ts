import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './products/products.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { OrdersComponent } from './orders/orders.component';
import { CategorieComponent } from './categorie/categorie.component';
import { AvisComponent } from './avis/avis.component';
import { LivraisonComponent } from './livraison/livraison.component';


const routes: Routes = [
    {
        path: 'products',
        component: ProductsComponent
    },
    {
        path: 'product-detail/:id',
        component: ProductdetailComponent
    },
    {
        path: 'add-product',
        component: AddproductComponent
    },

    {
        path: 'orders',
        component: OrdersComponent
    },
    {
        path:"categories",
        component:CategorieComponent
    },
    {
        path:"avis",
        component:AvisComponent
    },
    {
        path:'livraison',
        component:LivraisonComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EcommerceRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './products/products.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { CustomersComponent } from './customers/customers.component';
import { OrdersComponent } from './orders/orders.component';
import { CategoriesComponent } from './categories/categories.component';
import { AddCategorieComponent } from './add-categorie/add-categorie.component';

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
        path: 'customers',
        component: CustomersComponent
    },
    {
        path: 'orders',
        component: OrdersComponent
    },
    {
        path:'categories',
        component:CategoriesComponent
    },
    {
        path:'add-categorie',
        component:AddCategorieComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EcommerceRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserlistComponent } from './userlist/userlist.component';

import { ProfileComponent } from './profile/profile.component';
import { LivreurComponent } from './livreur/livreur.component';
import { ClientComponent } from './client/client.component';


const routes: Routes = [
    {
        path: 'list',
        component: UserlistComponent
    },

    {
        path: 'profile',
        component: ProfileComponent
    },

    {
        path:'livreur',
        component:LivreurComponent
    },

    {
        path:'client',
        component:ClientComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ContactsRoutingModule { }

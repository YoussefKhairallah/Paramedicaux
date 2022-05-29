import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PatientsComponent } from './patients.component';

const routes: Routes = [
  {
    path: '',
    component: PatientsComponent,
    children: [
      { path: '', redirectTo: 'Dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        loadChildren: () =>
          import('./dashboard/dashboard.module').then((m) => m.DashboardModule),
      },
      {
        path: 'favourites',
        loadChildren: () =>
          import('./favourites/favourites.module').then(
            (m) => m.FavouritesModule
          ),
      },
      {
        path: 'patient-profile',
        loadChildren: () =>
          import('./patient-profile/patient-profile.module').then(
            (m) => m.PatientProfileModule
          ),
      },
      {
        path: 'settings',
        loadChildren: () =>
          import('./settings/settings.module').then((m) => m.SettingsModule),
      },
      {
        path: 'success',
        loadChildren: () =>
          import('./success/success.module').then((m) => m.SuccessModule),
      },
      {
        path: 'checkout',
        loadChildren: () =>
          import('./checkout/checkout.module').then((m) => m.CheckoutModule),
      },

      { 
        path: 'accounts',
        loadChildren: () => 
        import('./patient-accounts/patient-accounts.module').then(m => m.PatientAccountsModule),
       },
       { 
         path: 'orders', 
         loadChildren: () => 
         import('./orders-list/orders-list.module').then(m => m.OrdersListModule), 
        },
        { 
          path: 'patients-change-password', 
          loadChildren: () => 
          import('./patients-change-password/patients-change-password.module').then(m => m.PatientsChangePasswordModule), 
        },
        { 
          path: 'patient-chat', 
          loadChildren: () => 
          import('./patient-chat/patient-chat.module').then(m => m.PatientChatModule), 
        }
        
    ],
  },
  
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PatientsRoutingModule {}

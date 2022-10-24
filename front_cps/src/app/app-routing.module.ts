import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DefaultComponent } from './component/default/default.component';
import { OrderComponent } from './component/order/order.component';
const routes: Routes = [
    {path: 'default',component:DefaultComponent},
    {path: 'home', component:OrderComponent},
    {path:'**', pathMatch: 'full', redirectTo:'home'}
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
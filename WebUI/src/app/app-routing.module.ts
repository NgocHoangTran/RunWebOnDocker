import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateSinhvienComponent } from './sinhvien/create-sinhvien/create-sinhvien.component';
import { ListSinhvienComponent } from './sinhvien/list-sinhvien/list-sinhvien.component';
import { UpdateSinhvienComponent } from './sinhvien/update-sinhvien/update-sinhvien.component';

const routes: Routes = [
  {path:'', redirectTo:'sinhvien', pathMatch:'full'},
  {path: 'add', component: CreateSinhvienComponent},
  {path:'danhsachsinhvien', component:ListSinhvienComponent},
  {path:'update', component:UpdateSinhvienComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

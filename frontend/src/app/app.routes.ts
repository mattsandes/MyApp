import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ServicesComponent } from './components/services/services.component';
import { DataComponent } from './components/data/data.component';

export const routes: Routes = [
    {path: 'data', component: DataComponent},
    {path: 'home', component: HomeComponent},
    {path: 'about', component: AboutComponent},
    {path: 'services', component: ServicesComponent},
    {path: '', redirectTo: 'home', pathMatch: 'full'}
];

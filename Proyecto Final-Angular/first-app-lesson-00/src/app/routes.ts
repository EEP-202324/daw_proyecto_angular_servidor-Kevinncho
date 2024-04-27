import { Routes } from "@angular/router";
import { FacultadComponent } from "./facultad/facultad.component";
import { DetallesComponent } from "./detalles/detalles.component";
import { AgregarFacultadComponent } from "./agregar-facultad/agregar-facultad.component";
const routeConfig: Routes = [
  {
    path: '',
    component: FacultadComponent,
    title: 'Home page'
  },
  {
    path: 'details/:id',
    component: DetallesComponent,
    title: 'Facultad detalles'
  },
  {
    path: 'agregar',
    component:AgregarFacultadComponent,
    title: 'Agregar Facultad'
  }
];

export default routeConfig;

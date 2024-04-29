import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UbicacionFacultadComponent } from '../ubicacion-facultad/ubicacion-facultad.component';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { FacultadService } from '../facultad.service';
import { RouterModule } from '@angular/router';
import './facultad.component.css';

@Component({
  selector: 'app-facultad',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    UbicacionFacultadComponent,
  ],
  template: `
  <section>
    <form>
      <input type="text" placeholder="Filtrar por cuidad" #filter>
      <button class="primary" type="button" (click)="filtrarResultados(filter.value)">Buscar</button>
    </form>
    <br>
    <a [routerLink]="['/agregar']"> <button class="boton agregar" type="button" >Agregar</button></a>


  </section>
  <section class="results">
  <app-ubicacion-facultad *ngFor= "let ubicacionFacultad of listaUbicacionesFiltradas"
  [ubicacionFacultad]="ubicacionFacultad">
  </app-ubicacion-facultad>
  </section>
`,
  styleUrls: ['./facultad.component.css'],
})
export class FacultadComponent {

    ubicacionFacultadList: UbicacionFacultad[]=[];
    listaUbicacionesFiltradas: UbicacionFacultad[]=[];
    facultadService: FacultadService= inject(FacultadService);

    constructor() {
      /*
      this.facultadService.getAllUbicacionFacultades().then((ubicacionFacultadList: UbicacionFacultad[]) => {
        this.ubicacionFacultadList = ubicacionFacultadList;
        this.listaUbicacionesFiltradas = this.ubicacionFacultadList;
      });
    }
    */
      this.facultadService.getFacultades().subscribe(
        facultades =>{
          this.ubicacionFacultadList=facultades;
          this.listaUbicacionesFiltradas=facultades;
        }
      )
    }
    filtrarResultados(text: string){
      if(!text){
        this.listaUbicacionesFiltradas=this.ubicacionFacultadList;
        return;
      }
      this.listaUbicacionesFiltradas=this.ubicacionFacultadList.filter(
        ubicacionFacultad => ubicacionFacultad?.ciudad.toLowerCase().includes(text.toLowerCase())
      );}
      AgregarFacultades(){
      }
      BorrarFacultades(){
      }

      ModificarFacultades(){

      }
}


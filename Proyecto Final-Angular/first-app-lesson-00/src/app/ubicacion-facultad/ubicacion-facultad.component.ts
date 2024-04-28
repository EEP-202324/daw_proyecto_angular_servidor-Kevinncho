import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { RouterModule } from '@angular/router';
import { FacultadService } from '../facultad.service';

@Component({
  selector: 'app-ubicacion-facultad',
  standalone: true,
  imports:[
    CommonModule,
    RouterModule,
  ],
  template: `
   <section class="listing">
    <img class="listing-photo" [src]="ubicacionFacultad.photo" alt="Exterior photo of {{ubicacionFacultad.nombre}}">
    <h2 class="listing-heading">{{ ubicacionFacultad.nombre }}</h2>
    <p class="listing-location">{{ ubicacionFacultad.ciudad}}, {{ubicacionFacultad.campus }}</p>
    <a [routerLink]= "['/details', ubicacionFacultad.id]">Mas detalles</a>
  </section>
  `,
  styleUrls: ['./ubicacion-facultad.component.css'],
})
export class UbicacionFacultadComponent implements OnInit{
  ubicacionFacultades: UbicacionFacultad[]=[]
  constructor(private facultadService: FacultadService){}

  ngOnInit(): void {
    this.ObtenerFacultades();
  }
  ObtenerFacultades(){
    this.facultadService.getFacultades().subscribe(
      facultades =>{
          this.ubicacionFacultades=facultades;
      },
      error =>{
        console.error('Error al obtener las facultades: ', error);
      }
    );
  }
  @Input() ubicacionFacultad!: UbicacionFacultad;
}

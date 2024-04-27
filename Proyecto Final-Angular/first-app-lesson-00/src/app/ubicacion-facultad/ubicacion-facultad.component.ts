import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { RouterModule } from '@angular/router';

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
export class UbicacionFacultadComponent {
  @Input() ubicacionFacultad!: UbicacionFacultad;
}

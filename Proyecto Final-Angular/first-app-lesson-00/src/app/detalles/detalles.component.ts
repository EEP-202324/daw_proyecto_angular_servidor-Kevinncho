import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FacultadService } from '../facultad.service';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule

  ],
  template: `
  <article>
    <img class="listing-photo" [src]="ubicacionFacultad?.photo"
      alt="Exterior photo of {{ubicacionFacultad?.nombre}}"/>
    <section class="listing-description">
      <h2 class="listing-heading">{{ubicacionFacultad?.nombre}}</h2>
      <p class="listing-location">{{ubicacionFacultad?.ciudad}}, {{ubicacionFacultad?.campus}}</p>
    </section>
    <section class="listing-features">
      <h2 class="section-heading">About this housing location</h2>
      <ul>
        <li>Carreras de la facultad: {{ubicacionFacultad?.carreras}}</li>
        <li>Does this location have wifi: {{ubicacionFacultad?.wifi}}</li>
      </ul>
      <section class="listing-apply">
      <h2 class="section-heading">Aplicar ahora para estuidar aqui</h2>
      <form [formGroup]="aplicarForm" (submit)="presentarSolicitud()">
        <label for="Nombre">Nombre</label>
        <input id="Nombre" type="text" formControlName="Nombre">

        <label for="Apellido">Apellido</label>
        <input id="Apellido" type="text" formControlName="Apellido">

        <label for="email">Email</label>
        <input id="email" type="email" formControlName="email">
        <button type="submit" class="primary">Aplicar</button>
      </form>
    </section>
    </section>
  </article>
`,
  templateUrl: './detalles.component.html',
  styleUrl: './detalles.component.css'

})
export class DetallesComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  facultadService= inject(FacultadService);
  ubicacionFacultad: UbicacionFacultad | undefined;
  aplicarForm = new FormGroup({
    Nombre: new FormControl(''),
    Apellido: new FormControl(''),
    email: new FormControl('')
  })


    constructor() {
        const UbicacionFacultadId = Number(this.route.snapshot.params['id']);

        this.facultadService.getUbicacionFacultad(UbicacionFacultadId).subscribe(
          ubicacionFacultad=>{
            this.ubicacionFacultad=ubicacionFacultad;
          }
        )

  }
    presentarSolicitud(){
      this.facultadService.presentarSolicitud(
        this.aplicarForm.value.Nombre ?? '',
        this.aplicarForm.value.Apellido ?? '',
        this.aplicarForm.value.email ?? ''
      );
    }
}

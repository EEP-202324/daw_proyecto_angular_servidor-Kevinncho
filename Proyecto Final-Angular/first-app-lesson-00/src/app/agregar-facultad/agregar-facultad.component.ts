import { Component,inject } from '@angular/core';
import { FormControl,FormGroup,ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FacultadService } from '../facultad.service';
import { UbicacionFacultad } from '../ubicacion-facultad';
@Component({
  selector: 'app-agregar-facultad',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  template: `
   <section class="listing-apply">
      <h2 class="section-heading">AGREGAR NUEVA FACULTAD</h2>
      <form [formGroup]="FormFacu" >
        <label for="NombreFacultad">Nombre Facultad </label>
        <input id="NombreFacultad" type="text" formControlName="NombreFacultad">

        <label for="Ciudad">Ciudad</label>
        <input id="Ciudad" type="text" formControlName="Ciudad">

        <label for="Campus">Campus</label>
        <input id="Campus" type="text" formControlName="Campus">
        <label for="Foto">Url Foto</label>
        <input id="Foto" type="text" formControlName="Foto">

        <label for="Carreras">Carreras</label>
        <input id="Carreras" type="text" formControlName="Carreras">




        <button type="submit" class="primary">Insertar</button>
      </form>
  `,
  styleUrl: './agregar-facultad.component.css'
})
export class AgregarFacultadComponent {
  FormFacu= new FormGroup({
    NombreFacultad: new FormControl(''),
    Ciudad: new FormControl(''),
    Campus: new FormControl(''),

    Foto: new FormControl(''),

    Carreras: new FormControl(''),

  });



}

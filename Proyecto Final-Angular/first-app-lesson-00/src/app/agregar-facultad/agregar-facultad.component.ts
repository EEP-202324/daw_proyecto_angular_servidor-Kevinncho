import { Component } from '@angular/core';
import { FormControl,FormGroup,ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FacultadService } from '../facultad.service';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { Validators } from '@angular/forms';
@Component({
  selector: 'app-agregar-facultad',
  templateUrl: './agregar-facultad.component.html',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  template: `
    <img class="listing-photo" src="https://clipground.com/images/beaver-images-clip-art-4.jpg">
   <section class="listing-apply">
      <h1 class="section-heading">AGREGAR NUEVA FACULTAD</h1>
      <form [formGroup]="FormFacu" >
        <label for="nombre">Nombre Facultad </label>
        <input id="nombre" type="text" formControlName="nombre">

        <label for="ciudad">Ciudad</label>
        <input id="ciudad" type="text" formControlName="ciudad">

        <label for="campus">Campus</label>
        <input id="campus" type="text" formControlName="campus">
        <label for="photo">Url Foto</label>
        <input id="photo" type="text" formControlName="photo">

        <label for="carreras">Carreras</label>
        <input id="carreras" type="text" formControlName="carreras">

        <label for="Wifi">Wifi</label>
        <input id="Wifi" type="checkbox" formControlName="Wifi">



        <button type="submit" class="primary">Insertar</button>
      </form>
  `,
  styleUrl: './agregar-facultad.component.css'
})
export class AgregarFacultadComponent {
  FormFacu= new FormGroup({
    //id: new FormControl('',[Validators.required, Validators.pattern('^[0-9]+$')]),

    nombre: new FormControl(''),
    ciudad: new FormControl(''),
    campus: new FormControl(''),

    photo: new FormControl(''),

    carreras: new FormControl('', [Validators.required, Validators.pattern('^[0-9]+$')]),

    Wifi: new FormControl('', [Validators.required, Validators.pattern('^(true|false)$')])

  });

  constructor(private facultadService: FacultadService){}

  enviar(){
    const facultadDatos= this.FormFacu.value;
    this.facultadService.agregarFacultad(facultadDatos).subscribe(
      nuevaFacultad =>{
        console.log('Nueva facultad agregada', nuevaFacultad);
        alert('Se ha agregado la facultad exitosamente');
      },
      error=>{
        console.log('Error al agregar la facultad:', error)
        alert('Ha ocurrido un error al agregar la facultad')
      }
  );
  }




}

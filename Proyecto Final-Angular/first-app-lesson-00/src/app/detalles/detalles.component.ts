import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FacultadService } from '../facultad.service';
import { UbicacionFacultad } from '../ubicacion-facultad';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

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
    <h1 class="section-heading">MODIFICAR FACULTAD</h1>
    </section>
      <section class="listing-apply">
      <form [formGroup]="aplicarForm" (submit)="enviar()">
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

       



        <button type="submit" class="primary">Actualizar</button>
      </form>
    </section>
  </article>
`,
  styleUrl: './detalles.component.css'

})
export class DetallesComponent implements OnInit{

  ubicacionFacultad: UbicacionFacultad | undefined;
  aplicarForm: FormGroup;
  constructor(
  private route: ActivatedRoute,
  private facultadService: FacultadService){

  this.aplicarForm = new FormGroup({
    nombre: new FormControl('',Validators.required),
    ciudad: new FormControl('',Validators.required),
    campus: new FormControl('',Validators.required),

    photo: new FormControl('',Validators.required),

    carreras: new FormControl('', [Validators.required, Validators.pattern('^[0-9]+$')]),


  });
}
  ngOnInit(): void {
    const facultadId= Number(this.route.snapshot.params['id']);
    this.facultadService.getUbicacionFacultad(facultadId).subscribe({
      next: facultad =>{
        this.ubicacionFacultad=facultad;
        this.aplicarForm.patchValue({
          id: facultad.id,
          nombre: facultad.nombre,
          ciudad: facultad.ciudad,
          campus: facultad.campus,
          photo: facultad.photo,
          carreras: facultad.carreras,

        });
      },
      error: error =>{
        console.log('Error al modificar la facultad ', error)
      }
  });
  }

  enviar(): void{
    if(this.aplicarForm.valid){
      const facultadDatos=this.aplicarForm.value;
      facultadDatos.id=this.ubicacionFacultad?.id
      this.facultadService.modificarFacultad(facultadDatos).subscribe({
        next: facultadActualizada =>{
            alert('Facultad actualizada con exito');
        },
        error: error =>{
          alert('Ha ocurrido un error');
          console.log('Ha ocurrido un error',error)
        }
      })
    }
  }


    presentarSolicitud(){
      this.facultadService.presentarSolicitud(
        this.aplicarForm.value.Nombre ?? '',
        this.aplicarForm.value.Apellido ?? '',
        this.aplicarForm.value.email ?? ''
      );
    }
}

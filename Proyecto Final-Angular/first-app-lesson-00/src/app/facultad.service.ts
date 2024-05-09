import { Injectable } from '@angular/core';
import { UbicacionFacultad } from './ubicacion-facultad';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacultadService {
   //url = 'http://localhost:3000/locations';
   urlFacultad = 'http://localhost:8080/facultades';

   constructor(private http: HttpClient) { }


   //Esto es un request que nos sirve para conectar con servidor
   getUbicacionFacultad(id: number){
    return this.http.get<UbicacionFacultad>(`${this.urlFacultad}/${id}`);
   }
   getFacultades(){
    return this.http.get<UbicacionFacultad[]>(this.urlFacultad);
   }
/*
  async getAllUbicacionFacultades(): Promise<UbicacionFacultad[]>{
    const data= await fetch(this.url);
    return await data.json()?? [];
  }
  async getUbicacionFacultadById(id: number):
    Promise <UbicacionFacultad | undefined> {
      const data = await fetch(`${this.url}/${id}`);
      if (!data.ok) {
        throw new Error(`HTTP error! status: ${data.status}`);
      }

      return await data.json() ?? {};
    }*/

    presentarSolicitud(Nombre: string, Apellido: string, email: string){
      alert(`Solicitud de facultad recibida: Nombre: ${Nombre},
      Apellido: ${Apellido}, email: ${email}`);
    }

    agregarFacultad(facultadDatos: any): Observable<UbicacionFacultad>{
      return this.http.post<UbicacionFacultad>(this.urlFacultad, facultadDatos);
    }

    modificarFacultad(facultad: UbicacionFacultad): Observable<FacultadService>{
      const urlFacultad= `${this.urlFacultad}/${facultad.id}`;
      return this.http.put<FacultadService>(urlFacultad,facultad);
    }
}





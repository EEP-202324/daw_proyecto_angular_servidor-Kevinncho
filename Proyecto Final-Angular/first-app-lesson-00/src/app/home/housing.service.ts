import { Injectable } from '@angular/core';
import { HousingLocation } from '../../housinglocation';
import { HttpClient } from '@angular/common/http';
import { Peticion } from '../peticion';

@Injectable({
  providedIn: 'root'
})
export class HousingService {

  url='http://localhost:3000/locations';
  urlPeticiones='http://localhost:8080/peticiones';

  housingLocationList: HousingLocation[] = [
    {
      id: 0,
      name: 'Acme Fresh Start Housing',
      city: 'Chicago',
      campus: 'NOSE',
      photo: `${this.url}/bernard-hermant-CLKGGwIBTaY-unsplash.jpg`,
      availableUnits: 4,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 1,
      name: 'A113 Transitional Housing',
      city: 'Santa Monica',
      campus: 'NOSE',
      photo: `${this.url}/brandon-griggs-wR11KBaB86U-unsplash.jpg`,
      availableUnits: 0,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 2,
      name: 'Warm Beds Housing Support',
      city: 'Juneau',
      campus: 'NOSE',
      photo: `${this.url}/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg`,
      availableUnits: 1,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 3,
      name: 'Homesteady Housing',
      city: 'Chicago',
      campus: 'NOSE',
      photo: `${this.url}/ian-macdonald-W8z6aiwfi1E-unsplash.jpg`,
      availableUnits: 1,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 4,
      name: 'Happy Homes Group',
      city: 'Gary',
      campus: 'NOSE',
      photo: `${this.url}/krzysztof-hepner-978RAXoXnH4-unsplash.jpg`,
      availableUnits: 1,
      wifi: true,
      modalidad: 'Presencial'
    },
    {
      id: 5,
      name: 'Hopeful Apartment Group',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.url}/r-architecture-JvQ0Q5IkeMM-unsplash.jpg`,
      availableUnits: 2,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 6,
      name: 'Seriously Safe Towns',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.url}/phil-hearing-IYfp2Ixe9nM-unsplash.jpg`,
      availableUnits: 5,
      wifi: true,
      modalidad: 'presencial',
    },
    {
      id: 7,
      name: 'Hopeful Housing Solutions',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.url}/r-architecture-GGupkreKwxA-unsplash.jpg`,
      availableUnits: 2,
      wifi: true,
      modalidad:'Presencial',
    },
    {
      id: 8,
      name: 'Seriously Safe Towns',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.url}/saru-robert-9rP3mxf8qWI-unsplash.jpg`,
      availableUnits: 10,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 9,
      name: 'Capital Safe Towns',
      city: 'Portland',
      campus: 'NOSE',
      photo: `${this.url}/webaliser-_TPTXZd9mOo-unsplash.jpg`,
      availableUnits: 6,
      wifi: true,
      modalidad: "precensial",
    }
  ];



  getAllHousingLocations(): HousingLocation[] {
    return this.housingLocationList;
  }

  getHousingLocationById(id: number): HousingLocation | undefined {
    return this.housingLocationList.find(housingLocation => housingLocation.id === id);
  }
  submitApplication(nombre: string, apellido: string, email:string){
    alert(`Peticion de : ${nombre} ${apellido} (${email})`);
  }




}

import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HousingLocationComponent } from '../housing-location/housing-location.component';
import { HousingLocation } from '../../housinglocation';
import { HousingService } from './housing.service';

// import { of } from 'rxjs';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    HousingLocationComponent
  ],
  template: `
  <section>
    <form>
      <input type="text" placeholder="Filter by city">
      <button class="primary" type="button">Search</button>
    </form>
  </section>
  <section class="results">
  <app-housing-location
  *ngFor="let housingLocation of housingLocationList"
  [housingLocation]="housingLocation">
</app-housing-location>  </section>
`,
  styleUrls: ['./home.component.css'],
})

export class HomeComponent {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';

  housingLocationList: HousingLocation[] = [
    {
      id: 0,
      name: 'Acme Fresh Start Housing',
      city: 'Chicago',
      campus: 'NOSE',
      photo: `${this.baseUrl}/bernard-hermant-CLKGGwIBTaY-unsplash.jpg`,
      availableUnits: 4,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 1,
      name: 'A113 Transitional Housing',
      city: 'Santa Monica',
      campus: 'NOSE',
      photo: `${this.baseUrl}/brandon-griggs-wR11KBaB86U-unsplash.jpg`,
      availableUnits: 0,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 2,
      name: 'Warm Beds Housing Support',
      city: 'Juneau',
      campus: 'NOSE',
      photo: `${this.baseUrl}/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg`,
      availableUnits: 1,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 3,
      name: 'Homesteady Housing',
      city: 'Chicago',
      campus: 'NOSE',
      photo: `${this.baseUrl}/ian-macdonald-W8z6aiwfi1E-unsplash.jpg`,
      availableUnits: 1,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 4,
      name: 'Happy Homes Group',
      city: 'Gary',
      campus: 'NOSE',
      photo: `${this.baseUrl}/krzysztof-hepner-978RAXoXnH4-unsplash.jpg`,
      availableUnits: 1,
      wifi: true,
      modalidad: 'Presencial'
    },
    {
      id: 5,
      name: 'Hopeful Apartment Group',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.baseUrl}/r-architecture-JvQ0Q5IkeMM-unsplash.jpg`,
      availableUnits: 2,
      wifi: true,
      modalidad: 'Presencial',
    },
    {
      id: 6,
      name: 'Seriously Safe Towns',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.baseUrl}/phil-hearing-IYfp2Ixe9nM-unsplash.jpg`,
      availableUnits: 5,
      wifi: true,
      modalidad: 'presencial',
    },
    {
      id: 7,
      name: 'Hopeful Housing Solutions',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.baseUrl}/r-architecture-GGupkreKwxA-unsplash.jpg`,
      availableUnits: 2,
      wifi: true,
      modalidad:'Presencial',
    },
    {
      id: 8,
      name: 'Seriously Safe Towns',
      city: 'Oakland',
      campus: 'NOSE',
      photo: `${this.baseUrl}/saru-robert-9rP3mxf8qWI-unsplash.jpg`,
      availableUnits: 10,
      wifi: false,
      modalidad:'Presencial',
    },
    {
      id: 9,
      name: 'Capital Safe Towns',
      city: 'Portland',
      campus: 'NOSE',
      photo: `${this.baseUrl}/webaliser-_TPTXZd9mOo-unsplash.jpg`,
      availableUnits: 6,
      wifi: true,
      modalidad: "precensial",
    }
  ];
}

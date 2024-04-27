import { Component } from '@angular/core';
import { FacultadComponent } from './facultad/facultad.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FacultadComponent,
    RouterModule,
  ],
  template: `
  <main>
    <a [routerLink]="['/']">
      <header class="brand-name">
        <img class="brand-logo" src="/assets/logoU.jpg" alt="logo" aria-hidden="true"><h1 class="titulo_u">Universidad Tecnológica del Norte</h1>
      </header>
    </a>
    <section class="content">
    <router-outlet></router-outlet>
    </section>
  </main>
`,
styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'homes';
}

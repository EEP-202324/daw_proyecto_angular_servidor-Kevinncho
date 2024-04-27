import { ApplicationConfig, inject } from "@angular/core";
import { HttpClient,HttpClientModule } from "@angular/common/http";
import { importProvidersFrom } from "@angular/core";
import { provideProtractorTestingSupport } from "@angular/platform-browser";
import { provideRouter } from "@angular/router";
import routeConfig from "./routes";

export const appConfig: ApplicationConfig = {
  providers: [
    provideProtractorTestingSupport(),
      provideRouter(routeConfig),
    importProvidersFrom(HttpClientModule),
  ]
};

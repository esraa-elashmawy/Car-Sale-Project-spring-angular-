import { Component } from '@angular/core';
import { TranslateFakeLoader, TranslateLoader, TranslateModule, TranslateService } from '@ngx-translate/core';
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { HttpClient, HttpClientModule } from "@angular/common/http";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],

   providers:[TranslateService],

})
export class HomePageComponent {
  constructor(private translateService: TranslateService) {}
  changeLangage(lang: string) {
 // this.translateService.setDefaultLang(lang);
  this.translateService.use(lang);
}
}

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}

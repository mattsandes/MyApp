import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MainComponentComponent } from './components/main-component/main-component.component';
import { ContentComponent } from './components/content/content.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MainComponentComponent,
    ContentComponent],
  template:
    `
      <router-outlet />
      <app-content />
      <app-main-component />
    `
})
export class AppComponent {
  title = 'app-com-angular';
}

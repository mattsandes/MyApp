import { Component } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { MatFormField, MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { MatList, MatListModule } from '@angular/material/list';
import { MatSelect, MatSelectModule } from '@angular/material/select';

interface Operations {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-services',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatLabel,
    MatInputModule,
    MatSelectModule,
    MatListModule,
    MatButton
  ],
  templateUrl: './services.component.html',
  styleUrl: './services.component.css'
})
export class ServicesComponent {
  operations: Operations[] = [
    {value: "soma-0", viewValue: "Soma"},
    {value: "subtração-1", viewValue: "Subtração"},
    {value: "divisao-2", viewValue: "Divisão"},
    {value: "multiplicacao", viewValue: "Multiplicação"}
  ]
}

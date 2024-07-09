import { Component } from '@angular/core';
import { ApiServiceService } from '../../services/api-service.service';
import { CommonModule } from '@angular/common';
import { MatTable, MatTableModule } from '@angular/material/table';

export interface People {
  id: number,
  name: string,
  age: number
}

@Component({
  selector: 'app-data',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule
  ],
  templateUrl: './data.component.html',
  styleUrl: './data.component.css'
})
export class DataComponent {

  users:any[] = [];

  constructor(private service: ApiServiceService){}

  ngOnInit(): void {
    this.service.findAll().subscribe(
      response => {
        this.users = response;
      }
    )
  }
}

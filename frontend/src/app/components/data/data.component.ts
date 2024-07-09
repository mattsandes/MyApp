import { Component } from '@angular/core';
import { ApiServiceService } from '../../services/api-service.service';
import { CommonModule } from '@angular/common';
import { MatTable, MatTableDataSource, MatTableModule } from '@angular/material/table';

export interface Post {
  id: number,
  title: string,
  body: string
}

@Component({
  selector: 'app-data',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
  ],
  templateUrl: './data.component.html',
  styleUrl: './data.component.css'
})
export class DataComponent {

  displayedColumns: string[] = ['id', 'title', 'body'];
  dataSource = new MatTableDataSource<Post>();

  constructor(private service: ApiServiceService){}

  ngOnInit(): void {
    this.service.findAll().subscribe(
      (response:Post[]) => {
        this.dataSource.data = response;
      }
    )
  }
}

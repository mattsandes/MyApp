import { Component, OnInit, ViewChild, viewChild } from '@angular/core';
import { MyServiceService } from '../../services/my-service.service';
import { CommonModule, NgIf } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table'
import { MatPaginator } from '@angular/material/paginator';
import { MatCardModule } from '@angular/material/card'
import { MatButtonModule } from '@angular/material/button';

export interface People {
  id: number,
  name: string,
  address: string,
  gender: string
}

@Component({
  selector: 'app-main-component',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatCardModule,
    MatButtonModule
  ],
  templateUrl: './main-component.component.html',
  styleUrl: './main-component.component.css'
})
export class MainComponentComponent implements OnInit{

  people: any[] = [];
  displayedColumns: string[] = ['id', 'name', 'address', 'gender'];
  dataSource: MatTableDataSource<People> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator?: MatPaginator;

  constructor(private myService: MyServiceService) { }
  
  ngOnInit(): void {
    this.myService.getDadosDaApi().subscribe((data) => {
      this.dataSource = data;
      if (this.paginator) {
        this.dataSource.paginator = this.paginator;
      }
    });
  }

}

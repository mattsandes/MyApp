import { Component, OnInit, ViewChild, viewChild } from '@angular/core';
import { MyServiceService } from '../../services/my-service.service';
import { CommonModule, NgIf } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table'
import { MatPaginator } from '@angular/material/paginator';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-main-component',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule
  ],
  templateUrl: './main-component.component.html',
  styleUrl: './main-component.component.css'
})
export class MainComponentComponent implements OnInit{

  people: any[] = [];
  displayedColumns: string[] = ['id', 'name', 'address', 'gender'];
  dataSource: MatTableDataSource<any> = new MatTableDataSource();

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

import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../../services/my-service.service';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-main-component',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule],
  templateUrl: './main-component.component.html',
  styleUrl: './main-component.component.css'
})
export class MainComponentComponent implements OnInit{

  people: any[] = [];

  constructor(private myService: MyServiceService) { }
  
  ngOnInit(): void {
    this.myService.getDadosDaApi().subscribe((data) => {
      this.people = data;
    })
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

  private url = 'http://localhost:8080/api/myApi';

  constructor(private http: HttpClient) { }

  getDadosDaApi(): Observable<any> {
    return this.http.get(this.url);
  }
}
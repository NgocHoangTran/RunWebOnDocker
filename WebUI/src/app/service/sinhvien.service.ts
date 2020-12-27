import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiResponse } from '../model/api.response';
import {Observable} from "rxjs/index";
import { SinhVien } from '../model/sinhvien.model';
@Injectable({
  providedIn: 'root'
})
export class SinhVienService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'http://localhost:8080/api/ListSinhVien/';

  

  getSinhVien() : Observable<SinhVien[]> {
    return this.http.get<SinhVien[]>(this.baseUrl);
  }

  getSinhVienBymaSV(id: number): Observable<any> {
    return this.http.get(this.baseUrl + id);
  }

  createSinhVien(sinhvien: SinhVien): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, sinhvien);
  }

  updateSinhVien(maSV: number, sinhvien: SinhVien): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + sinhvien.maSV, sinhvien);
  }

  deleteSinhVien(maSV: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + maSV);
  }
}

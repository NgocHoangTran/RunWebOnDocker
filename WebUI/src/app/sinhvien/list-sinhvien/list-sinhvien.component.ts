import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ApiResponse } from 'src/app/model/api.response';
import { SinhVien } from 'src/app/model/sinhvien.model';
import { SinhVienService } from 'src/app/service/sinhvien.service';

@Component({
  selector: 'app-list-sinhvien',
  templateUrl: './list-sinhvien.component.html',
  styleUrls: ['./list-sinhvien.component.css']
})
export class ListSinhvienComponent implements OnInit {

  danhsachsinhvien !: Observable<SinhVien[]>;
  constructor(private sinhvienService:SinhVienService, private router:Router) { }

  ngOnInit(): void {
    this.sinhvienService.getSinhVien();
  }
  reloadData() {
    this.danhsachsinhvien= this.sinhvienService.getSinhVien();
  }
  deleteSinhVien(maSV: number) {
    this.sinhvienService.deleteSinhVien(maSV)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  updateSinhVien(maSV:number)
  {
    this.router.navigate(['update',maSV])
  }

}

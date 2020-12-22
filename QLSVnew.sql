Create database qlsinhvien
use qlsinhvien
CREATE TABLE KHOA (
ma_Khoa integer PRIMARY KEY,
ten_Khoa nvarchar(50)
);
CREATE TABLE LOP (
ma_Lop integer PRIMARY KEY,
ten_Lop nvarchar(50),
ma_Khoa integer not null,
FOREIGN KEY (ma_Khoa) REFERENCES KHOA(ma_Khoa)
);
CREATE TABLE SINHVIEN (
ma_SV integer Primary key,
ten_SV nvarchar(50) not null,
ngay_Sinh date not null,
ma_Lop integer not null,
ma_Khoa integer not null,
FOREIGN KEY (ma_Khoa) REFERENCES KHOA(ma_Khoa),
FOREIGN KEY (ma_Lop) REFERENCES LOP(ma_Lop)
)
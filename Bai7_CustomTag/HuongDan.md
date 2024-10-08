```select s.tenSua, s.hangSua.tenHangSua, s.loaiSua.tenLoai, s.trongLuong, s.donGia from Sua s
where s.hangSua.maHangSua = 'DL' and s.loaiSua.maLoaiSua = 'SB' and s.tenSua like '%gái%' order by s.donGia asc
```

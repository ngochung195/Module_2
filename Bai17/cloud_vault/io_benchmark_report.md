=== BAT DAU MO PHONG VA KIEM THU HE THONG CLOUDVAULT ===
1. Dang sinh file nhi phan dummy 50MB... Xong (Mat 59 ms).
---------------------------------------------------------
2. Chay ham copyCorrupted (Character Stream)...
-> Hoan thanh copy loi.
---------------------------------------------------------
3. Chay ham copySlow (Byte Stream - Khong bo dem)...
   (Luu y: File 50MB copy tung byte co the mat tu 20 - 40 giay...)
-> Hoan thanh! Thoi gian copySlow: 216675 ms (~216 giay)
---------------------------------------------------------
4. Chay ham copyOptimized (Byte Stream + Bo dem 8KB)...
-> Hoan thanh! Thoi gian copyOptimized: 104 ms
---------------------------------------------------------
=== KET LUAN KHAO SAT DUNG LUONG VA TOC DO ===
A. BANG SO SANH DUNG LUONG FILE:
 - File goc ban dau        : 52428800 bytes
 - File qua copySlow       : 52428800 bytes -> [AN TOAN]
 - File qua copyOptimized  : 52428800 bytes -> [AN TOAN]
 - File qua copyCorrupted  : 52428800 bytes

>> Nhan xet ve copyCorrupted:

B. TI LE TOI UU TOC DO:
   -> copyOptimized nhanh gap 2083,41 lan so voi copySlow!
Lỗi age < 18 không xứng đáng dùng Checked Exception vì 3 lý do sau:

- Là lỗi thuộc về Logic/Dữ liệu: Đây là lỗi do người dùng nhập sai hoặc lập trình viên thiếu validation trước khi gọi hàm. Nó hoàn toàn kiểm soát được bằng code, không phải lỗi khách quan bất khả kháng do môi trường (như mất mạng, thiếu file).

- Vi phạm nguyên tắc Fail-Fast: Khi dữ liệu sai, hệ thống cần văng lỗi ngay lập tức (Unchecked Exception) để lập trình viên biết và sửa code, thay vì tìm cách che giấu.

- Gây rác code (Boilerplate code): Ép Caller phải dùng try-catch cho một lỗi logic sẽ làm code trở nên cồng kềnh, rối rắm một cách vô ích.
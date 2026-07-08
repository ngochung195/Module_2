Thuật toán tránh Deadlock được áp dụng ở đây là Lock Ordering (Sắp xếp thứ tự khóa).

Nguyên nhân chính gây ra Deadlock là Circular Wait (Chờ đợi vòng tròn), khi Tiến trình 1 giữ Khóa A chờ Khóa B, còn Tiến trình 2 giữ Khóa B lại chờ Khóa A.

Thuật toán này triệt tiêu hoàn toàn vòng lặp đó bằng cách bắt buộc mọi luồng phải chiếm giữ các khóa theo một thứ tự cố định và duy nhất được quy định trước.

Trong bài toán, thứ tự được quyết định bằng cách so sánh tên chuỗi theo bảng chữ cái Alphabet (Alice đứng trước Bob). Vì vậy, dù luồng nào chạy trước, hệ thống cũng bắt buộc phải khóa Alice xong rồi mới được khóa Bob. Khi Luồng 1 đang giữ khóa Alice, Luồng 2 sẽ bị chặn ngay từ bước đầu tiên và phải xếp hàng đợi, không thể xảy ra tình trạng tranh chấp chéo gây treo hệ thống.

| STT | Code Smell    | Vị trí           | Mô tả 
| 1   | Long Method   | processOrder()   | Phương thức quá dài, thực hiện nhiều nhiệm vụ    khác nhau trong cùng một hàm. 

| 2   | Deep Nesting  | if lồng nhau trong processOrder() | Nhiều tầng điều kiện lồng nhau làm luồng xử lý khó đọc, khó bảo trì. 

| 3   | Magic Numbers | 1, 2, 0.15, 0.10 | Các giá trị số xuất hiện trực tiếp trong mã nguồn mà không có tên mô tả ý nghĩa. 

| 4   | Poor Naming   | cType, amt, d    | Tên biến viết tắt, không thể hiện rõ mục đích và chức năng sử dụng. |
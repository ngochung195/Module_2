1. Lúc bị lỗi:
STACK (Tên biến)             HEAP (Ô nhớ thực tế)

[todayRates]   ───┐
                  ├───> Trỏ chung vào [0xABC] (Sửa 1 biến, biến kia đổi theo)
[backupRates]  ───┘

[historyRates] ───X (Null - Không trỏ vào đâu ──> Sập hệ thống)

2. Lúc đã sửa:
STACK (Tên biến)             HEAP (Ô nhớ thực tế)

[todayRates]   ─────────> Trỏ vào [0xABC] (Mảng gốc được giữ nguyên)
[backupRates]  ─────────> Trỏ vào [0xXYZ] (Mảng mới độc lập)

[historyRates] ─────────> Trỏ vào [0x777] (Đã có địa chỉ - Hết lỗi sập)
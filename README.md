
BÀI TẬP SELENIUM JAVA ANHTESTER 2023
BÀI TẬP 1 CHẠY TRÊN PROJECT MAVEN
(Bắt đầu từ bài học số 9 trở về sau)

- https://cms.anhtester.com/login

- Add Category
       + Add hình sẵn vài tấm bằng tay trước khi chạy auto
       + Chú ý phần chọn hình: click Browse -> search tên hình add bằng tay -> click item hình -> Click Add button
- Sau khi add category xong trở về menu Category (trang list)
- Search category name vừa add
- Get cái Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không


BÀI TẬP 2 VỀ GHI CHÚ TRONG TESTNG (Annotation)

- Tách code cũ ở BT Add Category ra theo các ghi chú (annotation):
(không dùng hàm main nữa)

+ Tách đoạn setup Driver ra riêng không để chung trong test case
+ Tách Login sẽ chạy trước mỗi test case
+ Optimize code chạy cho ổn định hơn (sleep, xpath)
+ Tập chạy code trên file suite XML



BÀI TẬP 3 VỀ ASSERT

THÊM ASSERT VÀO ADD CATEGORY ĐANG LÀM Ở BT2

- Kiểm tra Text của tất cả dialog
- Kiểm tra Text trên mỗi trang
- Kiểm tra giá trị item vừa add với Assert chứ ko dùng if else như BT1 nữa



BÀI TẬP 3 MỞ RỘNG

Làm thêm case Edit và Delete category

Gợi ý:
        + Edit thì gọi lại phần Add. Xong thực hiện tiếp tục lệnh nhấn button Edit...
        + Edit thì search lại check giá trị mới sau khi edit

        + Delete thì sau khi xoá xong cần check lại là element đó không tồn tại (chỉ trong buổi học)



BÀI TẬP 4 VẬN DỤNG ACTIONS ROBOT CLASS

- Add Product
 + Select giá trị Category ở BT3
 + Chọn Colors >= 2 màu (dùng Ctrl + A và Delete để hỗ trợ chọn màu và xoá màu)
 + Verify Text của Colors trên (dùng Assert) (chỉ cần check số lượng color hiển thị thôi)
 + Dùng biến toàn cục để lưu giá trị Data có thay đổi khi cần để dễ chỉnh sửa khi chạy lại nhiều lần




BÀI TẬP 4 PHẦN MỞ RỘNG

- Tạo luồng chạy liên tục từ Add Category tới Add Product
     + Sử dụng lại giá trị của Category vừa add cho Product (không điền giá trị category bằng tay)
 

BÀI TẬP 5 VỀ POM (Page Object Model)

- Thiết kế các hàm xử lý trong từng trang: enterEmail, enterPassword,..., addCategory, addProduct,...

 
 	
BÀI TẬP 6 VỀ POM (Page Object Model)

- Tạo POM cho trang Product (Page và Test case và liên kết trang)
- Thực hiện chức năng add và edit
- Tạo suite XML để chạy multi class/method

"BÀI TẬP 7 VỀ POM + COMMON LIBRARY

- Tạo class chung bên ""main"" package
- Viết ít nhất 3 hàm chung: waitForPageLoaded, clickElement, setText
- Có Explicit wait cho các hàm chung để ổn định code
- Bỏ sleep và ImplicitWait
=> Thay thế toàn bộ hàm chung cho bài tập POM ở BT6

Note: khi làm được cái này thì Cấu trúc code theo POM và có được hàm xử lý chung từ class chung -> Bước đầu để build Framework về sau"

"BÀI TẬP 8 VỀ POM + COMMON LIBRARY

- Bổ sung thêm hàm chung
- Chỉnh sửa lại file SetupBrowser để chạy multi browser"

"BÀI TẬP 9 HANDLE WEB TABLE
(Vận dụng Handle table)

- Viết thêm hàm search data table cho Product page và Category page"

"BÀI TẬP 10 ĐỌC GHI EXCEL FILE
(Vận dụng đọc ghi file Excel với Apache POI)
(Từ bài học 26)

- Thay thế toàn bộ Data test của các trang: Login, Brand, Category, Product
Thành data đọc từ Excel File"


"BÀI TẬP 11 XỬ LÝ FILE PROPERTIES
(Từ bài học 27)

- Setup class PropertieHelper cho hệ thống eCommerce

- Gọi hàm getValue để lấy giá trị configs từ các file properties để truyền vào các chổ config trong các class: SetupBrowser, Login, Đường dẫn file excel từ các class đã dùng để ổn định giá trị setup về sau."
- Tạo liên kết trang: Login => Dashboard, Dashboard => Category, Dashboard => Product
- Tạo suite xml để gọi test case chạy chứ không chạy trực tiếp trong class

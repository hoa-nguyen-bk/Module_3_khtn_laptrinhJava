## Hướng dẫn phần Quảng cáo theo MVC
### Model phải có:
1. Java Bean: QuangCao là tạo cái class:
	- 4 yêu cầu của 1 java bean: 
		+ cần lấy hết mấy thuộc tính
		+ khai báo dữ liệu
		+ phương thức getter, setter
		+ hàm khởi tạo ko tham số
2. Business Logic: 
	- CSDL: như thường lệ
	- QuangCaoBL -> docTatCa() -> List<QuangCao>
### View:
3. Sửa lại trang views/quang-cao.jsp cho dữ liệu động
### Controller:
4. Servlet: QuangCaoServlet: 
	+ trong này ta sẽ chuẩn bị data, làm sao lấy được List<QuangCao>
	+ đặt lên thuộc tính ứng dụng web: tức là request.setAttribute("dsqc",dsqc)
	+ trả về trang views/quang-cao.jsp để hiển thị
		request.getRequestDispatcher("views/quang-cao.jsp).include(request,response); 
		chỗ này hơm rõ, coi lại record nghen: forward khi nó là 1 thành phần của trang này, include là chèn trang đó vào đây
	+ xong nếu gọi trực tiếp trên trang trang-chu thì nó ko có gì cả, vì servlet nó lấy data từ QuangCaoServlet
	+ trong trang-chu.jsp sửa views/quang-cao.jsp thành QuangCaoServlet
		. cách xử lý là mở Window/preferences/web/JSP files/Validation 2 casi warning 
			Included fragment file not found: Error -> Warning
			Included fragment file not specified: Error -> Warning

## Hướng dẫn phần Thương hiệu theo MVC
### Model phải có:
1. Java Bean: ThuongHieu là tạo cái class
2. Business Logic: 
	- CSDL: như thường lệ
	- ThuongHieuBL -> docTatCa() -> List<ThuongHieu>
### View:
3. Sửa lại trang views/thuong-hieu.jsp cho dữ liệu động
### Controller:
4. Servlet: ThuongHieuServlet: 
	+ trong này ta sẽ chuẩn bị data, làm sao lấy được List<ThuongHieu>
	+ đặt lên thuộc tính ứng dụng web: tức là request.setAttribute("dsqc",dsqc)
	+ trả về trang views/thuong-hieu.jsp để hiển thị
		request.getRequestDispatcher("views/thuong-hieu.jsp).include(request,response); 
	+ xong nếu gọi trực tiếp trên trang trang-chu thì nó ko có gì cả, vì servlet nó lấy data từ ThuongHieuServlet
	+ trong trang-chu.jsp sửa views/thuong-hieu.jsp thành ThuongHieuServlet

## Hướng dẫn phần Lấy 10 sản phẩm mới nhât theo MVC
### Model phải có:
1. Java Bean: SanPham là tạo cái class
2. Business Logic: 
	- CSDL: như thường lệ
	- SanPhamBL -> docSanPhamMoi(int top) -> List<SanPham>
### View:
3. Sửa lại trang views/san-pham-moi.jsp cho dữ liệu động
### Controller:
4. Servlet: SanPhamMoiServlet: 
	+ chuẩn bị data, làm sao lấy được List<SanPham> cho 10 sản phẩm mới nhất
	+ đặt lên thuộc tính ứng dụng web: tức là request.setAttribute("dssp",dssp)
	+ trả về trang views/san-pham-moi.jsp để hiển thị
		request.getRequestDispatcher("views/san-pham-moi.jsp).include(request,response); 
	+ xong nếu gọi trực tiếp trên trang trang-chu thì nó ko có gì cả, vì servlet nó lấy data từ SanPhamMoiServlet
	+ trong trang-chu.jsp sửa views/san-pham-moi.jsp thành SanPhamMoiServlet

Note: nếu mà có đổi tên folder thì nên xóa máy chủ PhuongPerfumeM3 đi và chạy lại f11

btvn - làm cho buổi sau:
----
- làm thêm giỏ hàng
- làm hiển thị tiền

đồ án cuối khóa:
---
- cái này giống đề thi
- người ta cho cái trang sẵn, người ta sửa theo dữ liệu động of mình
- phải tự làm sql


# Buổi  2
Phần đăng nhập theo mvc:

### Model:
1. Java bean: NguoiDung
2. Business Logic: NguoiDungBL -> timNguoiDung(String,String) -> NguoiDung
### View: 
3. Sửa lại phần form đăng nhập ở cuối trang
### Controller
4. Tạo đăng nhập DangNhapServlet
	- nhập email và password
	- tìm người dùng: phải tìm ra đối tượng người dùng
		- `NguoiDung nd = NguoiDungBL.timNguoiDung(email,pass);`
		- chỗ này kiểm thử
	- đặt người dùng lên session:
		- `HttpSession session = request.getSession();`
		- `session.setAttribute("nd",nd);`
	- trả về trang chủ
	- hiển thị họ tên ở đầu trang nếu thành công, còn nếu thất bại thì thôi:
		- `${sessionScope.nd.hoTen}`
### Đăng xuất: DangXuatServlet
```
	HttpSession session = request.session();
	if(session!= null){
		session.invalid();
	}
	//trả về trang chủ
```
- session.invalidate làm cho nó mất hiệu lực
- session.removeAttribute: xóa thuộc tính thôi chứ ko muốn xóa biến session
- sau đó bấm zô PhuongPerfumeM3 -> Run as Server -> nó sẽ hiển thị ra trang chủ

### Thêm vào giỏ hàng

Người ta tạo rất nhiều thông tin để lưu trong giỏ hàng, nên thầy sẽ chỉ cho mình lưu ít thôi, thầy sẽ cho mình lưu ít ít thông tin thôi, khi hiển thị lên đầy đủ họ lưu hình ảnh tên, số lượng, giá tổng tiền.

Còn thầy lưu id, số lượng mua thôi, vì từ id ta lấy được tên, hình ảnh, giá khuyến mãi -> để làm thế ta cần cái hàm truyền vào id trả về sản phẩm, nên trong SanPhamBL ta sẽ bổ sung thêm hàm

bây giờ thêm cái docTheoId

BTVN: cố gắng phát triển típ

### hiển thị giỏ hàng


# Buổi 3:  Bài 5 Filter

### làm típ cái bài Perfume + với đăng nhập  
Bước 1: tạo bộ lọc ở Xác Thực Filter

Bước 2: khai báo bộ lọc ở `src\main\webapp\WEB-INF\web.xml`

Kiểm tra đã thành công, phải đăng nhập mới vô được giỏ hàng

## Tiếp tục với BTVN MVC bài 4.1 và 4.2
Publisher MVC
- Model:
	1. Lấy cái file `minishop.sql` và file  hibernate
	2. Business logic: PublisherBL
		```
		docTatCa() -> List<Publisher>
		docTheoId(int id) -> Publisher
		add(Publisher p) -> p
		edit(Publisher p) -> p
		```
B2: tạo view 
Hiện tại mình đang làm MVC của Java not MVC của Spring, nhớ nhen
BTVN: Bài tập bài4 mvc :  4.3 Home
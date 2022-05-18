# GradingService
Project này phục vụ cho môn học Phát triển phần mềm hướng dịch vụ, giúp xấy dựng 1 Task vervice cho giáo viên có thể chấm điểm bài tập cho sinh viên 
và trả lại thông báo kết quả.

I. Giới thiệu mục tiêu, mục đích

	Dịch vụ tự động chấm điểm cho sinh viên và gửi thông báo về điều kiện thi và điểm số bài thi
	
	Giúp giáo viên thực hiện chấm dễ dàng
	
	Tự động lưu kết quả bài thi của sinh viên vào Bảng điểm
	
	Gửi thông báo qua Telegram Botchat.
	
II. Thành viên và đóng góp

	1. Ngô Gia Khánh: 
	
		- Cài đặt module:
		
			+ Xây dựng base cho hệ thống.
			
			+ Kiểm tra thông tin sinh viên đủ điều kiện nộp bài.
			
			+ Xác nhận thông tin định dạng bài nộp của sinh viên (PDF, JPG, DOC, JSON, ...).
			
	2. Bùi Quang Minh:
	
		- Cài đặt module:
		
			+ Check dạng bài tập và chuyển trạng thái -> Chuyển sang chờ, hoặc tự động
			
			+ Tự động chấm và trả điểm
			
	3. Phạm Văn Thanh: 
	
		- Cài đặt module:
		
			+ Chấm điểm và lưu vào csdl
			
			+ UtilityService: Gửi thông báo
	
III. Thực thi và cài đặt

	Môi trường: Java
	
	Công cụ: Framework Java Spring
	
	Phiên bản: 2.1
	
IV. Thực thi

	Môi trường: JavaSpringBoot
	
	Công cụ: Eclipse, Visual Studio Code, MySql

	Mã nguồn: https://github.com/giakhanh239/GradingService.git

V. Lịch sử phát triển

	1.0: Bao gồm dịch vụ xét bảng điểm sinh viên xem có đủ điều kiện thi không, dịch vụ nhận bài chấm
	
	1.1: Thêm kì thi.
	
	1.2: Thêm loại kì thi bao gồm: tự luận, trắc nghiệm.
	
	2.0: Thêm dịch vụ gửi thông báo khi xét bảng điểm và có kết quả bài chấm.
	
	2.1: Có cơ sở dữ liệu lưu lại bảng điểm sinh viên bao gồm các điểm chuyên cần, bài tập và cập nhật điểm thi sau khi chấm xong.
	
	2.2: Gửi thông báo qua Telegram Botchat.

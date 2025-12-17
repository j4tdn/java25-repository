<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/AdminLayout.css" />
<style type="text/css">
#mic-button.active {
	background-color: red !important; /* Đổi màu nền khi mic hoạt động */
	color: white !important; /* Đổi màu icon */
}
</style>
</head>
<body>
	<div
		class="topbar d-flex justify-content-between align-items-center px-5">


		<form action="${pageContext.request.contextPath}/${actionUrl}/find" 
		
			class="input-group mb-3 w-25 mt-3" style="background: #e7c998">

			<input type="text" id="text-input" name="findKey"
				class="form-control border-0"
				value="${sessionScope.findKey != null ? sessionScope.findKey : ''}"
				placeholder="Tìm kiếm..." aria-describedby="basic-addon2">
			<button id="mic-button" type="button" class="border-0"
				style="background: white; border: 0;">
				<i class="fas fa-microphone"></i>
			</button> 
			<button type="submit" style="background-color: #CC9600;"
				class="btn h-auto input-group-text">
				<i class="fa-solid fa-magnifying-glass text-light"></i>
			</button>

		</form>

		<div class="d-flex align-items-center">
			<%-- <div class="dropdown">
			<button class="btn dropdown" type="button" id="notificationDropdown"
				data-bs-toggle="dropdown" aria-expanded="false">
				<i class="fa-solid fa-bell fs-3"></i>
			</button>

			<!-- Dropdown Content -->
			<ul class="dropdown-menu dropdown-menu-end"
				aria-labelledby="notificationDropdown">
				<!-- Header -->
				<li class="dropdown-header">
					<h5>Notifications</h5>
				</li>

				<!-- Notifications -->
				<li class="notification-item"><img
					src="${pageContext.request.contextPath}/image/logo.png"
					class="avatar" alt="User">
					<div class="notification-text">
						<strong>Zone Hand</strong>
						<p>Sản phẩm mới đã được thêm vào</p>
						<span>30p trước</span>
					</div>
					<div class="status-container">
						<span class="status-dot red"></span> <i
							class="fa-solid fa-chevron-right arrow"></i>
					</div></li>
				<li class="notification-item"><img
					src="${pageContext.request.contextPath}/image/logo.png"
					class="avatar" alt="User">
					<div class="notification-text">
						<strong>Zone Hand</strong>
						<p>5 sản phẩm đã bị xóa</p>
						<span>30p trước</span>
					</div>
					<div class="status-container">
						<span class="status-dot red"></span> <i
							class="fa-solid fa-chevron-right arrow"></i>
					</div></li>
				<li class="notification-item"><img
					src="${pageContext.request.contextPath}/image/logo.png"
					class="avatar" alt="User">
					<div class="notification-text">
						<strong>Zone Hand</strong>
						<p>Sản phẩm A đã được cập nhật thông tin</p>
						<span>30p trước</span>
					</div>
					<div class="status-container">
						<span class="status-dot green"></span> <i
							class="fa-solid fa-chevron-right arrow"></i>
					</div></li>
			</ul>
		</div> --%>
			<div class="me-3 text-end">
				<div class="fw-bold">User name</div>
				<div>admin</div>
			</div>
			<img src="${pageContext.request.contextPath}/image/logo.png"
				class="rounded-circle" alt="" width="40" /> <a
				href="${pageContext.request.contextPath}/logout"
				class="text-decoration-none text-dark"><i
				class="fa-solid fa-right-from-bracket ms-3 fs-3"></i></a>
		</div>

	</div>
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	document.addEventListener('DOMContentLoaded', function() {
	    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
	    const micButton = document.getElementById('mic-button');

	    if (!SpeechRecognition) {
	        micButton.disabled = true;
	        micButton.title = "Trình duyệt không hỗ trợ";
	        return;
	    }

	    const recognition = new SpeechRecognition();
	    recognition.lang = 'vi-VN';
	    let isListening = false; // Biến để kiểm tra trạng thái nhận diện

	    micButton.addEventListener('click', (e) => {
	    	 e.preventDefault(); // Ngăn hành vi mặc định
	    	    e.stopPropagation(); 

	        if (isListening) {
	            recognition.stop(); // Nếu đang bật → Dừng nhận diện
	        } else {
	            recognition.start(); // Nếu đang tắt → Bắt đầu nhận diện
	        }
	    });

	    recognition.onstart = () => {
	        isListening = true;
	        micButton.classList.add('active'); // Đổi màu khi mic hoạt động
	    };

	    recognition.onresult = (event) => {
	        const transcript = event.results[0][0].transcript;
	        document.getElementById('text-input').value = transcript;
	    };

	    recognition.onspeechend = () => {
	        recognition.stop(); // Tự động dừng khi không còn giọng nói
	    };

	    recognition.onend = () => {
	        isListening = false;
	        micButton.classList.remove('active'); // Trở lại màu cũ khi dừng nhận diện
	    };

	    recognition.onerror = (event) => {
	        console.error("Lỗi:", event.error);
	        alert("Safari không hỗ trợ hoặc cần cấp quyền microphone!");
	        recognition.stop();
	    };
	});

</script> 
</body>
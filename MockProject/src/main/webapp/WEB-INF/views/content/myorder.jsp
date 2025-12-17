<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>Order Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style type="text/css">
		.decoration-none{
			text-decoration: none;
		}
		.cursor-pointer {
			cursor: pointer;
		}
		.overlay_detail {
      		position: fixed;
      		top: 0;
      		left: 0;
      		width: 100%;
      		height: 100%;
      		background-color: rgba(0, 0, 0, 0.5); /* Nền tối */
      		display: none; /* Ẩn mặc định */
      		justify-content: center;
      		align-items: center;
      		z-index: 1000;
    	}

    	.modal_detail {
      		background-color: white;
      		padding: 20px;
      		border-radius: 5px;
      		position: relative;
    	}

    	.close-button_detail {
      	position: absolute;
      	top: 10px;
      	right: 10px;
      	cursor: pointer;
    	}
	</style>
</head>
	<body class="bg-gray-100">
	<jsp:include page="../layout/header.jsp"></jsp:include>
    <div class="max-w-4xl mx-auto bg-white p-6 rounded-lg shadow-md mt-4 mb-4">
      <h1 class="text-xl font-semibold mb-4">Đơn hàng của tôi</h1>
      <div class="flex justify-between items-center border-b border-gray-200 pb-2 mb-4">
        <div class="flex space-x-4 items-center w-full">
          <a href = "/MockProject/myorder?action=all" class="text-gray-500 flex-1 decoration-none cursor-pointer text-center"> Tất cả</a>
          <a href = "/MockProject/myorder?action=delivery" class="text-gray-500 flex-1 decoration-none cursor-pointer text-center">Đang giao</a>
          <a href = "/MockProject/myorder?action=handling" class="text-gray-500 flex-1 decoration-none cursor-pointer text-center">Đang xử lý</a>
          <a href = "/MockProject/myorder?action=finish" class="text-gray-500 flex-1 decoration-none cursor-pointer text-center">Hoàn tất</a>
          <a href = "/MockProject/myorder?action=canceled" class="text-gray-500 flex-1 decoration-none cursor-pointer text-center">Bị hủy</a>
        </div>
      </div>
      <c:forEach var="listOrder" items="${listsOrder}">
      <div class="bg-gray-50 p-4 rounded-lg shadow-sm mb-4">
        <div class="flex justify-between items-center mb-2">
          <div class="text-blue-500">Mã đơn hàng: <c:out value="${listOrder.orderId}"/></div>
          <div class="text-red-500 bg-red-100 px-2 py-1 rounded-full">
            <c:out value="${listOrder.status}"/>
          </div>
        </div>
        <div class="text-gray-500 mb-2">Thời gian đặt hàng: <c:out value="${listOrder.orderDate}"/></div>
        <a class=" text-gray-700 rounded-lg button-detail-product cursor-pointer" href="/MockProject/historyOrder?order_id=<c:out value="${listOrder.orderId}"/>">Chi tiết sản phẩm</a>
        <div class="flex justify-between items-center">
          <div class="text-gray-700 font-semibold mt-2">Tổng tiền: <c:out value="${listOrder.totalPrice}"/> đ</div>
          <div class="flex space-x-2">
            <a class="bg-gray-200 text-gray-700 px-4 py-2 rounded-lg canceled decoration-none cursor-pointer " href="/MockProject/changeStatus?action=null&orderId=<c:out value="${listOrder.orderId}"/>">
              Hủy đơn
            </a>
          </div>
        </div>
      </div>
      </c:forEach>
    </div>
    <jsp:include page="../layout/footer.jsp"></jsp:include>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
    	  const huyDonButtons = document.querySelectorAll('.canceled'); // Select all "Hủy đơn" buttons

    	  huyDonButtons.forEach(button => {
    	    const parentDiv = button.closest('.bg-gray-50.p-4.rounded-lg.shadow-sm.mb-4'); // Find the parent div
    	    const statusElement = parentDiv.querySelector('.text-red-500'); // Find the status element

    	    if (statusElement) {
    	      const status = statusElement.textContent.trim(); // Get the status text

    	      if (status === 'Đang giao') {
    	        // Allow click if status is "Đang giao"
    	        button.addEventListener('click', function() {
    	          // Add your "Hủy đơn" logic here
    	          console.log('Hủy đơn được click cho đơn hàng có trạng thái Đang giao');
    	          // Example: You can add an AJAX call or other actions here.
    	        });
    	      } else {
    	        // Disable click if status is not "Đang giao"
    	        button.disabled = true;
    	        button.style.opacity = '0.5'; // Optional: visually indicate disabled state
    	        button.style.cursor = 'not-allowed'; // Optional: change cursor
    	      }
    	    }
    	  });
    	});
    </script>
    <script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
 </body>
</html>
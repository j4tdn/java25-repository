<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>HIstory Order</title>
    <script src="https://cdn.tailwindcss.com"></script>
<body class="bg-gray-100">
	<jsp:include page="../layout/header.jsp"></jsp:include>
    <div class="max-w-5xl mx-auto p-4">
      <div class="bg-white p-6 rounded-lg shadow-md">
        <div class="flex justify-between items-center mb-4">
          <div class="flex">
            <!-- <h1 class="text-xl font-semibold">#${order_history.orderId}</h1> -->
            <span
              class="bg-red-100 text-red-500 text-sm font-medium px-2 py-1 rounded"
              >${order_history.status}</span
            >
          </div>
          <div class="text-gray-500">Ngày mua: ${order_history.orderDate}</div>
        </div>
        <div class="grid grid-cols-1 md:grid-cols-3 gap-4 mb-4">
          <div class="bg-white p-4 rounded-lg shadow-md">
            <h2 class="text-sm font-semibold mb-2">Thông tin người nhận</h2>
            <p>Tên người nhận: ${user_history.name}</p>
            <p>SĐT: ${user_history.phone}</p>
            <div class="flex items-center mt-2">
              <i class="fas fa-home text-blue-500"></i>
              <p class="ml-2">
                ${address_history.street}, ${address_history.ward}, ${address_history.district}, ${address_history.province}, VN
              </p>
            </div>
          </div>
          <div class="bg-white p-4 rounded-lg shadow-md">
            <h2 class="text-sm font-semibold mb-2">Phương thức thanh toán</h2>
            <p>${payment_history.paymentMethod}</p>
          </div>
          <div class="bg-white p-4 rounded-lg shadow-md">
            <h2 class="text-sm font-semibold mb-2">Tổng tiền</h2>
            <p>Tạm tính: ${order_history.totalPrice} đ</p>
            <p>Phí vận chuyển: 32.000 đ</p>
            <p class="font-semibold">
              Tổng Số Tiền:
              <span class="text-red-500">${payment_history.paymentAmount} đ</span>
            </p>
          </div>
        </div>
        <div>
        <div class="border-t border-gray-200">
        <c:forEach var="listOrderDetail" items="${listOrderDetail_history}">
          <div class="flex items-center py-4">
            <img
              alt="${listOrderDetail.bookName}"
              class="w-16 h-20 object-cover mr-4"
              src="${pageContext.request.contextPath}/book/image/${listOrderDetail.bookId}"
            />
            <div class="flex-1">
              <h4 class="text-sm font-semibold">
                <c:out value="${listOrderDetail.bookName}"/>
              </h4>
             <%--  <p class="text-gray-500 text-sm">IdBook: <c:out value="${listOrderDetail.bookId}"/></p> --%>
            </div>
            <div class="text-right">
              <p class="text-sm font-semibold">${listOrderDetail.price} đ</p>
              <%-- <p class="text-gray-500 text-sm line-through">${listOrderDetail.price} đ</p> --%>
            </div>
            <div class="text-center w-16">
              <p class="text-sm">${listOrderDetail.quantityOrder}</p>
            </div>
            <div class="text-right w-24">
              <p class="text-sm font-semibold">${listOrderDetail.totalPrice} đ</p>
            </div>
          </div>
          </c:forEach>
        </div>
      </div>
        <!-- <div class="text-right">
          <button class="bg-red-500 text-white px-6 py-2 rounded-lg">
            Mua lại
          </button>
        </div> -->
      </div>
    </div>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="${pageContext.request.contextPath}/template/home.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/template/etc_item.css"
	rel="stylesheet" />

</head>
<body class="bg-gray-100">
	<h1 style="display: none">Book Store</h1>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<div class="container w-100 mt-5">
		<div class="intro mx-5 px-5 text-center mb-3">
			<h3 class="slogan mb-3 fw-bold">Xứ sở mộng mơ của người yêu
				sách!</h3>
			<p class="paragraph">Chào mừng đến với thiên đường của người yêu
				sách! Hãy tham gia cộng đồng của chúng tôi và đóng góp cho thư viện
				truyện ngày càng phát triển, nơi mỗi cuốn sách đều có cơ hội truyền
				cảm hứng cho một người mới.</p>
		</div>

		<form action="${pageContext.request.contextPath}/book_list/search"
			method="GET"
			class="d-flex justify-content-between col-sm-3 m-auto ps-3 border rounded-3">
			<input type="text" onfocus="this.style.outline='none';"
				class="border-0 d-inline-block" placeholder="Tìm kiếm sách..."
				name="search_value" /> <input type="hidden"
				name="minPrice" value="" /> <input type="hidden" name="maxPrice"
				value="" />
			<button type="submit" class="border-0 bg-transparent me-2">
				<i class="fa-solid fa-magnifying-glass text-body-tertiary"></i>
			</button>
		</form>

		<img class="col-md-8 mx-auto d-block mb-5"
			src="/MockProject/image/Book.png" alt="" />
		<div class="best_choice mb-5">
			<h3 class="text-center my-5">Lựa chọn tốt nhất</h3>
			<!-- Item_List -->
			<div
				class="cart-list d-flex justify-content-between gap-2 mx-auto mb-2">
				<!-- item_cart -->
				<%  String path = request.getServletPath();
 					String actionUrl = path.substring(path.lastIndexOf("/") + 1).replaceAll("\\.jsp$", "");
 					request.setAttribute("actionUrl", actionUrl);
				%>
				<c:forEach items="${books}" var="book">
					<div
								class="cart_item d-grid ms-3 pb-2 px-3 col-md-4 col-ms-6 border rounded-3"
								id="${book.bookId}" style="width: 30%;">
								<a
									href="${pageContext.request.contextPath}/cart/add/${book.bookId}?actionUrl=${actionUrl}&quantity=1&buyNow=false"
									class="mt-3 order-1 ms-auto mb-2">
									<button type="button" class="btn btn-warning text-center ">
										<i
											class="fa-solid fa-cart-shopping d-flex justify-content-center align-items-center text-white"
											style="height: 24px; width: 18px;"></i>
									</button>
								</a> <a
									href="${pageContext.request.contextPath}/product_detail/${book.bookId}"
									class="m-auto order-2"> <img
									style="width: 145px; height: 210px"
									src="${pageContext.request.contextPath}/book/image/${book.bookId}"
									class="card-img-top" alt="${book.bookName}" />
								</a>
						<div class="card-body order-3">
							<h5 class="card-title etc">${book.bookName}</h5>
							<span class="fw-bold fs-5 etc">${book.price}đ</span>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div
			class="px-3 py-5  mb-5 border-top d-flex justify-content-between gap-5">
			<img src="/MockProject/image/Read_image.png" class=""
				alt="Read Image" />
			<div class="paragraph_readHere">
				<h3 class="title_readHere fw-bold mb-4 fs-2">Reads Are Here!</h3>
				<p class="fs-6">Mua sách yêu thích trực tuyến dễ dàng! Tận hưởng
					các ưu đãi và giảm giá độc quyền cho các tựa sách đã chọn. Khám phá
					bộ sưu tập của chúng tôi và tìm các ưu đãi đặc biệt giúp việc đọc
					sách trở nên dễ dàng hơn. Mua ngay và mở khóa nhiều khoản tiết kiệm
					hơn với mỗi lần mua hàng!</p>
				<div class="statictis d-flex justify-content-between">
					<div class="bookListing">
						<p class="fw-bolder fs-2 mb-0">${numberOfOrders}</p>
						<p class="fst-italic">Book Orders</p>
					</div>
					<div class="bookListing">
						<p class="fw-bolder fs-2 mb-0">${numberOfUsers}</p>
						<p class="fst-italic">Registered Member</p>
					</div>
					<div class="bookListing">
						<p class="fw-bolder fs-2 mb-0">3</p>
						<p class="fst-italic">Branch Count</p>
					</div>
				</div>

			</div>
		</div>
		<div class="modal fade" id="errorSessionLogin" tabindex="-1"
			aria-labelledby="addUserModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg"
				style="margin-top: 15vh; max-width: 450px;">
				<div class="modal-content">
					<div class="modal-header ms-auto border-0">
						<a href="${pageContext.request.contextPath}/home">
							<button type="button" class="btn" data-bs-dismiss="modal"
								aria-label="Close">
								<i class="fa-solid fa-x" style="color: #cc9600"></i>
							</button>
						</a>

					</div>
					<h3 class="modal-title text-center w-100" id="addBookModalLabel">
						Thêm giỏ hàng thất bại</h3>

					<div class="modal-body">
						<form class="w-100">
							<div class="d-flex justify-content-center mb-4">
								<div class="position-relative">
									<div
										class="d-flex align-items-center justify-content-center bg-danger rounded-circle"
										style="width: 100px; height: 100px;">
										<i class="fas fa-times text-white" style="font-size: 48px;"></i>
									</div>
								</div>
							</div>
							<p class="text-center text-muted">Người dùng chưa đăng nhập.</p>
							<div class="text-center d-flex  justify-content-center">
								<a href="${pageContext.request.contextPath}/LoginPage"
									class="btn btn-warning w-auto text-white fw-bold">Login Now</a>

							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/handle_event_listener.js"
	defer>
</script>
<c:if test="${not empty errorSessionLogin}">
	<script>
			document.addEventListener("DOMContentLoaded", function() {
				var displayError = new bootstrap.Modal(document
						.getElementById('errorSessionLogin'));
				displayError.show();
			});
		</script>
</c:if>
</html>

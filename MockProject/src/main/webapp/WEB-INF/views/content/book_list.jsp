<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>
<title>Book's List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/template/book_list.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/template/etc_item.css"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h1 style="display: none;">BOOKZONE_BookStore</h1>
		<div class="container my-5">
			<h3 class="text-center mb-5">Sản phẩm trưng bày</h3>
			<div class="row">
				<form action="${pageContext.request.contextPath}/book_list/search"
					method="GET" class="col-md-3 position-static">
					<div
						class="d-flex justify-content-between m-auto ps-3 border rounded-3 mb-4">
						<input type="text" onfocus="this.style.outline='none';"
							class="border-0 d-inline-block" placeholder="Tìm kiếm sách..."
							name="search_value"
							value="<%=(request.getParameter("search_value") != null) ? request.getParameter("search_value") : ""%>" />
						<button type="submit" class="border-0 bg-transparent me-2">
							<i
								class="fa-solid fa-magnifying-glass text-body-tertiary my-auto"></i>
						</button>

					</div>
					<div class="border p-3 rounded shadow">
						<h5>Mức giá</h5>
						<div class="pb-4 border-bottom">
							<div class="input-group position-static">
								<span class="input-group-text">đ</span> <input type="number"
									id="minPrice" name="minPrice"
									class="form-control price-input position-static"
									placeholder="Min" min="0" max="99999999"
									<c:if test="${minPrice!= null}">
										value="${minPrice}"
									</c:if>>
							</div>
							<span>-</span>
							<div class="input-group position-static">
								<span class="input-group-text">đ</span> <input type="number"
									name="maxPrice" id="maxPrice"
									class="form-control price-input position-static"
									placeholder="Max" min="0" max="99999999"
									<c:if test="${maxPrice != null}">
										value = "${maxPrice}"
									</c:if>>
							</div>
						</div>

						<h5 class="mt-4">Thể loại</h5>
						<div>
							<c:forEach var="genre" items="${genres}">
								<input type="checkbox" class="genre_checked" id="tl1"
									name="option" value="${genre.genreId }"
									<c:if test="${options != null && fn:contains(options, genre.genreId)}">
           						    checked
      						     </c:if> />
								<label for="tl1">${genre.genreName}</label>
								<br />
							</c:forEach>
							<input type="checkbox" class="genre_checked" id="tl5" name="all"
								<c:if test="${all!= null}">
           						    checked
      						     </c:if> />
							<label for="tl5">Tất cả</label>
						</div>
					</div>
				</form>

				<div class="col-md-9">
					<div class="row g-4">
						<c:if test="${totalBooksFound >= 0}">
							<p>
								<b>Kết quả tìm kiếm:</b> ${totalBooksFound} sách
							</p>
							<c:if test="${totalBooksFound == 0}">
								<p class="text-center my-5">Sản phẩm không tồn tại!</p>
								<p class="fw-bold text-center">Sản phẩm tương tự</p>
							</c:if>
						</c:if>

						<!-- card -->
						<%
						String path = request.getServletPath();
						String actionUrl = path.substring(path.lastIndexOf("/") + 1).replaceAll("\\.jsp$", "");
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
			</div>
		</div>
</div>
		<div class="modal fade" id="errorSessionLogin" tabindex="-1"
			aria-labelledby="addUserModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg"
				style="margin-top: 15vh; max-width: 450px;">
				<div class="modal-content">
					<div class="modal-header ms-auto border-0">
						<a href="${pageContext.request.contextPath}/book_list">
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
		<div class="toast-container position-static">
			<div class="toast" role="alert" aria-live="assertive"
				aria-atomic="true">
				<div class="toast-header">
					<img src="..." class="rounded me-2" alt="..."> <strong
						class="me-auto">Bootstrap</strong> <small
						class="text-body-secondary">just now</small>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">See? Just like this.</div>
			</div>
			<c:if test="${not empty errorSessionLogin}">
				<script>
			document.addEventListener("DOMContentLoaded", function() {
				var displayError = new bootstrap.Modal(document
						.getElementById('errorSessionLogin'));
				displayError.show();
			});
		</script>
			</c:if>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script>
    document.addEventListener("DOMContentLoaded", function () {
        const allCheckbox = document.querySelector('input[name="all"]');
        const genreCheckboxes = document.querySelectorAll('input[name="option"]');

        allCheckbox.addEventListener("change", function () {
            if (this.checked) {
                genreCheckboxes.forEach(cb => cb.checked = false);
            }
        });

        genreCheckboxes.forEach(cb => {
            cb.addEventListener("change", function () {
                if (this.checked) {
                    allCheckbox.checked = false;
                }
            });
        });
    });
</script>

		<script>
        const minPrice = document.getElementById("minPrice");
        const maxPrice = document.getElementById("maxPrice");

        function validatePrice() {
            let minValue = parseInt(minPrice.value) || 0;
            let maxValue = parseInt(maxPrice.value) || 99999999;

            if (minValue >= maxValue) {
                minPrice.value = maxValue - 1;
            }

            if (minValue > 99999999) minPrice.value = 99999998;
            if (maxValue > 99999999) maxPrice.value = 99999999;
        }

        minPrice.addEventListener("input", validatePrice);
        maxPrice.addEventListener("input", validatePrice);
    </script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/js/handle_event_listener.js"
			defer></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>


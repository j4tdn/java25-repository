<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<title>Shopping Cart</title>
<script src="https://cdn.tailwindcss.com"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet" />
<style type="text/css">

.width-85 {
	width: 70%;
}

.width-100 {
	width: 100%;
}

.cursor-pointer {
	cursor: pointer;
}

.mb-4 {
	margin-bottom: 1.2rem;
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<div class="bg-gray-100" style="min-height: 50vh">
		<div class="max-w-6xl mx-auto p-4 flex">
		<div class="bg-white p-4 rounded-lg shadow-md mr-3 h-1/2 w-75">
			<h1 class="text-xl font-semibold mb-4">GIỎ HÀNG</h1>
			<c:choose>
				<c:when test="${cartItems == null}">
				<hr class="my-4">
					<p Class="text-center">Bạn chưa thêm sản phẩm nào vào trong giỏ
						hàng</p>
				</c:when>
				<c:otherwise>
					<div class="flex items-center mb-4">
						<input class="mr-4 cursor-pointer" type="checkbox" /> <span
							class="width-85"> Chọn tất cả sản phẩm </span> <span
							 class="w-25 text-end pe-3" style="margin:0 30px 0 20px; ">Số lượng</span> 
							<span  class="w-25" style="margin-right: 	0px;">Thành tiền</span>
					</div>
					<div class="border-t border-gray-200">
						<c:forEach var="cartItem" items="${cartItems}" varStatus="loop">
							<div class="flex items-center py-4"
								data-product-id=<c:out value="${cartItem.cartItemId}"/>>
								<input class="mr-4 cursor-pointer" type="checkbox" id="${cartItem.bookId}" 
								<c:if test="${idChecked != null && idChecked eq cartItem.bookId}">
           						    checked
      						     </c:if> />
      						      <img
									alt="${cartItem.bookName}" class="w-16 h-24 object-cover mr-4"
									height="90"
									src="${pageContext.request.contextPath}/book/image/${cartItem.bookId}"
									width="60" />
								<div class="flex-1">

									<h2 class="text-lg font-semibold">
										<c:out value="${cartItem.bookName}" />
									</h2>
									<p class="text-red-500 font-semibold originalPrice">
										<c:out value="${cartItem.price} đ" />
										<span class="line-through text-gray-500 d-none"> <c:out
												value="${cartItem.discount} đ" /></span>
									</p>
									<p class="text-red-500 font-semibold mb-2 quantity_book">Số lượng: ${listQuantity[loop.index]}</p>
								</div>
								<div class="flex items-center">
									<button class="px-2 py-1 border border-gray-300 decreaseBtn">
										-</button>
									<span class="px-4 quantity"> <c:out
											value="${cartItem.quantityOrder}" /></span>
									<button class="px-2 py-1 border border-gray-300 increaseBtn">
										+</button>
								</div>
								<p class="text-red-500 font-semibold ml-4 mb-0 totalPrice"
									style="width: 120px">
									<c:out value="${cartItem.totalPrice} đ" />
								</p>
								<button class="ml-4 text-gray-500 deleteItem">
									<i class="fas fa-trash"> </i>
								</button>
							</div>
						</c:forEach>
						</div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${cartItems != null}">
			<div class="bg-white p-4 rounded-lg shadow-md" style="height: max-content">
			<div>
				<p class="text-sm">Thành tiền</p>
				<p class="text-red-500 font-semibold totalPriceElement text-end">0 đ</p>
			</div>
			<div>
				<p class="text-lg font-semibold">Tổng Số Tiền (gồm VAT)</p>
				<p class="text-red-500 text-lg font-semibold totalWithVatElement text-end">
					0 đ</p>
			</div>
			<button class="w-full bg-red-500 text-white py-2 rounded-lg payTotal">
				ĐẶT HÀNG</button>
			<p class="text-xs text-gray-500 mt-2">(Giảm giá trên web chỉ áp
				dụng cho bán lẻ)</p>

		</div>
		</c:if>
	</div>
	</div>
	
</body>
		<jsp:include page="../layout/footer.jsp"></jsp:include>

	<script>
	 const selectedProductIds = []; // Mảng để lưu trữ data-product-id
      document.addEventListener("DOMContentLoaded", () => {
        // chọn checkbox để thanh toán sản phẩm
        const totalPriceElement = document.querySelector(
          ".text-red-500.font-semibold.totalPriceElement"
        );
        const totalWithVatElement = document.querySelector(
          ".text-red-500.text-lg.font-semibold.totalWithVatElement"
        );
        const selectAllCheckbox = document.querySelector(
          'input[type="checkbox"]'
        );
        const productCheckboxes = document.querySelectorAll(
          '[data-product-id] input[type="checkbox"]'
        );
       
        function calculateTotal() {
          let total = 0;
          productCheckboxes.forEach((checkbox) => {
            if (checkbox.checked) {
              const productElement = checkbox.closest("[data-product-id]");
              const priceString = productElement
                .querySelector(".totalPrice")
                .textContent.match(/[\d.]+/)[0];
              console.log("priceString: "+ priceString);
              const price = parseFloat(priceString.replace(/\./g, ""));
              console.log("price: "+ price);
              total += price;
            }
          });
          console.log(total);
          totalPriceElement.textContent = total.toLocaleString("vi-VN") + " đ";
          totalWithVatElement.textContent =
            total.toLocaleString("vi-VN") + " đ";
        }

        selectAllCheckbox.addEventListener("change", () => {
            selectedProductIds.length = 0; 

            if (selectAllCheckbox.checked) {
                productCheckboxes.forEach((checkbox) => {
                    checkbox.checked = true;
                    const productElement = checkbox.closest("[data-product-id]");
                    selectedProductIds.push(productElement.dataset.productId);
                });
            } else {
                productCheckboxes.forEach((checkbox) => {
                    checkbox.checked = false;
                });
            }
            calculateTotal();
        });

        productCheckboxes.forEach((checkbox) => {
            checkbox.addEventListener("change", () => {
              const productElement = checkbox.closest("[data-product-id]");
              const productId = productElement.dataset.productId;
              const index = selectedProductIds.indexOf(productId);

              if (checkbox.checked) {
                if (index === -1) {
                  selectedProductIds.push(productId);
                }
              } else {
                if (index !== -1) {
                  selectedProductIds.splice(index, 1);
                }
              }
              calculateTotal();
            });
          });

        calculateTotal(); // Tính tổng ban đầu khi trang tải

        // tăng giảm số lương sản phẩm
        document.querySelectorAll(".increaseBtn").forEach((button) => {
          button.addEventListener("click", increaseQuantity);
        });

        document.querySelectorAll(".decreaseBtn").forEach((button) => {
          button.addEventListener("click", decreaseQuantity);
        });
        function increaseQuantity(event) {
          const productElement = event.target.closest("[data-product-id]");
          updateQuantity(productElement, 1);
        }

        function decreaseQuantity(event) {
          const productElement = event.target.closest("[data-product-id]");
          updateQuantity(productElement, -1);
        }

        function updateQuantity(productElement, change) {
          const quantityElement = productElement.querySelector(".quantity");
          const quantityBookElement = productElement.querySelector(".quantity_book");
          const quantityText = quantityBookElement.textContent; 
          const quantityValue = quantityText.replace("Số lượng: ", "").trim();
          const quantityNumber = parseInt(quantityValue, 10);
          const originalPriceElement =
            productElement.querySelector(".originalPrice");
          const totalPrice = productElement.querySelector(".totalPrice");
          const productCheckbox = productElement.querySelector(
            'input[type="checkbox"]'
          );
          const productId = productElement.getAttribute("data-product-id");

          let quantity = parseInt(quantityElement.textContent);
          quantity += change;
          if (quantity < 1) {
            alert("Số lượng không thể nhỏ hơn 1.");
            return;
          }
          if(quantity > quantityNumber){
        	alert("Số lượng sách không đủ !");
            return;
          }
          quantityElement.textContent = quantity;
          const priceString =
            originalPriceElement.textContent.match(/[\d.]+/)[0];
          const price = parseFloat(priceString.replace(".", ""));
          const total = price * quantity;
          totalPrice.textContent = total.toLocaleString("vi-VN") + " đ";
          if (productCheckbox.checked) {
            calculateTotal();
          }
          sendDataToController(productId, quantity, total);
        }
        function sendDataToController(productId, quantity, totalPrice) {
        	  const xhr = new XMLHttpRequest();
        	  xhr.open("POST", "cart", true); // Đặt URL controller
        	  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        	  xhr.onload = function () {
        	    if (xhr.status >= 200 && xhr.status < 300) {
        	      console.log("Dữ liệu đã được gửi thành công!");
        	      // Xử lý phản hồi từ server (nếu cần)
        	    } else {
        	      console.error("Lỗi khi gửi dữ liệu:", xhr.status, xhr.statusText);
        	    }
        	  };
        	  xhr.onerror = function () {
        	    console.error("Lỗi mạng khi gửi dữ liệu!");
        	  };
        	  const formattedTotalPrice = totalPrice.toString().replace(/[^\d.-]/g, "");//remove non numeric value from price.
        	  xhr.send(
        	    "productId=" +
        	      encodeURIComponent(productId) +
        	      "&quantity=" +
        	      encodeURIComponent(quantity) +
        	      "&totalPrice=" +
        	      encodeURIComponent(formattedTotalPrice) +
                  "&action=update"
        	  );
        	}
        const deleteButtons = document.querySelectorAll(".deleteItem");

        deleteButtons.forEach((button) => {
            button.addEventListener("click", deleteItem);
        });

        /* function deleteItem(event) {
            const productElement = event.target.closest("[data-product-id]");
            const productId = productElement.getAttribute("data-product-id");
            sendDeleteRequest(productId);
        } */
        function deleteItem(event) {
            const confirmDelete = confirm("Bạn có chắc chắn muốn xoá sản phẩm này khỏi giỏ hàng?");
            if (!confirmDelete) {
                return; // Nếu người dùng bấm Cancel, thoát hàm
            }

            const productElement = event.target.closest("[data-product-id]");
            const productId = productElement.getAttribute("data-product-id");
            sendDeleteRequest(productId);
        }


        function sendDeleteRequest(productId) {
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "cart", true); // Sửa URL ở đây
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onload = function () {
                if (xhr.status >= 200 && xhr.status < 300) {
                    console.log("Sản phẩm đã được xóa!");
                    // Xử lý phản hồi từ server (ví dụ: xóa phần tử khỏi DOM)
                    window.location.reload();
                } else {
                    console.error("Lỗi khi xóa sản phẩm:", xhr.status, xhr.statusText);
                }
            };

            xhr.onerror = function () {
                console.error("Lỗi mạng khi xóa sản phẩm!");
            };

            xhr.send("productId=" + encodeURIComponent(productId) + "&action=delete");
        }
      });
      //onclick nhập voucher
      document.addEventListener("DOMContentLoaded", () => {
        const showModalBtn = document.querySelector(".show-modal");
        const closeModalBtn = document.getElementById("close-modal");
        const modalOverlay = document.getElementById("modal-overlay");
        const modal = document.getElementById("modal");

        showModalBtn.addEventListener("click", () => {
          modal.classList.remove("hidden");
          modalOverlay.classList.remove("hidden");
        });

        closeModalBtn.addEventListener("click", () => {
          modal.classList.add("hidden");
          modalOverlay.classList.add("hidden");
        });

        modalOverlay.addEventListener("click", () => {
          modal.classList.add("hidden");
          modalOverlay.classList.add("hidden");
        });
      });
      // xử lý điều kiện button thanh toán
      document.addEventListener("DOMContentLoaded", function () {
        const payTotalButton = document.querySelector(".payTotal");
        const totalWithVatElement = document.querySelector(
          ".totalWithVatElement"
        );

        payTotalButton.addEventListener("click", function () {
          const totalWithVatString = totalWithVatElement.textContent
            .trim()
            .replace(" đ", "");
          const totalWithVat =
            parseInt(totalWithVatString.replace(/\./g, "")) || 0;

          if (totalWithVat === 0) {
            alert("Vui lòng chọn sản phẩm để thanh toán!");
          } else {
        	  let userId = "${userId}";
        	  sendPaymentRequest(totalWithVat, selectedProductIds, function() {
                  window.location.href = "/MockProject/payment";
              });
          }
        });
        function sendPaymentRequest(totalPrice, selectedProductIds, callback) {
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "payment", true); // Sửa URL ở đây
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onload = function () {
                if (xhr.status >= 200 && xhr.status < 300) {
                    console.log("Gửi yêu cầu thanh toán thành công!");
                    if (typeof callback === "function") {
                        callback();
                    }
                } else {
                    console.error("Lỗi khi gửi yêu cầu thanh toán:", xhr.status, xhr.statusText);
                }
            };

            xhr.onerror = function () {
                console.error("Lỗi mạng khi gửi yêu cầu thanh toán!");
            };

            // Chuyển đổi mảng selectedProductIds thành chuỗi
            const productIdsString = selectedProductIds.join(",");

            xhr.send(
                "&total_price=" + encodeURIComponent(totalPrice) +
                "&selectedProductIds=" + encodeURIComponent(productIdsString)
            );
        }
        
      });
    </script>
    <script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
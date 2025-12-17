<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
</head>
  <body class="bg-gray-100">
  <jsp:include page="../layout/header.jsp"></jsp:include>
    <div class="flex justify-center py-10">
      <div class="bg-white shadow-md rounded-lg p-6 max-w-6xl flex">
        <!-- Main Content -->
        <div class="pl-4 w-80">
          <h2 class="text-2xl font-semibold mb-6">Hồ sơ cá nhân</h2>
          <form method="post" action="update_profile">
            <div class="mb-4">
              <label class="block text-gray-700"
                >Tên<span class="text-red-500">*</span></label
              >
              <input
                type="text"
                placeholder="Nhập tên"
                class="w-full border rounded px-3 py-2 mt-1"
                value = "${user.name}"
                name = "name"
                id="nameInput"
              />
              <p id="nameError" class="text-red-500 hidden">Tên chỉ được chứa chữ cái và khoảng trắng.</p>
            </div>
            <div class="mb-4">
              <label class="block text-gray-700">Số điện thoại<span class="text-red-500">*</span></label>
              <div class="items-center">
                <input
                  type="text"
                  value = "${user.phone}"
                  class="w-full border rounded px-3 py-2 mt-1"
                  name = "phone"
                  placeholder="nhập số điện thoại"
                  id="phoneInput"
                />
                <p id="phoneError" class="text-red-500 hidden">Số điện thoại chỉ được chứa số.</p>
              </div>
            </div>
            <div class="mb-4">
              <label class="block text-gray-700">Email<span class="text-red-500">*</span></label>
              <div class="flex items-center">
                <input
                  type="email"
                  
                  value = "${user.email}"
                  class="w-full border rounded px-3 py-2 mt-1"
                  name = "email"
                  readonly="readonly" 
                />
              </div>
            </div>
            <div class="mb-4">
              <label class="block text-gray-700"
                >Giới tính<span class="text-red-500">*</span></label
              >
              <div class="flex items-center mt-4">
                <input type="radio" name="gender" id="male" class="mr-2" value="Male" onclick="updateGender('Male')"/>
                <label for="male" class="mr-8">Nam</label>
                <input type="radio" name="gender" id="female" class="mr-2" value="Female" onclick="updateGender('Female')"/>
                <label for="female">Nữ</label>
                <input type="hidden" id="hiddenGender" value="${user.sex}" name="sex"/> 
              </div>
            </div>

            <div class="mt-6 flex justify-center">
              <button
                type="submit"
                class="bg-red-600 text-white px-6 py-2 rounded"
              >
                Lưu thay đổi
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <jsp:include page="../layout/footer.jsp"></jsp:include>
    <script>
	    function updateGender(gender) {
	        document.getElementById('hiddenGender').value = gender;
	        const maleRadio = document.getElementById('male');
	        const femaleRadio = document.getElementById('female');
	
	        if (gender === 'Male') {
	            maleRadio.checked = true;
	            femaleRadio.checked = false;
	        } else if (gender === 'Female') {
	            femaleRadio.checked = true;
	            maleRadio.checked = false;
	        }
	    }
	    const initialGender = document.getElementById('hiddenGender').value;
	    updateGender(initialGender);
	    
	    function validateForm() {
	        const nameInput = document.getElementById('nameInput');
	        const genderInput = document.getElementById('hiddenGender');

	        if (nameInput.value.trim() === '' || genderInput.value.trim() === '') {
	            alert('Vui lòng điền đầy đủ thông tin bắt buộc.');
	        } else {
	            document.getElementById('profileForm').submit();
	        }
	    }
	    document.addEventListener('DOMContentLoaded', function() {
	        const nameInput = document.getElementById('nameInput');
	        const phoneInput = document.getElementById('phoneInput');
	        const nameError = document.getElementById('nameError');
	        const phoneError = document.getElementById('phoneError');

	        nameInput.addEventListener('input', function() {
	            const nameValue = this.value;
	            const nameRegex = /^[a-zA-Z\s]*$/; // Chỉ cho phép chữ cái và khoảng trắng

	            if (!nameRegex.test(nameValue)) {
	                nameError.classList.remove('hidden');
	                this.value = nameValue.replace(/[^a-zA-Z\s]/g, ''); // Loại bỏ ký tự không hợp lệ
	            } else {
	                nameError.classList.add('hidden');
	            }
	        });

	        phoneInput.addEventListener('input', function() {
	            const phoneValue = this.value;
	            const phoneRegex = /^[0-9]*$/; // Chỉ cho phép số

	            if (!phoneRegex.test(phoneValue)) {
	                phoneError.classList.remove('hidden');
	                this.value = phoneValue.replace(/[^0-9]/g, ''); // Loại bỏ ký tự không hợp lệ
	            } else {
	                phoneError.classList.add('hidden');
	            }
	        });
	    });
</script>
<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
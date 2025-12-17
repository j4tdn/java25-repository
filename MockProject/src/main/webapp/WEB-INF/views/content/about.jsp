<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>About_Us</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link href="/MockProject/template/about_us.css" rel="stylesheet" />
    <style>
.store-item:hover {
    background-color: #f8f9fa;
    cursor: pointer;
}
.store-item.active {
    background-color: #fff3cd;
}
</style>
  </head>
  <body>
   <jsp:include page="../layout/header.jsp" ></jsp:include>
    
    <div class="banner text-center">
        <img
          src="${pageContext.request.contextPath}/image/About_us_image.png"
          alt="Book Zone" class="w-100"
        />
      </div>
      <div class="container p-0">
      
      <div class="content_container">
        <div class="text-center my-5">
          <h3 class="text-warning">Về chúng tôi</h3>
          <p>
            Chào mừng bạn đến với Book Zone, nguồn đáng tin cậy của bạn về nhiều
            loại sách đa dạng đáp ứng sở thích của mọi độc giả. Được thành lập
            với sứ mệnh nuôi dưỡng niềm yêu thích đọc sách trong cộng đồng,
            chúng tôi tự hào về việc cung cấp dịch vụ xuất sắc và nhiều lựa chọn
            sách. Hành trình của chúng tôi bắt đầu vào năm 2021 và kể từ đó,
            chúng tôi đã phát triển trở thành điểm đến yêu thích của những người
            yêu sách. Dưới đây, bạn sẽ tìm thấy thông tin về bốn chi nhánh của
            chúng tôi, địa điểm và số liên lạc của họ.
          </p>
        </div>

        <div class="text-center">
          <h3 class="text-warning">Chi nhánh của chúng tôi</h3>
          <div class="row">
            <div class="col-md-4 branch-info">
              <span>Zone</span>
              <p>
                Đường Chính, Trung Tâm Thành Phố<br/>Liên hệ: 123-456-7890<br />Giờ
                hoạt động: Thứ Hai đến Thứ Bảy, 9 giờ sáng - 7 giờ tối; Chủ
                nhật, 10 giờ sáng - 5 giờ chiều
              </p>
            </div>
            <div class="col-md-4 branch-info">
              <span>Zone</span>
              <p>
                Đường Chính, Trung Tâm Thành Phố<br />Liên hệ: 123-456-7890<br />Giờ
                hoạt động: Thứ Hai đến Thứ Bảy, 9 giờ sáng - 7 giờ tối; Chủ
                nhật, 10 giờ sáng - 5 giờ chiều
              </p>
            </div>
            <div class="col-md-4 branch-info">
              <span>Zone</span>
              <p>
                Đường Chính, Trung Tâm Thành Phố<br />Liên hệ: 123-456-7890<br />Giờ
                hoạt động: Thứ Hai đến Thứ Bảy, 9 giờ sáng - 7 giờ tối; Chủ
                nhật, 10 giờ sáng - 5 giờ chiều
              </p>
            </div>
          </div>
        </div>
        
       <!-- Thêm bản đồ vào đây giúp  tôi -->
       <div class="col-md-8">
            <div id="storeMap" style="height: 500px; width: 100%; border-radius: 8px;"></div>
        </div>
        <div class="text-center my-5">
          <h3 class="text-warning">Cam kết của chúng tôi</h3>
          <p>
            Tại Book Zone, chúng tôi cam kết cung cấp một môi trường thân thiện
            và đầy cảm hứng cho tất cả những người đam mê sách. Mỗi chi nhánh
            của chúng tôi đều có đội ngũ nhân viên am hiểu và thân thiện sẵn
            sàng hỗ trợ bạn tìm kiếm cuốn sách hoàn hảo. Cho dù bạn đang tìm
            kiếm cuốn sách bán chạy mới nhất, một cuốn sách hiếm hay một nơi ấm
            cúng để đọc, Book Zone là điểm đến dành cho bạn. Chúng tôi tin vào
            sức mạnh của việc đọc sách để thay đổi cuộc sống và xây dựng cộng
            đồng. Hãy tham gia cùng chúng tôi tại một trong các chi nhánh của
            chúng tôi hoặc khám phá các dịch vụ trực tuyến của chúng tôi. Chúng
            tôi ở đây để hỗ trợ hành trình đọc sách của bạn và giúp trải nghiệm
            mua sách của bạn trở nên thú vị và trọn vẹn.
          </p>
        </div>
      </div>
    </div>
    
	<jsp:include page="../layout/footer.jsp"></jsp:include>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>



<script>
let map;
let markers = [];
let infoWindows = [];

function initMap() {
    // Vị trí mặc định (có thể lấy từ chi nhánh đầu tiên)
    const defaultLocation = { lat: 21.0278, lng: 105.8342 };
    
    // Khởi tạo bản đồ
    map = new google.maps.Map(document.getElementById("storeMap"), {
        center: defaultLocation,
        zoom: 13,
        styles: [
            {
                featureType: "poi",
                elementType: "labels",
                stylers: [{ visibility: "off" }]
            }
        ]
    });
    
    // Thêm marker cho các chi nhánh
    const storeItems = document.querySelectorAll('.store-item');
    storeItems.forEach((item, index) => {
        const lat = parseFloat(item.dataset.lat);
        const lng = parseFloat(item.dataset.lng);
        const title = item.dataset.title;
        
        // Tạo marker
        const marker = new google.maps.Marker({
            position: { lat, lng },
            map: map,
            title: title,
            icon: {
                url: "https://maps.google.com/mapfiles/ms/icons/red-dot.png"
            }
        });
        
        // Tạo info window
        const infoWindow = new google.maps.InfoWindow({
            content: item.innerHTML
        });
        
        // Lưu lại để sử dụng sau
        markers.push(marker);
        infoWindows.push(infoWindow);
        
        // Sự kiện click marker
        marker.addListener('click', () => {
            infoWindows.forEach(iw => iw.close());
            infoWindow.open(map, marker);
            
            // Highlight item trong danh sách
            storeItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
        });
        
        // Sự kiện click vào item danh sách
        item.addEventListener('click', (e) => {
            e.preventDefault();
            map.setCenter(marker.getPosition());
            map.setZoom(15);
            infoWindows.forEach(iw => iw.close());
            infoWindow.open(map, marker);
            
            // Animation cho marker
            marker.setAnimation(google.maps.Animation.BOUNCE);
            setTimeout(() => marker.setAnimation(null), 1000);
            
            // Highlight item
            storeItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
        });
    });
}
</script>
   
  </body>

     --%>
     
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>About_Us</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link href="/MockProject/template/about_us.css" rel="stylesheet" />
    <!-- Thêm Leaflet CSS -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
    <style>
        .store-item:hover {
            background-color: #f8f9fa;
            cursor: pointer;
        }
        .store-item.active {
            background-color: #fff3cd;
        }
        #storeMap {
            height: 500px; 
            width: 100%;
            border-radius: 8px;
            z-index: 1;
        }
        .map-section {
            margin: 40px 0;
        }
    </style>
</head>
<body>
   <jsp:include page="../layout/header.jsp" ></jsp:include>
    
    <div class="banner text-center">
        <img
          src="${pageContext.request.contextPath}/image/About_us_image.png"
          alt="Book Zone" class="w-100"
        />
      </div>
      <div class="container p-0">
      
      <div class="content_container">
        <div class="text-center my-5">
          <h3 class="text-warning">Về chúng tôi</h3>
          <p>
            Chào mừng bạn đến với Book Zone, nguồn đáng tin cậy của bạn về nhiều
            loại sách đa dạng đáp ứng sở thích của mọi độc giả. Được thành lập
            với sứ mệnh nuôi dưỡng niềm yêu thích đọc sách trong cộng đồng,
            chúng tôi tự hào về việc cung cấp dịch vụ xuất sắc và nhiều lựa chọn
            sách. Hành trình của chúng tôi bắt đầu vào năm 2021 và kể từ đó,
            chúng tôi đã phát triển trở thành điểm đến yêu thích của những người
            yêu sách. Dưới đây, bạn sẽ tìm thấy thông tin về bốn chi nhánh của
            chúng tôi, địa điểm và số liên lạc của họ.
          </p>
        </div>

        <div class="text-center">
          <h3 class="text-warning">Chi nhánh của chúng tôi</h3>
          <div class="row">
            <div class="col-md-4 branch-info store-item" 
                 data-lat="21.0278" data-lng="105.8342"
                 data-title="Chi nhánh Hà Nội">
              <span>Chi nhánh Hà Nội</span>
              <p>
                123 Đường Chính, Quận 1<br/>
                Liên hệ: 123-456-7890<br />
                Giờ hoạt động: Thứ Hai đến Thứ Bảy, 9 giờ sáng - 7 giờ tối; Chủ
                nhật, 10 giờ sáng - 5 giờ chiều
              </p>
            </div>
            
            <div class="col-md-4 branch-info store-item" 
                 data-lat="16.0544" data-lng="108.2022"
                 data-title="Chi nhánh Đà Nẵng">
              <span>Chi nhánh Đà Nẵng</span>
              <p>
                789 Đường XYZ, Quận Hải Châu<br />
                Liên hệ: 555-123-4567<br />
                Giờ hoạt động: Thứ Hai đến Thứ Bảy, 8:30 sáng - 7:30 tối
              </p>
            </div>
            
            <div class="col-md-4 branch-info store-item" 
                 data-lat="10.8231" data-lng="106.6297"
                 data-title="Chi nhánh TP.HCM">
              <span>Chi nhánh TP.HCM</span>
              <p>
                456 Đường ABC, Quận 2<br />
                Liên hệ: 987-654-3210<br />
                Giờ hoạt động: Thứ Hai đến Thứ Bảy, 8 giờ sáng - 8 giờ tối; Chủ
                nhật, 9 giờ sáng - 4 giờ chiều
              </p>
            </div>
          </div>
        </div>
        
        <!-- Bản đồ OpenStreetMap -->
        <div class="map-section">
            <h3 class="text-warning text-center mb-4">Vị trí các chi nhánh</h3>
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div id="storeMap"></div>
                    <p class="text-muted small mt-2">
                        © <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors
                    </p>
                </div>
            </div>
        </div>
        
        <div class="text-center my-5">
          <h3 class="text-warning">Cam kết của chúng tôi</h3>
          <p>
            Tại Book Zone, chúng tôi cam kết cung cấp một môi trường thân thiện
            và đầy cảm hứng cho tất cả những người đam mê sách. Mỗi chi nhánh
            của chúng tôi đều có đội ngũ nhân viên am hiểu và thân thiện sẵn
            sàng hỗ trợ bạn tìm kiếm cuốn sách hoàn hảo. Cho dù bạn đang tìm
            kiếm cuốn sách bán chạy mới nhất, một cuốn sách hiếm hay một nơi ấm
            cúng để đọc, Book Zone là điểm đến dành cho bạn. Chúng tôi tin vào
            sức mạnh của việc đọc sách để thay đổi cuộc sống và xây dựng cộng
            đồng. Hãy tham gia cùng chúng tôi tại một trong các chi nhánh của
            chúng tôi hoặc khám phá các dịch vụ trực tuyến của chúng tôi. Chúng
            tôi ở đây để hỗ trợ hành trình đọc sách của bạn và giúp trải nghiệm
            mua sách của bạn trở nên thú vị và trọn vẹn.
          </p>
        </div>
      </div>
    </div>
    
    <jsp:include page="../layout/footer.jsp"></jsp:include>
    
    <!-- Thêm Leaflet JS -->
    <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
    // Khởi tạo bản đồ khi trang tải xong
    document.addEventListener('DOMContentLoaded', function() {
        // Tọa độ mặc định (Hà Nội)
        /* const defaultLocation = [21.0278, 105.8342]; */
        const defaultLocation = [16.0544, 108.2022];
        const defaultZoom = 5;
        
        // Khởi tạo bản đồ
        const map = L.map('storeMap').setView(defaultLocation, defaultZoom);
        
        // Thêm tile layer từ OpenStreetMap
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
            maxZoom: 18
        }).addTo(map);
        
        // Tạo icon marker tùy chỉnh
        const customIcon = L.icon({
            iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png',
            iconSize: [25, 41],
            iconAnchor: [12, 41],
            popupAnchor: [1, -34]
        });
        
        // Thêm marker cho các chi nhánh
        const storeItems = document.querySelectorAll('.store-item');
        const markers = [];
        
        storeItems.forEach((item, index) => {
            const lat = parseFloat(item.dataset.lat);
            const lng = parseFloat(item.dataset.lng);
            const title = item.dataset.title;
            const content = item.innerHTML;
            
            // Tạo marker
            const marker = L.marker([lat, lng], { 
                icon: customIcon,
                title: title
            }).addTo(map);
            
            // Thêm popup
            /* marker.bindPopup(`
                <div style="max-width: 300px;">
                    <h5 style="color: #CC9600;">${title}</h5>
                    ${content}
                </div>
            `); */
            
            // Lưu thông tin marker
            markers.push({
                marker: marker,
                element: item
            });
            
            
            // Sự kiện click vào marker
            marker.on('click', function() {
                // Highlight item trong danh sách
                storeItems.forEach(i => i.classList.remove('active'));
                item.classList.add('active');
                
                // Phóng to vào marker
                map.setView([lat, lng], 15);
            });
            
            // Sự kiện click vào item danh sách
            item.addEventListener('click', function(e) {
                e.preventDefault();
                
                // Di chuyển bản đồ đến marker
                map.setView([lat, lng], 15);
                marker.openPopup();
                
                // Highlight item
                storeItems.forEach(i => i.classList.remove('active'));
                item.classList.add('active');
            });
        });
        
        // Tự động mở popup cho marker đầu tiên
        /* if (markers.length > 0) {
            markers[0].marker.openPopup();
            storeItems[0].classList.add('active');
        } */
        
        storeItems.forEach((item, index) => {
            if (item.dataset.title === "Chi nhánh Đà Nẵng") {
                markers[index].marker.openPopup();
                item.classList.add('active');
                // Di chuyển bản đồ đến vị trí chi nhánh Đà Nẵng
                map.setView([parseFloat(item.dataset.lat), parseFloat(item.dataset.lng)], 15);
            }
        });
    });
    </script>
</body>
</html>
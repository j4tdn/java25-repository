package fa.mockproject.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import fa.mockproject.config.configVNPay;
import fa.mockproject.service.OrderService;
import fa.mockproject.service.PaymentService;

@Controller
public class VNPayController{
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/create_payment")
	public RedirectView creatPayment(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		UUID orderID = (UUID) session.getAttribute("orderID");
		String orderIDString = orderID.toString();
		BigDecimal totalPrice = (BigDecimal) session.getAttribute("totalPrice");
		BigDecimal amountBigDecimal = totalPrice.multiply(new BigDecimal(100));
		String orderType = "other";
		long amount = amountBigDecimal.longValue(); 
        String vnp_TxnRef = configVNPay.getRandomNumber(8);
        String vnp_IpAddr = configVNPay.getIpAddress(request);

        String vnp_TmnCode = configVNPay.vnp_TmnCode;
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", configVNPay.vnp_Version);
        vnp_Params.put("vnp_Command", configVNPay.vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_PaymentMethod", "");
        vnp_Params.put("vnp_TxnRef", orderIDString);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang : " + orderIDString);
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_IpAddr", "127.0.0.1");
        vnp_Params.put("vnp_ReturnUrl", configVNPay.vnp_ReturnUrl);
        System.out.println(vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        System.out.println(vnp_CreateDate);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        
        cld.add(Calendar.MINUTE, 10);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        System.out.println(vnp_ExpireDate);
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = configVNPay.hmacSHA512(configVNPay.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = configVNPay.vnp_PayUrl + "?" + queryUrl;
        System.out.println(paymentUrl);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(paymentUrl);
        return redirectView;
	}
	@PostMapping("complete_VNPay")
    @ResponseBody
    public String handleCartRequest(
            @RequestParam("AddressId") UUID AddressId,
            @RequestParam("totalPrice") BigDecimal totalPrice,
            HttpSession session) { // Sử dụng Double
		
		String id_user = (String)session.getAttribute("id_User");
	    UUID uuid_id_user = UUID.fromString(id_user.trim());
	    UUID orderID = (UUID) session.getAttribute("orderID");
	    
	    String payment_method = "Bank Transfer";
	    paymentService.completePayment(uuid_id_user, orderID, totalPrice, AddressId,payment_method);
	    String status = "Đang giao";
	    orderService.updateStatus(orderID, status);
        return "content/home";
    }
}
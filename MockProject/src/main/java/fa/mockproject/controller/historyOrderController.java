package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.service.*;
import fa.mockproject.model.*;

@Controller
public class historyOrderController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("historyOrder")
	public String viewAbout(@RequestParam("order_id") UUID order_id,
			Model model) {

		Payment payment = paymentService.getPaymentByOrderID(order_id);
		Order order = orderService.getOrderByID(order_id);
		User user = userService.getUserByID(order.getUserId());
		if(payment != null) {
			Address address = addressService.findById(payment.getAddressId());
			model.addAttribute("address_history", address);
		}
		ArrayList<OrderDetail> listOrderDetail = orderDetailService.getItemsByOrderID(order_id);
		
		model.addAttribute("payment_history", payment); 
		model.addAttribute("order_history", order); 
		model.addAttribute("user_history", user); 
		model.addAttribute("listOrderDetail_history", listOrderDetail); 
		return "content/historyOrder";
	}
	
}

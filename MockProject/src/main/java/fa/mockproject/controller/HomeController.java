package fa.mockproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.model.Book;
import fa.mockproject.model.User;
import fa.mockproject.service.BookService;
import fa.mockproject.service.CartItemsService;
import fa.mockproject.service.OrderService;
import fa.mockproject.service.UserService;

@Controller
public class HomeController {
	@Autowired
	BookListController bookListController;
	@Autowired
	BookService bookService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String viewHome(HttpServletRequest req, HttpSession session, Model model) {
		String numberOfUsers = numberOf(userService.findAll().size());
		String numberOfOrders = numberOf(orderService.findAll().size());
		String userId = (String) session.getAttribute("userid");
		List<Book> books = null;
		books = bookService.findTop4();
		model.addAttribute("books",books);
		model.addAttribute("numberOfUsers", numberOfUsers);
		model.addAttribute("numberOfOrders", numberOfOrders);
		return "content/home";
		
	}
	public String numberOf(int number) {
		if(number > 100) {
			return String.valueOf(Math.floorDiv(number, 100) * 100)+"+" ;
		} else {
			return String.valueOf(number);
		}
	}
	
	
	
}

package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.mockproject.model.*;
import fa.mockproject.service.*;

@Controller
public class CartController {

	@Autowired
	private CartItemsService cartItemsService;
	@Autowired
	private CartService cartService;
	@Autowired
	private BookService bookService;

	@GetMapping("/cart")
	public String viewCart(Model model, HttpSession session, @RequestParam("actionUrl") String url,
			RedirectAttributes redirectAttributes/* , @ModelAttribute("idChecked") String idChecked */) {
		if(url.isEmpty()) {
			url = "home";
		}
		UUID userId = null;
		if (session.getAttribute("userid") != null) {
			System.out.println("userId_Sesion: " + session.getAttribute("userid"));
			userId = UUID.fromString(session.getAttribute("userid").toString());
			ArrayList<CartItems> cartItems = cartItemsService.getListCartItem(userId);
			
			model.addAttribute("cartItems", cartItems);
			ArrayList<Integer> listQuantity = new ArrayList<>();
			if (cartItems != null) {
	            for (CartItems cartItem : cartItems) {
	                int quantity = bookService.getQuantityByID(cartItem.getBookId());
	                listQuantity.add(quantity);
	               
	            }
	        } else {
	            System.out.println("Danh sách cartItems rỗng.");
	        }
			/*
			 * UUID checked = UUID.fromString(idChecked);
			 * redirectAttributes.addFlashAttribute("idChecked", checked);
			 */
			model.addAttribute("listQuantity", listQuantity);
			model.addAttribute("userId", userId);
			return "content/cart";
		}
		
		redirectAttributes.addFlashAttribute("errorSessionLogin", true);
		return "redirect:/" + url;
	}

	@PostMapping("cart")
    @ResponseBody
    public String handleCartRequest(
            @RequestParam("action") String action,
            @RequestParam("productId") String productId,
            @RequestParam(value = "quantity", required = false) Integer quantity, // Sử dụng Integer
            @RequestParam(value = "totalPrice", required = false) Double totalPrice) { // Sử dụng Double

        if ("update".equals(action)) {
            System.out.println("Cập nhật giỏ hàng:");
            System.out.println("Product ID: " + productId);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: " + totalPrice);
            cartItemsService.UpdateCartItem(productId, quantity, totalPrice);
            return "content/cart";
        } 
        else if ("delete".equals(action)) {
            System.out.println("Xóa sản phẩm:");
            System.out.println("Product ID: " + productId);
            cartItemsService.deleteCartItem(productId);
            return "content/cart";
        } 
        else {
            return "Lỗi: Hành động không hợp lệ";
        }
    }

	@GetMapping("cart/add/{bookId}")
	public String addCart(@PathVariable("bookId") UUID bookId, HttpSession session, Model model,
			RedirectAttributes redirectAttributes, @RequestParam("actionUrl") String url,
			@RequestParam("quantity") String quantity, @RequestParam("buyNow") Boolean buyNow) {
		UUID userId = null;
		if (session.getAttribute("userid") != null) {
			userId = UUID.fromString(session.getAttribute("userid").toString());

		} else {
			System.out.println("check UserId");
			redirectAttributes.addFlashAttribute("errorSessionLogin", true);
			System.out.println(url);
			return "redirect:/" + url;
		}

		Book b = new Book(bookId, null, null, 0, null, null, null, 0, null, null, bookId);
		Book book = bookService.findById(b);
		UUID cartId = getCartIdForUser(userId);
		int amount = Integer.parseInt(quantity);
		if (book.getQuantity() >= amount) {
			CartItems c = new CartItems(cartId, cartId, bookId, null, null, amount, null, null, null);

			if (cartItemsService.findByCartIdAndBookId(c) == null) {
				CartItems cartItem = new CartItems(null, cartId, book.getBookId(), book.getBookName(), book.getPrice(),
						1, null, book.getPrice(), book.getAvatar());
				cartItemsService.insert(cartItem);
				System.out.println("add cart_item chưa có trong cart - hoàn thành");
			} else {
				CartItems cartItem = cartItemsService.findByCartIdAndBookId(c);
				cartItemsService.updateWithBookIdAndCartId(cartItem.getQuantityOrder() + 1,
						cartItem.getTotalPrice().add(cartItem.getPrice()), cartItem.getBookId(), cartItem.getCartId());
				System.out.println("add cart_item đã có-hoàn thành.");
			}
		}

		System.out.println(url);
		UUID idToCheck= null;
		if(buyNow == true) {
			/*
			 * idToCheck = book.getBookId();
			 * redirectAttributes.addFlashAttribute("idChecked", idToCheck.toString());
			 */
			return "redirect:/cart?actionUrl="+url;
		}
		/*
		 * if(idToCheck== null) { UUID newUUID = UUID.randomUUID(); idToCheck = newUUID;
		 * } redirectAttributes.addFlashAttribute("idChecked", idToCheck.toString());
		 */
		return "redirect:/" + url;

	}

	public UUID getCartIdForUser(UUID userId) {
		Cart c = new Cart(userId, userId, null, null, null, null);
		Cart cart = new Cart();
		if (cartService.findByUserId(c) != null) {
			cart = cartService.findByUserId(c);
		} else {
			Cart newCart = new Cart(null, userId, null, null, null, null);
			cartService.insert(newCart);
			cart = cartService.findByUserId(newCart);

		}
		System.out.println("cart_id: " + cart.getCartId());
		return cart.getCartId();

	}
}

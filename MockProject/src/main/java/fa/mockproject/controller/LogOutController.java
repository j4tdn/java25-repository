package fa.mockproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {
	@GetMapping("/logout")
	private String logOut(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/LoginPage";
		}
		session.removeAttribute("userId");
		return "redirect:/LoginPage";
	}
}

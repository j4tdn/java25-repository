package fa.mockproject.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fa.mockproject.service.*;
import fa.mockproject.model.*;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("myprofile")
	public String viewAbout(Model model,
			HttpSession session) {
		
		if (session.getAttribute("userid") == null) {
			return "redirect:/LoginPage";
		}
		String id_user = session.getAttribute("userid").toString() ;
		UUID uuid_id_user = UUID.fromString(id_user.trim());
		User user = userService.getUserByID(uuid_id_user);
		model.addAttribute("user", user); 
		
		session.setAttribute("id_User", uuid_id_user); 
		return "content/myprofile";
	}
	
	@PostMapping("/update_profile")
	@ResponseBody
	public ModelAndView updateAddress(
    		@RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String eamil,
            @RequestParam("sex") String sex, 
            HttpSession session) {
		UUID id_user = (UUID)session.getAttribute("id_User");		
		userService.updateUserById(id_user, name, phone, eamil, sex);
		return new ModelAndView(new RedirectView("myprofile")); 
    }
}

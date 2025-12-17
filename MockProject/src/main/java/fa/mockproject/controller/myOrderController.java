package fa.mockproject.controller;

import java.util.ArrayList;
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

import fa.mockproject.model.*;
import fa.mockproject.service.*;

@Controller
public class myOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("myorder")
    public String viewAbout(Model model, @RequestParam(value = "action", required = false) String action, HttpSession session) {
		if (session.getAttribute("userid") == null) {
			return "redirect:/LoginPage";
		}
		String id_user = String.valueOf( session.getAttribute("userid"));
        UUID uuid_id_user = UUID.fromString(id_user.trim());

        if (action == null || action.isEmpty()) {
            ArrayList<Order> listsOrder = orderService.getAllByUserId(uuid_id_user);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        } else if ("all".equals(action)) {
            ArrayList<Order> listsOrder = orderService.getAllByUserId(uuid_id_user);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        } else if ("delivery".equals(action)) {
            String status = "Đang giao";
            ArrayList<Order> listsOrder = orderService.getAllByUserIdAndStatus(uuid_id_user, status);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        } else if ("handling".equals(action)) {
            String status = "Chờ thanh toán";
            ArrayList<Order> listsOrder = orderService.getAllByUserIdAndStatus(uuid_id_user, status);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        } else if ("finish".equals(action)) {
            String status = "Hoàn tất";
            ArrayList<Order> listsOrder = orderService.getAllByUserIdAndStatus(uuid_id_user, status);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        } else if ("canceled".equals(action)) {
            String status = "Bị hủy";
            ArrayList<Order> listsOrder = orderService.getAllByUserIdAndStatus(uuid_id_user, status);
            model.addAttribute("listsOrder", listsOrder);
            return "content/myorder";
        }

        return "content/myorder";
    }

    @GetMapping("/changeStatus")
    @ResponseBody
    public ModelAndView deleteAddress(@RequestParam("orderId") UUID orderId) {
        String status = "Bị hủy";
        orderService.updateStatus(orderId, status);
        return new ModelAndView(new RedirectView("myorder"));
    }
}
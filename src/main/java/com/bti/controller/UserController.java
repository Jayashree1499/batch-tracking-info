package com.bti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bti.dao.UserDao;
import com.bti.dto.Role;
import com.bti.dto.Status;
import com.bti.dto.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	UserDao userdao;

	@GetMapping("/login")
	public ModelAndView getData(HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userdao.findUserByEmailAndPassword(email, password);
		ModelAndView mv = null;
		if (user != null) {
			if (user.getRole() == Role.HR) {
				
			List<User> users	=userdao.userbasedOnRole(Role.TRAINEE);
			
				mv = new ModelAndView("hr.jsp");
				mv.addObject("list", users);
			} else if (user.getRole() == Role.TRAINEE) {
				mv = new ModelAndView("trainee.jsp");
			}
		}
		else {
			mv = new ModelAndView("login.jsp");
		}
		return mv;
	}

}

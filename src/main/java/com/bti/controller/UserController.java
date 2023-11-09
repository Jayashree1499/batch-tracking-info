package com.bti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Autowired
	User user;

	@GetMapping("/login")
	public ModelAndView getData(HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userdao.findUserByEmailAndPassword(email, password);
		ModelAndView mv = null;
		if (user != null) {
			if (user.getRole() == Role.HR) {

				List<User> users = userdao.userbasedOnRole(Role.TRAINEE);

				req.setAttribute("list_1", users);

				mv = new ModelAndView("hr.jsp");
				mv.addObject("list", users);
			} else if (user.getRole() == Role.TRAINEE) {
				mv = new ModelAndView("trainee.jsp");
			}
		} else {
			mv = new ModelAndView("login.jsp");
		}
		return mv;
	}

	@GetMapping("/saveHr")
	public ModelAndView saveHr() {
		user.setName("Hr");
		user.setEmail("hr@alpha.in");
		user.setPassword("123");
		user.setRole(Role.HR);
		user.setStatus(Status.ACTIVE);

		if (userdao.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
			userdao.saveUser(user);
		}
		ModelAndView modelAndView = new ModelAndView("login.jsp");
		return modelAndView;
	}	
	@GetMapping("/st")
	public ModelAndView saveTrainee(HttpServletRequest req) {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password= req.getParameter("password");
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(Role.TRAINEE);
		user.setStatus(Status.ACTIVE);
		userdao.saveUser(user);
		ModelAndView mv= new ModelAndView();
		mv.addObject(user);
		return mv;
	}
      
}

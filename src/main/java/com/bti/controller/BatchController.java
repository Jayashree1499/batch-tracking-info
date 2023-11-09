package com.bti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bti.dao.BatchDao;
import com.bti.dao.UserDao;
import com.bti.dto.Batch;
import com.bti.dto.Role;
import com.bti.dto.Status;
import com.bti.dto.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@Component
public class BatchController {
	@Autowired
	Batch batch;
	@Autowired
	BatchDao batchDao;
	@Autowired
	UserDao userDao;
	
	
	@GetMapping("/savebatch")
	public ModelAndView saveBatch(HttpServletRequest req) {
		int user_id=Integer.parseInt(req.getParameter("userId"))  ;
		String subject=req.getParameter("subject");
		
		batch.setSubject(subject);
		batch.setStatus(Status.CREATED);
		batchDao.saveBatch(batch);
		User user=userDao.findUserById(user_id);
		batch.setUser(user);
		batchDao.updateBatch(batch);
		
		ModelAndView modelAndView=new ModelAndView("");
		
		return modelAndView;
	}
	
	@GetMapping("/displaybatch")
	public ModelAndView displayBatch(HttpServletRequest req) {
		int user_id=Integer.parseInt(req.getParameter("userId"))  ;
        List<Batch> list=batchDao.findBatchByUserId(user_id);
        	req.setAttribute("batchlist", list);
        
		ModelAndView modelAndView=new ModelAndView("viewbatch.jsp");
		   modelAndView.addObject("batchlist",list);
		return modelAndView;
	}
}

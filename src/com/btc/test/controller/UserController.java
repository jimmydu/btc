package com.btc.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.btc.test.dao.UserDao;
import com.btc.test.entity.User;

/**
 */
@Controller
public class UserController {
 
	@Autowired
	UserDao userDao;
	
    @RequestMapping("/hello")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hi, springmvc!");
    }
    
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ModelAndView getUser(@RequestParam(value = "userID", required = false) String userID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userList");
		mav.addObject("userID", userID);
		
		List<User> rs = null;
		
		if(userID!= null && userID.length()>0)
		{
			rs = userDao.selectUser(userID);
		} else {
			rs = userDao.selectUser();
		}
		
		
		mav.addObject("userList", rs);
		
		System.out.println("getUser("+userID+");");
		return mav;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
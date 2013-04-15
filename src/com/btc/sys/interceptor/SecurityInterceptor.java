package com.btc.sys.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.btc.sys.utils.LogUtil;
import com.btc.test.entity.User;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		LogUtil.getLogger().info("......end");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		LogUtil.getLogger().info("------"+req.getRequestURL());
		Enumeration<String> enumeration = req.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			LogUtil.getLogger().info(name+"="+req.getParameter(name));
		}
		LogUtil.getLogger().info(req.getRemoteAddr()+" : "+ req.getRemotePort());
		
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			currentUser = new User();
			currentUser.setId("001");
			currentUser.setAge(28);
			currentUser.setName("jimmy.du");
			currentUser.setGender("m");
			req.getSession().setAttribute("currentUser", currentUser);
		}
		return true;
	}

}

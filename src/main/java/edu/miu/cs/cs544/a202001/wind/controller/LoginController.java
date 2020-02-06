package edu.miu.cs.cs544.a202001.wind.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.a202001.wind.domain.LoginForm;
import edu.miu.cs.cs544.a202001.wind.service.UserServiceImpl;
import edu.miu.cs.cs544.a202001.wind.service.security.SecurityService;
import edu.miu.cs.cs544.a202001.wind.service.security.SecurityServiceImpl;
@RestController
public class LoginController {
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Map<String, Object> login(@ModelAttribute LoginForm loginForm, String logout) {
		Map<String, Object> rtn = new LinkedHashMap<>();
		if (logout != null) {
			rtn.put("success", true);
	    	rtn.put("message", "You have been logged out successfully.");
	    	return rtn;
		}
		
	    try {
	    	securityService.login(loginForm.getUsername(), loginForm.getPassword());
	    	rtn.put("success", true);
	    	rtn.put("message", "logged in");
        } catch (Exception e) {
          	rtn.put("success", false);
	    	rtn.put("message", "authentication failed");
        }
	    return rtn;
	}
	@GetMapping(value = "/permitswagger")
	public Map<String, Object> permitSwagger() {
		Map<String, Object> rtn = new LinkedHashMap<>();
	    try {
	    	securityService.login("admin", "123");
	    	rtn.put("success", true);
	    	rtn.put("message", "logged in");
        } catch (Exception e) {
          	rtn.put("success", false);
	    	rtn.put("message", "authentication.failed");
        }
	    return rtn;
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public Map<String, Object> logout (HttpServletRequest request, HttpServletResponse response) {
//		Map<String, Object> rtn = new LinkedHashMap<>();
//	    try{
//	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	        if (auth != null){    
//		        new SecurityContextLogoutHandler().logout(request, response, auth);
//		    }
//			rtn.put("success", true);
//	    	rtn.put("message", "logout successfully");
//	    }catch(Exception e) {
//	    	rtn.put("success", false);
//	    	rtn.put("message", "failed");
//	    }
//	    return rtn;
//	}

}

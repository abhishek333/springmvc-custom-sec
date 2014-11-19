/**
 * 
 */
package org.asn.springmvc.mvc;

import org.asn.springmvc.core.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Abhishek
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	@RequestMapping(value="/loginerror", method=RequestMethod.GET)
	public String loginerror(Model model){
		
		return "loginerror";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("LOGIN_MODEL", new User());
		return "login";
	}
	
	@RequestMapping(value="/j_security_check", method=RequestMethod.POST)
	public String processLogin(Model model, @ModelAttribute("LOGIN_MODEL")User user, BindingResult result){
		System.out.println("LOGIN post");
		System.out.println(user);
		return "user";
	}
}

/**
 * 
 */
package org.asn.springmvc.mvc;

import org.asn.springmvc.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/loginerror", method=RequestMethod.GET)
	public String loginerror(Model model){
		LOG.info("GET loginerror");
		return "loginerror";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		LOG.info("GET login");
		model.addAttribute("LOGIN_MODEL", new User());
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, @ModelAttribute("LOGIN_MODEL")User user, BindingResult result){
		LOG.info("POST login");
		System.out.println(user);
		return "user";
	}
	
	@RequestMapping(value="/j_security_check", method=RequestMethod.POST)
	public String processLogin(Model model, @ModelAttribute("LOGIN_MODEL")User user, BindingResult result){
		LOG.info("POST j_security_check");
		LOG.debug(user.toString());
		return "user";
	}
}

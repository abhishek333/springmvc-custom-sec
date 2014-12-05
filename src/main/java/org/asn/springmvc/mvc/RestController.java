/**
 * 
 */
package org.asn.springmvc.mvc;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.asn.springmvc.mvc.model.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Abhishek
 *
 */
@Controller
@RequestMapping("/rest/auth")
public class RestController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelAndView login(Model model, @RequestBody LoginModel loginModel, HttpSession session){
		LOG.info("POST came to /rest/auth");
		model.addAttribute("Hi", "Hello");
		session.setAttribute("loggedUser", loginModel.getUsername());
		return new ModelAndView();
	}

	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public @ResponseBody ModelAndView checkLogin(Model model, @RequestBody String param, HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		LOG.info("POST came to /rest/check {}", param);
		  final LinkedHashMap map = new ObjectMapper().readValue(new String(param),LinkedHashMap.class);
		  LOG.debug("param: {}", map.get("param"));
		model.addAttribute("Hi", "Hello");
		LOG.debug("logged User: {}", session.getAttribute("loggedUser"));
		return new ModelAndView();
	}
}

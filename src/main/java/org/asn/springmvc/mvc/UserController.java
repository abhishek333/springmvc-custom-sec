/**
 * 
 */
package org.asn.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Abhishek
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method=RequestMethod.GET)
	public String user(){
		return "user";
	}
}

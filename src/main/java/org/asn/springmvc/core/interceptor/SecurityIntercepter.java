/**
 * 
 */
package org.asn.springmvc.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Abhishek
 *
 */
@Component
public class SecurityIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("URL path: "+request.getServletPath());
		String url = request.getRequestURL().toString();
		if(url.contains("/user")){
			System.out.println("user page");
		}
		if(url.contains("/admin")){
			System.out.println("admin page");
		}
		//String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
		//System.out.println("Base URL: "+baseURL);
		return true;
	}
	
}

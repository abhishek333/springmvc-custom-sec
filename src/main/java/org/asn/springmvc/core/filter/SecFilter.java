/**
 * 
 */
package org.asn.springmvc.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Abhishek
 *
 */
@Component("secFilter")
public class SecFilter implements Filter {

	private final Logger LOG = LoggerFactory.getLogger(getClass());	

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("init filter");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOG.info("doFilter filter");
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
				
		 // wrap around the original request and response
        MyRequestWrapper reqWrap = new MyRequestWrapper(httpServletRequest);
        MyResponseWrapper resWrap = new MyResponseWrapper((HttpServletResponse)response);
        
        // pass the wrappers on to the next entry
		chain.doFilter(reqWrap, resWrap);
		
		String url = httpServletRequest.getRequestURL().toString();
		String responseData = "";
		if(url.contains("/mob")){
			LOG.info("mob channel");
			//get response data from resWrap
			responseData = resWrap.getMobileEncryptedResponseContent();
		}else{
			LOG.info("web channel");
			responseData = resWrap.getWebEncryptedResponseContent();
		}
		
		//write response data to original response
		response.getOutputStream().write(responseData.getBytes());
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		LOG.info("destroy filter");
	}

/*	static class FilteredRequest extends HttpServletRequestWrapper {

    	 These are the characters allowed by the Javascript validation 
    	static String allowedChars = "+-0123456789#*";

    	public FilteredRequest(ServletRequest request) {
    		super((HttpServletRequest)request);
    	}

    	public String sanitize(String input) {
    		String result = "";
    		for (int i = 0; i < input.length(); i++) {
    			if (allowedChars.indexOf(input.charAt(i)) >= 0) {
    				result += input.charAt(i);
    			}
    		}
    		return result;
    	}

    	public String getParameter(String paramName) {
    		String value = super.getParameter(paramName);
    		if ("dangerousParamName".equals(paramName)) {
    			value = sanitize(value);
    		}
    		return value;
    	}

    	public String[] getParameterValues(String paramName) {
    		String values[] = super.getParameterValues(paramName);
    		if ("dangerousParamName".equals(paramName)) {
    			for (int index = 0; index < values.length; index++) {
    				values[index] = sanitize(values[index]);
    			}
    		}
    		return values;
    	}
    }*/
}

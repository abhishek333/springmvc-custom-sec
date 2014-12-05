/**
 * 
 */
package org.asn.springmvc.core.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.input.TeeInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Abhishek
 *
 */
public class MyRequestWrapper extends HttpServletRequestWrapper{

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private final ByteArrayOutputStream bos = new ByteArrayOutputStream();    

    public MyRequestWrapper(HttpServletRequest request) {    	
        super(request);                
        LOG.info("MyRequestWrapper instance created");
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            private TeeInputStream tee = new TeeInputStream(MyRequestWrapper.super.getInputStream(), bos);

            @Override
            public int read() throws IOException {
                return tee.read();
            }
        };
    }

    public byte[] toByteArray(){
        return bos.toByteArray();
    }
}

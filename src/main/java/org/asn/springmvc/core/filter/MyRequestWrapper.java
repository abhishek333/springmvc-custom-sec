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
    private long id;

    public MyRequestWrapper(Long requestId, HttpServletRequest request) {    	
        super(request);        
        this.id = requestId;
        LOG.info("MyRequestWrapper instance created with requestId[{}]", requestId);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

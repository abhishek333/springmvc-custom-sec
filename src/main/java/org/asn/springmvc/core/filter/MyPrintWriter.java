/**
 * 
 */
package org.asn.springmvc.core.filter;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Abhishek
 *
 */
public class MyPrintWriter extends PrintWriter {
	
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	private PrintWriter branch;

    public MyPrintWriter(PrintWriter main, PrintWriter branch) {        
    	super(main, true);
        this.branch = branch;
        LOG.info("MyPrintWriter instance created.");
    }

    public void write(char buf[], int off, int len) {
        super.write(buf, off, len);
        super.flush();
        branch.write(buf, off, len);
        branch.flush();
        LOG.info("write(char buf[], int off, int len).");
    }

    public void write(String s, int off, int len) {
        super.write(s, off, len);
        super.flush();
        branch.write(s, off, len);
        branch.flush();
        LOG.info("write(String s, int off, int len).");
    }

    public void write(int c) {
        super.write(c);
        super.flush();
        branch.write(c);
        branch.flush();
        LOG.info("write(int c).");
    }

    public void flush() {
        super.flush();
        branch.flush();
    }
}

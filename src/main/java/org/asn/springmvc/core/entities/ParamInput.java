/**
 * 
 */
package org.asn.springmvc.core.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Abhishek
 *
 */
@SuppressWarnings("serial")
@Entity
public class ParamInput extends BaseEntity implements Serializable {

	@ManyToOne
	private AuditOperation operation;
	private String paramName;
	private String paramValue;
	
	public ParamInput(){}
	
	public ParamInput(String paramName, String paramValue) {
		super();
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public AuditOperation getOperation() {
		return operation;
	}

	public void setOperation(AuditOperation operation) {
		this.operation = operation;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamInput [paramName=");
		builder.append(paramName);
		builder.append(", paramValue=");
		builder.append(paramValue);
		builder.append("]");
		return builder.toString();
	}
	
	
}

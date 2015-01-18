/**
 * 
 */
package org.asn.springmvc.core.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Abhishek
 *
 */
@SuppressWarnings("serial")
@Entity
public class AuditOperation extends BaseEntity implements Serializable {

	private String name;	
	@OneToMany(mappedBy="operation", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ParamInput> inputs;
	@OneToMany(mappedBy="operation", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ParamOutput> outputs;
	@ManyToOne
	private AuditMaster master;
	
	public AuditOperation(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ParamInput> getInputs() {
		return inputs;
	}

	public void setInputs(Set<ParamInput> inputs) {
		this.inputs = inputs;
	}

	public Set<ParamOutput> getOutputs() {
		return outputs;
	}

	public void setOutputs(Set<ParamOutput> outputs) {
		this.outputs = outputs;
	}

	public AuditMaster getMaster() {
		return master;
	}

	public void setMaster(AuditMaster master) {
		this.master = master;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((inputs == null) ? 0 : inputs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((outputs == null) ? 0 : outputs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AuditOperation))
			return false;
		AuditOperation other = (AuditOperation) obj;
		if (inputs == null) {
			if (other.inputs != null)
				return false;
		} else if (!inputs.equals(other.inputs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (outputs == null) {
			if (other.outputs != null)
				return false;
		} else if (!outputs.equals(other.outputs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuditOperation [name=");
		builder.append(name);
		builder.append(", inputs=");
		builder.append(inputs);
		builder.append(", outputs=");
		builder.append(outputs);
		builder.append("]");
		return builder.toString();
	}
	
	
}

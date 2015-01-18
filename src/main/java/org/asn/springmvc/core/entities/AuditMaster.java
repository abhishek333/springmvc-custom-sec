/**
 * 
 */
package org.asn.springmvc.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Abhishek
 *
 */
@SuppressWarnings("serial")
@Entity
public class AuditMaster extends BaseEntity implements Serializable {

	private String sessionId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date destroyTime;
	@OneToOne(fetch=FetchType.LAZY)
	private User user;
	@Transient
	private Long userId;
	
	@OneToMany(mappedBy="master", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<AuditOperation> operations = new ArrayList<AuditOperation>();
	public AuditMaster(){}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDestroyTime() {
		return destroyTime;
	}

	public void setDestroyTime(Date destroyTime) {
		this.destroyTime = destroyTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<AuditOperation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<AuditOperation> operations) {
		this.operations = operations;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuditMaster [sessionId=");
		builder.append(sessionId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", destroyTime=");
		builder.append(destroyTime);		
		builder.append(", operations=");
		builder.append(operations);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((destroyTime == null) ? 0 : destroyTime.hashCode());
		result = prime * result
				+ ((operations == null) ? 0 : operations.hashCode());
		result = prime * result
				+ ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AuditMaster))
			return false;
		AuditMaster other = (AuditMaster) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (destroyTime == null) {
			if (other.destroyTime != null)
				return false;
		} else if (!destroyTime.equals(other.destroyTime))
			return false;
		if (operations == null) {
			if (other.operations != null)
				return false;
		} else if (!operations.equals(other.operations))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}

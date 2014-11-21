/**
 * 
 */
package org.asn.springmvc.core.domain;


/**
 * @author Abhishek
 *
 */
public class User {

	private Long id;
	private String j_username;
	private String j_password;
	
	public User(){}
	
	public User(Long id, String j_username, String j_password) {
		super();
		this.id = id;
		this.j_username = j_username;
		this.j_password = j_password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJ_username() {
		return j_username;
	}

	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

	public String getJ_password() {
		return j_password;
	}

	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", j_username=");
		builder.append(j_username);
		builder.append(", j_password=");
		builder.append(j_password);
		builder.append("]");
		return builder.toString();
	}
		
}

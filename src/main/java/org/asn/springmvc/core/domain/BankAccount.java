/**
 * 
 */
package org.asn.springmvc.core.domain;

import javax.persistence.Entity;

/**
 * @author Abhishek
 *
 */
@Entity
public class BankAccount extends PaymodeMode {

	private String bankName;
	private String accountNum;
	private String bankCode;
	
	public BankAccount(){}
}

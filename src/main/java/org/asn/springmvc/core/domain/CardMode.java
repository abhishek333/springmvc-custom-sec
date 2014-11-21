/**
 * 
 */
package org.asn.springmvc.core.domain;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author Abhishek
 *
 */
@Entity
public class CardMode extends PaymodeMode{

	private String number;
	private String cvv;
	private Date expiryDate;
	
	public CardMode(){}
}

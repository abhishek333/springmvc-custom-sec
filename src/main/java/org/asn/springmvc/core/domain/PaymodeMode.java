/**
 * 
 */
package org.asn.springmvc.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Abhishek
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PaymodeMode {

	@Id @GeneratedValue
	private Long id;
	
	private String nickName;
	
	public PaymodeMode(){}
}

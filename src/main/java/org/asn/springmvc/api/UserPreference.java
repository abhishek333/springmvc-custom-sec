/**
 * 
 */
package org.asn.springmvc.api;

import java.security.Principal;

import org.asn.springmvc.core.entities.User.USER_ROLE;

/**
 * @author Abhishek
 *
 */
public interface UserPreference extends Principal{
	
	Long getUserId();
	USER_ROLE getAssignedRole();
}

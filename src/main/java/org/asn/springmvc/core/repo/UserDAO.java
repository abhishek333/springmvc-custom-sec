/**
 * 
 */
package org.asn.springmvc.core.repo;

import org.asn.springmvc.core.domain.User;

/**
 * @author Abhishek
 *
 */
public interface UserDAO {

	User findUserByUsername(String username);
	
	User findUserById(Long id);
}

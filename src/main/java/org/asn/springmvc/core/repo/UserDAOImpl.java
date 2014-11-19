/**
 * 
 */
package org.asn.springmvc.core.repo;

import java.util.ArrayList;
import java.util.List;

import org.asn.springmvc.core.domain.User;
import org.asn.springmvc.core.util.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Abhishek
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	private List<User> users = new ArrayList<User>();
	
	@Autowired private Predicate<User> predicate;
	
	public UserDAOImpl(){
		users.add(new User(new Long(1), "Abhishek", "123"));
		users.add(new User(new Long(2), "Abhishek2", "123"));
		users.add(new User(new Long(3), "Abhishek3", "123"));
		users.add(new User(new Long(4), "Abhishek4", "123"));
		users.add(new User(new Long(5), "Abhishek5", "123"));
		
	}
	
	/* (non-Javadoc)
	 * @see org.asn.springmvc.core.repo.UserDAO#findUserByUsername(java.lang.String)
	 */
	@Override
	public User findUserByUsername(String username) {
		
		return predicate.selectByUsername(users, username);
	}

	/* (non-Javadoc)
	 * @see org.asn.springmvc.core.repo.UserDAO#findUserById(java.lang.Long)
	 */
	@Override
	public User findUserById(Long id) {
		return predicate.selectById(users, id);
	}

}

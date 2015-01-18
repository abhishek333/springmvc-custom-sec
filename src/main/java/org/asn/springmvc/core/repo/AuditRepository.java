/**
 * 
 */
package org.asn.springmvc.core.repo;

import org.asn.springmvc.core.entities.AuditMaster;
import org.asn.springmvc.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author Abhishek
 *
 */
public interface AuditRepository extends JpaRepository<AuditMaster, Long>, QueryDslPredicateExecutor<AuditMaster> {
	@Query("SELECT am FROM AuditMaster am JOIN FETCH am.operations op JOIN FETCH op.inputs JOIN FETCH op.outputs WHERE am.sessionId=?1 AND am.user = ?2")
	AuditMaster findBySessionIdAndUser(String sessionid, User user);
	
}

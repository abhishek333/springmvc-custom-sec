/**
 * 
 */
package org.asn.springmvc.mvc.controller;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.asn.springmvc.core.entities.AuditMaster;
import org.asn.springmvc.core.entities.AuditOperation;
import org.asn.springmvc.core.entities.ParamInput;
import org.asn.springmvc.core.entities.ParamOutput;
import org.asn.springmvc.core.entities.User;
import org.asn.springmvc.core.repo.AuditRepository;
import org.asn.springmvc.core.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Abhishek
 *
 */
@Component
public class AuditBuilder {

	private final Logger LOG = LoggerFactory.getLogger(AuditBuilder.class);
	
	@Autowired private AuditRepository repo;
	@Autowired private UserRepository userRepo;
	
	private AuditMaster master;
	private Set<ParamInput> inputs;
	private Set<ParamOutput> outputs;
	private AuditOperation opn;
	//private ObjectMapper mapper = new ObjectMapper();
	
	public AuditBuilder audit(String sesId, long createTime, Long userId){
		this.master = new AuditMaster();
		this.master.setSessionId(sesId);
		this.master.setCreateTime(new Date(createTime));
		this.master.setUserId(userId);	
		return this;
	}
	
	public AuditBuilder newOprn(String name){
		this.opn = new AuditOperation();
		this.opn.setName(name);
		this.opn.setMaster(this.master);		
		return this;
	}
	
	public AuditBuilder in(String paramName, String paramValue){		
		ParamInput in = new ParamInput(paramName, paramValue);		
		if(this.inputs==null){
			this.inputs = new LinkedHashSet<ParamInput>();
		}
		this.inputs.add(in);
		return this;
	}
	
	public AuditBuilder out(String paramName, String paramValue){		
		ParamOutput out = new ParamOutput(paramName, paramValue);		
		if(this.outputs==null){
			this.outputs = new LinkedHashSet<ParamOutput>();
		}
		this.outputs.add(out);
		return this;
	}
	
	public AuditBuilder sessionDestroyed(){
		this.master.setDestroyTime(new Date());
		LOG.debug("session destroy time called..");
		return this;
	}
	
	@Transactional
	public void save(){
		LOG.debug("before save/update:{}", this.master);
		for(ParamInput in: inputs){
			in.setOperation(opn);
		}
		for(ParamOutput out: outputs){
			out.setOperation(opn);
		}
		this.opn.setInputs(inputs);
		this.opn.setOutputs(outputs);
		this.master.getOperations().add(this.opn);
		User user = userRepo.findOne(this.master.getUserId());
		this.master.setUser(user);		
		AuditMaster am = repo.findBySessionIdAndUser(this.master.getSessionId(), user);
		LOG.debug("am: {}", am);
		if(am!=null){
			this.opn.setMaster(am);
			am.getOperations().add(this.opn);
			Date destroyTime = this.master.getDestroyTime();
			if(destroyTime!=null){
				am.setDestroyTime(destroyTime);
			}
			repo.save(am);
			LOG.debug("master update:{}", am);
		}else{
			LOG.debug("master save:{}", this.master);
			repo.save(this.master);
		}
		this.inputs.clear();
		this.outputs.clear();
	}
}

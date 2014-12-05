package org.asn.springmvc.mvc;

 import javax.validation.Valid;

import org.asn.springmvc.core.domain.Member;
import org.asn.springmvc.core.exception.InvalidMemberException;
import org.asn.springmvc.core.repo.MemberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController
{
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
    	LOG.info("GET /");
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.findAllOrderedByName());
        return "index";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model) throws InvalidMemberException
    {
    	LOG.info("POST /");
        if (!result.hasErrors()) {
        	newMember.setId(null);
            memberDao.register(newMember);
            return "redirect:/";
        }
        else {
            model.addAttribute("members", memberDao.findAllOrderedByName());
            return "index";
        }
    }
    
    @RequestMapping(value="/mob/user", method=RequestMethod.GET)
    public String displayMobMembers(Model model) throws InvalidMemberException
    {
    	Member member = new Member();
    	member.setId(null);
    	memberDao.register(member);
    	LOG.info("GET /mob/user");
        model.addAttribute("data", "Abhishek");
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.findAllOrderedByName());
        return "index";
    }
}

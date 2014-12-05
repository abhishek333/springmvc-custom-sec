package org.asn.springmvc.core.repo;

import java.util.List;

import org.asn.springmvc.core.domain.Member;
import org.asn.springmvc.core.exception.InvalidMemberException;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member)throws InvalidMemberException;
}

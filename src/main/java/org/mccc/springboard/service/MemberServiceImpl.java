package org.mccc.springboard.service;

import javax.inject.Inject;

import org.mccc.springboard.domain.MemberVO;
import org.mccc.springboard.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void createMember(MemberVO memberVO) throws Exception {
		memberDAO.createMember(memberVO);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return memberDAO.readMember(userid);
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		memberDAO.updateMember(memberVO);
	}

	@Override
	public void deleteMember(String userid) throws Exception {
		memberDAO.deleteMember(userid);
	}

	@Override
	public boolean loginCheck(MemberVO memberVO) throws Exception {
		MemberVO inquiryMemberVO = memberDAO.readMember(memberVO.getUserid());
		
		//예외처리 하기
		return memberVO.getPassword().equals(inquiryMemberVO.getPassword());
	}

}
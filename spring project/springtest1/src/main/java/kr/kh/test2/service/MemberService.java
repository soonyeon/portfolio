package kr.kh.test2.service;

import kr.kh.test2.vo.MemberVO;

public interface MemberService {

	String selectMemberName(Integer num);

	boolean signup(MemberVO member);

	
	

}

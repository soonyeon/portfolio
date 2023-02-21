package kr.kh.test2.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test2.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num")Integer num);

	int insertMember(@Param("member")MemberVO member);

}
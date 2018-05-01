package exam.member.Service;

import java.util.Date;

import exam.member.DAO.MemberDao;
import exam.member.VO.MemberVo;
import exam.member.VO.RegisterRequest;

public class MemberRegisterServiceImpl implements MemberRegisterService {
	//MemberDao값으로 주입하기 위한 준비
	private MemberDao memberDao;
	
	//메개변수가 없는 생성자 ==> 주입공간 ==> ref
	public MemberRegisterServiceImpl(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		MemberVo member=memberDao.selectByEmail(req.getEmail());
		//요청한 Email값을 member에 저장
		if(member!=null) {
			System.out.println("이미존재");
		}
		MemberVo newMember=new MemberVo(req.getEmail(),req.getPassword(),req.getName(),new Date());
		
		//email~ 날짜까지 VO에 저장값을 가져와서 newMember로 설정
		
		memberDao.insert(newMember); //map 삽입
		
	}
}

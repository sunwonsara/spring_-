package exam.member.Service;

import exam.member.DAO.MemberDao;
import exam.member.VO.MemberVo;

public class ChangePasswordServiceImpl implements ChangePasswordService {
	private MemberDao memberDao;
	//생성자 추가(매개변수 1개) ==> xml에서 주입할 위치
	public ChangePasswordServiceImpl(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		MemberVo member=memberDao.selectByEmail(email);
		if(member==null) {
			System.out.println("존재하지 않음");
		} 
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
		
	}




}

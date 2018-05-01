package exam.member.UI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam.member.DAO.MemberDao;
import exam.member.DAO.MemberDaoImpl;
import exam.member.Service.MemberRegisterService;
import exam.member.Service.MemberRegisterServiceImpl;

public class MemberTest {

	public static void main(String[] args) {
//		MemberDao memberDao = new MemberDaoImpl();
//		MemberRegisterService memberRegisterService=new MemberRegisterServiceImpl(memberDao);
//		MemberUI memberUI=new MemberUI();
//		
//		//주입 ==> setter메서드에 
//		memberUI.setMemberRegisterService(memberRegisterService);
//		memberUI.showMenu();
		
		//스프링으로 빈 생성해서 불러오기
		ApplicationContext ctx=new GenericXmlApplicationContext("member.xml");
		MemberUI memberUI=ctx.getBean("memberUI",MemberUI.class);
		memberUI.showMenu();
		
	}

}

package exam.member.Service;

import java.util.Collection;

import exam.member.DAO.MemberDao;
import exam.member.VO.MemberVo;

public class MemberListPrinterServiceImpl implements MemberListPrinterService {
	private MemberDao memberDao;
	private MemberPrintService memberPrinter;
	
	//생성자 ==> 매개변수 2개 있는 생성자
	public MemberListPrinterServiceImpl(MemberDao memberDao, MemberPrintService memberPrinter) {
		super();
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll() {
		Collection<MemberVo> members = memberDao.selectAll();
		for(MemberVo member:members) {
			memberPrinter.print(member);
		}

	}



}

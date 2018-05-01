package exam.member.UI;

import java.util.Scanner;

import exam.member.Service.ChangePasswordService;
import exam.member.Service.MemberListPrinterService;
import exam.member.Service.MemberRegisterService;
import exam.member.VO.RegisterRequest;

public class MemberUI {
	//Ui --> 서비스로 연결 --> setter메서드로 주입
	MemberRegisterService memberRegisterService;
	
	//UI -> 출력하기 => setter메서드를 주입하기 위해서 추가
	MemberListPrinterService memberListPrinterService;
	
	//UI -> 변경하기 => setter메서드를 주입하기 위해서 추가
	ChangePasswordService changePasswordService;
	
	
	//기본생성자 만들기
	public MemberUI() {
		
	}
	
	//setter메서드 추가
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	//출력하기 위한 setter메서드 추가
	public void setMemberListPrinterService(MemberListPrinterService memberListPrinterService) {
		this.memberListPrinterService = memberListPrinterService;
	}

	//변경하기 위한 setter메서드 추가
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	//메서드 추가 => 메뉴 목록을 만들기 위한
	//new 이메일 이름 비번 비번1
	public void showMenu() {
		Scanner scan=new Scanner(System.in);
		String command="";
		while(true) {
			System.out.println("명령어를 입력하세요>>");
			command=scan.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}else if(command.toLowerCase().startsWith("new")) {
				//new 라는 명령어 들어오고 공백을 기준으로 메서드 호출
				processNewCommand(command.split(" "));
				continue;
			}else if(command.toLowerCase().startsWith("list")) {
				processListCommand(); //list처리할 메서드
				continue;
			}else if(command.toLowerCase().startsWith("change")) {
				processChangeCommand(command.split(""));
				continue;
			}
		}
	}
	


	private void processChangeCommand(String[] args) {
		if(args.length!=4) {
			return;
		}
		try {
		changePasswordService.changePassword(args[1],args[2],args[3]);
		System.out.println("암호를 변경했습니다");
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
	}

	private void processListCommand() {
		memberListPrinterService.printAll();
	}

	private void processNewCommand(String[] args) {
		if(args.length !=5) {
			return;
		}
		//vo에 사용자가 요청한 정보
		RegisterRequest req=new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("일치하지 않음");
			return;
		}else {
			memberRegisterService.regist(req);
			System.out.println("성공");
			
		}
		
	}
	
}

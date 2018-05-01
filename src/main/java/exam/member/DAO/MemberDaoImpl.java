package exam.member.DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exam.member.VO.MemberVo;

public class MemberDaoImpl implements MemberDao {
	//메서드의 역할 부여
	
	private static long nextId=0; //정적(클래스멤버)
	private Map<String, MemberVo> map = new HashMap<String, MemberVo>(); //데이터 저장할때, 조회하거나...
	
	public MemberVo selectByEmail(String Email) {
		return map.get(Email);
		//Email 키에 대한 값 얻기
	}

	public void insert(MemberVo member) {
		member.setId(++nextId); //등록되는 id값 설정 -->1,2,3 ...
		map.put(member.getEmail(),member);
		//map에 값 추가 삽입
	}

	public void update(MemberVo member) {
		map.put(member.getEmail(),member);

	}

	public Collection<MemberVo> selectAll() {
		return map.values(); //map에 있는 값 모두 출력
	}

}

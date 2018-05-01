package exam.member.DAO;

import java.util.Collection;
import exam.member.VO.MemberVo;

public interface MemberDao {
//1> email을 기준으로 조회
	public MemberVo selectByEmail(String Email);
//2> insert
	public void insert(MemberVo member);
//3> update
	public void update(MemberVo member);
//4> 전체 조회
	public Collection<MemberVo> selectAll();
}

package practice.spring.lguplusspringeducation.chap08.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public Long regist(RegisterRequest req) {
		Member member = this.memberDao.selectByEmail(req.getEmail());

		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		this.memberDao.insert(newMember);
		
		return newMember.getId();
	}
}

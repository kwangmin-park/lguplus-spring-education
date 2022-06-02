package practice.spring.lguplusspringeducation.chap03.exam5.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

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

package practice.spring.lguplusspringeducation.chap03.exam1.spring;

public class ChangePasswordService {

	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);
		this.memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}

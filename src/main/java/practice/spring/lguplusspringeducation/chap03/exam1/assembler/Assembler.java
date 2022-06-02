package practice.spring.lguplusspringeducation.chap03.exam1.assembler;

import practice.spring.lguplusspringeducation.chap03.exam1.spring.ChangePasswordService;
import practice.spring.lguplusspringeducation.chap03.exam1.spring.MemberDao;
import practice.spring.lguplusspringeducation.chap03.exam1.spring.MemberRegisterService;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}

package practice.spring.lguplusspringeducation.chap03.exam2.config;

import practice.spring.lguplusspringeducation.chap03.exam2.spring.MemberRegisterService;
import practice.spring.lguplusspringeducation.chap03.exam2.spring.ChangePasswordService;
import practice.spring.lguplusspringeducation.chap03.exam2.spring.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao(){
		System.out.println("new MemberDao.\n");
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc(){
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePwdSve(){
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}

}

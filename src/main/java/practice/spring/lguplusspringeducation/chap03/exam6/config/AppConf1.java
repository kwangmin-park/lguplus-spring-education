package practice.spring.lguplusspringeducation.chap03.exam6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import practice.spring.lguplusspringeducation.chap03.exam6.spring.ChangePasswordService;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberRegisterService;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberDao;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberPrinter;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberListPrinter;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberInfoPrinter;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.VersionPrinter;

@Configuration
public class AppConf1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

}

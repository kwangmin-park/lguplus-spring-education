package practice.spring.lguplusspringeducation.chap03.exam6.config;

import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberDao;
import practice.spring.lguplusspringeducation.chap03.exam6.spring.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConf2.class)
public class AppConfImport {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
}

package practice.spring.lguplusspringeducation.chap08.config;

import practice.spring.lguplusspringeducation.chap08.spring.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppCtx {


    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(dataSource());
        return dstm;
    }

    @Bean
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring5fs?characterEncoding=utf-8");
        ds.setUsername("spring5");
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMinEvictableIdleTimeMillis(1000*60*3);
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);

        return ds;
    }
    @Bean
    public MemberDao memberDao(){
        System.out.println("new MemberDao.\n");
        return new MemberDao(dataSource());
    }


    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSve(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
//        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//        memberInfoPrinter.setPrinter(memberPrinter());
//        memberInfoPrinter.setMemberDao(memberDao());
        return memberInfoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(1);
        return versionPrinter;
    }


}

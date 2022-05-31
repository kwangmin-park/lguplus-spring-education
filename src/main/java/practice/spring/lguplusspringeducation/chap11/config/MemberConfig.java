package practice.spring.lguplusspringeducation.chap11.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import practice.spring.lguplusspringeducation.chap11.spring.*;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor
public class MemberConfig {
	
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
//		dstm.setDataSource(dataSource());
//		return dstm;
//	}

//	@Bean
//	public DataSource dataSource() {
//		DataSource ds = new DataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
//		ds.setUsername("spring5");
//		ds.setPassword("spring5");
//		ds.setInitialSize(2);
//		ds.setMaxActive(10);
//		ds.setMinEvictableIdleTimeMillis(60000 * 3);
//		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
//
//		return ds;
//	}

	private final MemberDao memberDao;

	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao);
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		return pwdSvc;
	}


}

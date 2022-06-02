package practice.spring.lguplusspringeducation.chap06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import practice.spring.lguplusspringeducation.chap06.spring.Client;
import practice.spring.lguplusspringeducation.chap06.spring.Client2;

@Configuration
public class AppCtx {

	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host1");
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host2");
		return client;
	}
}

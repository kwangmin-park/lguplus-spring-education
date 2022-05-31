//package practice.spring.lguplusspringeducation.chap09.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
////spring container 설정 클래스
//@Configuration
////spring mvc 기본 구성
//@EnableWebMvc
//WebMvcConfigurer는 JDK8에서 제공하는 디폴트메서드를 사용하여 인터페이스의 메서드에 기본 구현을 제공한다
//public class config implements WebMvcConfigurer {
////spring mvc개벌 설정을 override를 통해 개별 설정
//
////    정적 리소스는 서버가 담당할 필요없으므로 아래의 handler가 담당
////    default servlet 을 위한 요청 URL 분석 및 매핑
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//        configurer.enable();
//    }
//
////view 구성을 위한 설정
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry){
//        registry.jsp("/WEB_INF/view/", ".jsp");
//    }
//}

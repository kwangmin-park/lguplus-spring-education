package practice.spring.lguplusspringeducation.chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1.greet("스프링"));

//        싱글톤 테스트
//        Greeter g2 = ctx.getBean("greeter", Greeter.class);
//        System.out.println("(g1 == g2) = " + (g1 == g2));
        ctx.close();
    }
}

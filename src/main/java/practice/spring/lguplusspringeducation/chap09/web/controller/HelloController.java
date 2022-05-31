package practice.spring.lguplusspringeducation.chap09.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

//    GetMapping("/hello") 의 정보가 HandlerMapping에 저장되고, 사용자가 요청을 했을때 해당 정보를 통해 HandlerMapping에서 등록된
//    Controller 정보를 찾아 HandlerAdapter가 찾은 정보를 통해 해당하는 controller의 model 로직이 수행된다.
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required = false) String name){
        model.addAttribute("greeting", "안녕하세요, " + name);
        return "hello";
    }
}

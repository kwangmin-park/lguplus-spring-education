package practice.spring.lguplusspringeducation.chap11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.spring.lguplusspringeducation.chap11.spring.DuplicateMemberException;
import practice.spring.lguplusspringeducation.chap11.spring.MemberRegisterService;
import practice.spring.lguplusspringeducation.chap11.spring.RegisterRequest;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final MemberRegisterService memberRegisterService;

    @RequestMapping("/register/step1")
    public String handleStep1(){
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value="agree", defaultValue = "false") Boolean agree){
        if(!agree){
            return "redirect:/register/step1";
        }
        return "register/step2";
    }

//    forward VS redirection
    @GetMapping("/register/step2")
    public String handleStep2Get(){
        return "redirect:/register/step1";
    }

    @RequestMapping("/main")
    public String handleMainGet(){
        return "main";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq){
        try{
            memberRegisterService.regist(regReq);
//            model.addAttribute("registerRequest", regReq);
            return "register/step3";
        }catch (DuplicateMemberException ex){
            return "register/step2";
        }
    }
}

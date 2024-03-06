package com.example.encoreSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
@RequestMapping(path, method)
-- GetMapping
-- PostMapping
*/

@Controller
public class TestController {

    // 기본은 / 임.
    // http://server_ip:port/
    // return type : void, String, Model, ModelAndView : full browsing
    // return tyoe : xxxxDTO, List, Map,Set, ResponseEntity : REST API Service
    // 반환 타입을 String 으로 하는게 제일 보편적


    @RequestMapping("/")
    public String index(){
        System.out.println(" >>>> TestController path / , callback function ");
        // application.properties에, jsp 의 기본 경로와 확장자를 지정해주었기 때문에,
        // jsp의 이름만 주면, index.jsp 의 경로를 알아서 찾아줌.
        return "index";
    }

    public String index(Model model){
        System.out.println(">>>. TestController path / , callback function ");
        model.addAttribute("msg", "ddddd");
        return "index";
    }
    /*
    @RequestMapping("/")
    public ModelAndView index() {
        System.out.println(">>> TestController path / , callback function index()");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("msg", "hi~, JSP");
        return mv;
    }
    */
    /*
    @RequestMapping("/")
    public String index(Model model) {
    model.addAllAttributes("msg", "welcome to SpringBoot With JSP");
    return "index";
}
    @RequestMapping("/test")
    public void test() {
        System.out.println(">>> TestController path / test, callback function");
    }
     */

}

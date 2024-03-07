package com.example.encoreSpring.controller;

import com.example.encoreSpring.domain.BoardResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/*
HTTP ( 404 -> NOT FOUND, 405 -> BAD REQUEST, 500 -> NPE(개발자 잘못)
@RequestMapping(path, method)
-- GetMapping(<a href="">)
-- PostMapping(<form action="" method="get|post">)

@RestController ( json + async )         ,,, 비동기 통신
@Controller ( full browsing, rest API - @ResponseBody )
*/

@Controller
public class TestController {

    // 기본은 / 임.
    // http://server_ip:port/
    // return type : void, String, Model, ModelAndView : full browsing
    // return tyoe : xxxxDTO, List, Map,Set, ResponseEntity : REST API Service
    // 반환 타입을 String 으로 하는게 제일 보편적
/*

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

    // 브라우저에서 url 을 직접 쳤을 때, 화면이 나올거면, @GetMapping을 해줘야 함.
    // 반환값을 받게 되면, @ResponseBody 어노테이션을 통해, json 파일을 반환해줌.
    // 프론트, 서버를 고려하면, json 파일로 반환해주어야 함.

    /*
    @GetMapping("/json")
    @ResponseBody
    public List<BoardResponse> json(){
        System.out.println(">>> TestController path / test, callback function");
        BoardResponse board = BoardResponse.builder()
                .title("json data")
                .content("json content")
                .writer("encore")
                .build();
        List<BoardResponse> lst = new ArrayList<>();
        lst.add(board);
        lst.add(board);
        lst.add(board);
        lst.add(board);
        lst.add(board);
        return lst;

     */


}

package com.example.encoreSpring.controller.user;

import com.example.encoreSpring.domain.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user") // http:// server ip : port /user
public class UserController {
/*
 jsp 파일에서, user 경로로 들어오게 되고, index.jsp 파일에 따라, log in 버튼을 누르게 되면
 user/login.hanwha 로 매핑 되고, 여기에서, list.jsp 로 화면을 출력하게 된다.
*/

// 이게 가장 이상적인 방법, orm 도 생각해야 하기 때문에, UserRequest 자체를 받는게 맞음.
// loginService(UserRequest request); ---> ?? 맞나.
// 컨트롤 단에서는 요청을 하나 받아야 함.
    @PostMapping("login.hanwha")
    public String login(UserRequest params){
        System.out.println("debug UserController client path /user/login.hanwha");
        System.out.println("param value >>> " + params.getId());
        System.out.println("param value >>> " + params.getPwd());
        // 보통은 forward  방식으로 쓰지만, 상황에 따라, redirect 방식을 써야한다.
        /*
        // forward 방식
        return "list";
        */

        // redirect 방식 ( 사용자가 처음 요청한 url 이 아닌, 다른 url 로 넘어가게 함. )
        return "redirect:/board/list.hanwha";

    }

    // 프론트 단에서, validation 작업이 이루어지지 않았을 때, 쓰는 코드
    // 이 코드로 백엔드 단에서 validation 을 잡아야 함.
    /*
    public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pwd") String pwd){
        System.out.println("debug UserController client path /user/login.hanwha");
        System.out.println("param value >>> " + id);
        System.out.println("param value >>> " + pwd);
        return "list";
        // 만약, board 폴더 밑에 list가 있으면,
        // return "/board/list"
    }
     */
}

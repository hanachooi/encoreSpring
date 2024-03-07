package com.example.encoreSpring.controller.board;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import com.example.encoreSpring.service.BoardService;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")   // http:// serverip : port / board
public class BoardController {


    // 상속을 받은 클래스를 의존성 주입 할 때는, @Resource(name = "board")를 해야 함.
    @Resource(name = "board")
    private BoardService service;

    @RequestMapping("/list.hanwha")
    //@ResponseBody       // ResponseBody는 jsp 로 바꿔 주는 역할임.
    public String list(){
        System.out.println("BoardController.list");

        /*
         BoardServiceImpl listBoard() 메서드 호출하여 결과를 반환 받고
         반환받은 결과를 Model(requestScope) 심고 이 데이터를 forward 되는 페이지에서 출력
         forward 되는 페이지를 출력
        */
        List<BoardResponse> list = service.listBoard();

        // "list" 면, jsp 반환이고, list면 그냥 list 반환임
        return "list";

    }
    /*
    @GetMapping("/view.hanwha")
    public String hanWha(BoardRequest params){
        System.out.println("BoardController.hanWha");
        System.out.println("param Idx = " + params.getIdx());
        return "view";
    }
*/
    /*
    @GetMapping("/view.hanwha/{idx}")
    public String hanWha2(@PathVariable("idx") Integer idx){
        System.out.println("BoardController.hanWha");
        System.out.println("param Idx = " + idx);

        return null;
    }
     */

    @GetMapping("/view.hanwha")
    public String view(BoardRequest params, Model model){

        /* View(뷰)로부터 키(idx) 값을 전달받고
        객체로 바인딩된 후, service에 전달
        response 객체를 반환받고 해당 response 객체를 Model 에 심어서
        View 페이지로 전달 과정 수행
        */
        System.out.println("debug BoardController Client path /board/view.hanwha");
        System.out.println(params.getIdx());
        BoardResponse response = service.findBoard(params);
        model.addAttribute("response", response);

        return "view";
    }

    @GetMapping("/write.hanhwa")
    public String writeForm(){
        System.out.println("BoardController.writeForm");
        return "write";
    }

}

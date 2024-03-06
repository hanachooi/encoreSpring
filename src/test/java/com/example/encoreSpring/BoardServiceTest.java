package com.example.encoreSpring;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import com.example.encoreSpring.service.BoardService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class BoardServiceTest {

    // 상속을 받을 때는, 그냥, @Autowired를 하면 안됌.
    @Resource(name = "board")
    private BoardService service;

    // 같은 서비스를 받고, 해당 서비스가 mapper랑 연결이 되므로, 하나의 디비를 관리할 수 있게 됌.
    @Test
    public void serviceSaveTest(){

        System.out.println("debug Test -> " + service);

        /* // builder 패턴을 사용하지 않을 경우 -> 생성자 이용
        BoardRequest request = new BoardRequest();
        request.setTitle("service 수업");
        request.setContent("service를 이용한 mapper 연결");
        request.setWriter("encore");
        request.setNoticeYN(true);
        request.setSecretYN(true);
        */

        BoardRequest request = BoardRequest.builder()
                .title("service 수업")
                .content("null")
                .writer("encore")
                .noticeYN(true)
                .secretYN(true)
                .build();

        System.out.println(request);
        Integer idx = service.saveBoard(request);
        System.out.println("입력한 데이터의 키 값을 출력 : " + idx);

    }

    @Test
    public void serviceDeleteBoardTest(){

        System.out.println("Delete Test -> " + service);
        BoardRequest request = BoardRequest.builder()
                .idx(2).build();
        // 인덱스를 기준으로 삭제가 이루어짐.
        //request.setIdx(2);
        service.deleteBoard(request);

    }

    @Test
    public void serviceUpdateBoardTest(){

        System.out.println("Update Test -> " + service);
        /*BoardRequest request = new BoardRequest();
        // 업데이트는 idx를 기준으로 이루어진다.
        request.setIdx(4);
        request.setTitle("ddd");
        request.setContent("ddd");
        request.setWriter("ddd");
         */
        BoardRequest request = BoardRequest.builder()
                .idx(4)
                .title("ddd")
                .content("ddd")
                .writer("ddd")
                .build();
        service.updateBoard(request);

    }

    @Test
    public void serviceListBoardTest(){

        System.out.println("ListBoard Test -> " + service);
        List<BoardResponse> list =  service.listBoard();

        for(BoardResponse r : list ){
            System.out.println(r.toString());
        }

    }

    @Test
    public void serviceFindBoardTest(){

        System.out.println("FindBoard Test -> " + service);
        BoardRequest request = BoardRequest.builder().idx(3).build();
        BoardResponse response = service.findBoard(request);
        System.out.println(response.toString());

    }

    @Test
    public void serviceCountBoardTest(){

        System.out.println("Count Board Test -> " + service);
        System.out.println(service.cntBoard());

    }

}

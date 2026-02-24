package org.example.back02.board;

import lombok.RequiredArgsConstructor;
import org.example.back02.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 각각 컨트롤러 마다 작성을 해야 한다.
// 각각 사이트마다 설정을 해줄 수 있다.
@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true"
)


@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody BoardDto.Boardreq dto){
        boardService.save(dto);
        return ResponseEntity.ok("성공");
    }

}

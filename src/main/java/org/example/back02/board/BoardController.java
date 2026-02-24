package org.example.back02.board;

import lombok.RequiredArgsConstructor;
import org.example.back02.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/save")
    public ResponseEntity save(BoardDto.Boardreq dto){
        boardService.save(dto);
        return ResponseEntity.ok("성공");
    }

}

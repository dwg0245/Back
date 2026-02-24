package org.example.back02.board;

import lombok.RequiredArgsConstructor;
import org.example.back02.model.Board;
import org.example.back02.model.BoardDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto.Boardreq dto) {
        boardRepository.save(dto.toEntity());
    }

    // 게시글 목록 조회
    public List<BoardDto.BoardList> findAll() {
        List<Board> result = boardRepository.findAll();
        List<BoardDto.BoardList> boardLists = new ArrayList<>();

        for(Board data: result){
            boardLists.add(BoardDto.BoardList.from(data));
        }

        return boardLists;
    }
}

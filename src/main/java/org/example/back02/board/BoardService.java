package org.example.back02.board;

import lombok.RequiredArgsConstructor;
import org.example.back02.model.Board;
import org.example.back02.model.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    // 게시글 저장
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

    // 게시글 상세 조회
    public BoardDto.BoardList findByIdx(Long idx) {
        Optional<Board> result = boardRepository.findById(idx);

        if(result.isPresent()){
            Board dto = result.get();
            return BoardDto.BoardList.from(dto);
        }
        return null;
    }

    // 게시글 업데이트

    public void boardUpdate(Long idx,BoardDto.BoardUpdate dto) {
        Optional<Board> result = boardRepository.findById(idx);

        Board resultData = result.get();

        resultData.setTitle(dto.getTitle());
        resultData.setContents(dto.getContents());

        boardRepository.save(resultData);
    }
}

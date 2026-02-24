package org.example.back02.board;

import lombok.RequiredArgsConstructor;
import org.example.back02.model.BoardDto;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto.Boardreq dto) {
        boardRepository.save(dto.toEntity());
    }
}

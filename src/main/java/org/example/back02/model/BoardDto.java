package org.example.back02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {

    // 게시글 작성
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Boardreq{
        private String title;
        private String contents;

        public Board toEntity(){
            return Board.builder()
                    .tilte(this.title)
                    .contents(this.contents)
                    .build();
        }
    }
}

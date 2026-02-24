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
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    // 게시글 목록 조회
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class BoardList{
        private Long idx;
        private String title;
        private String contents;

        public static BoardList from(Board entity){
            return BoardList.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }
}

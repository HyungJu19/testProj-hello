package com.testproj.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Post {



    private Long postId;
    private Long userId;           //User 도메인과 연결할id fk
    @NotEmpty(message = "제목 필수입력.")
    private String subject;        //글제목
    @NotEmpty(message = "내용 필수입력.")
    private String content;         //글내용
    private String attachment;      //첨부파일명
    @NotNull(message = "공개여부 필수입력.")
    private String visibility;       //공개여부
    public class VisibilityConstants {
        public static final String PUBLIC = "PUBLIC";      //전체보기
        public static final String FRIENDS = "FRIENDS";     //친구만보기
        public static final String PRIVATE = "PRIVATE";     //나만보기
    }



    // 게시판 카테고리를 나타내는 필드 추가

    private String category; // 'FESTIVAL_TRAVEL', 'AGE_BASED_TRAVEL' 등
    // 카테고리를 정의하는 이너 클래스
    public static class Category {
        public static final String FESTIVAL_TRAVEL = "FESTIVAL_TRAVEL";
        public static final String AGE_BASED_TRAVEL = "AGE_BASED_TRAVEL";
        public static final String FAMILY_TRAVEL = "FAMILY_TRAVEL";
        public static final String FOODIE_TRAVEL = "FOODIE_TRAVEL";
        // 기타 카테고리...
    }

    @JsonIgnore
    private LocalDateTime regDate;   //게시날짜
}


package com.kh.jpa.dto;

import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

public class NoticeDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        private String notice_title;
        private String notice_content;
        private String user_id;

        public Notice toEntity(Member member) {
            return Notice.builder()
                    .noticeTitle(notice_title)
                    .noticeContent(notice_content)
                    .member(member)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        private String notice_title;
        private String notice_content;
    }

    @Getter
    @Builder
    public static class Response {
        private final Long notice_no;
        private final String notice_title;
        private final String notice_content;
        private final String writer_name;
        private final LocalDateTime create_date;

        public static Response toDto(Notice notice) {
            return Response.builder()
                    .notice_no(notice.getNoticeNo())
                    .notice_title(notice.getNoticeTitle())
                    .notice_content(notice.getNoticeContent())
                    .writer_name(notice.getMember().getUserName())
                    .create_date(notice.getCreateDate())
                    .build();
        }
    }
}

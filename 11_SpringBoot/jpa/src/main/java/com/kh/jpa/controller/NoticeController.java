package com.kh.jpa.controller;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.dto.NoticeDto;
import com.kh.jpa.service.NoticeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // 공지 등록
    @PostMapping
    public ResponseEntity<Long> addNotice(@RequestBody NoticeDto.Create createDto) {
        Long noticeNo = Long.valueOf(noticeService.createNotice(createDto));
        return ResponseEntity.ok(noticeNo);
    }

    // 공지 단일 조회
    @GetMapping("/{noticeNo}")
    public ResponseEntity<NoticeDto.Response> getNotice(@PathVariable Long noticeNo) {
        return ResponseEntity.ok(noticeService.findNotice(noticeNo));
    }

    // 전체 공지 조회
    @GetMapping
    public ResponseEntity<List<NoticeDto.Response>> getAllNotices() {
        return ResponseEntity.ok(noticeService.findAllNotices());
    }

    // 공지 수정
    @PutMapping("/{noticeNo}")
    public ResponseEntity<NoticeDto.Response> updateNotice(
            @PathVariable Long noticeNo,
            @RequestBody NoticeDto.Update updateDto) {
        return ResponseEntity.ok(noticeService.updateNotice(noticeNo, updateDto));
    }

    // 공지 삭제
    @DeleteMapping("/{noticeNo}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeNo) {
        noticeService.deleteNotice(noticeNo);
        return ResponseEntity.ok().build();
    }

    // 제목으로 공지사항 검색
    @GetMapping("/search/title")
    public ResponseEntity<List<NoticeDto.Response>> searchNoticeByTitle(@RequestParam String title) {
        return ResponseEntity.ok(noticeService.findByTitle(title));
    }
}

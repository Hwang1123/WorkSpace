package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.dto.NoticeDto;
import com.kh.jpa.entity.Member;

import java.util.List;

public interface NoticeService {
    String createNotice(NoticeDto.Create createDto);
    NoticeDto.Response findNotice(Long noticeNo);
    List<NoticeDto.Response> findAllNotices();
    NoticeDto.Response updateNotice(Long noticeNo, NoticeDto.Update updateDto);
    void deleteNotice(Long noticeNo);
    List<NoticeDto.Response> findByTitle(String title);


}

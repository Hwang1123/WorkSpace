package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.dto.NoticeDto;
import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Notice;
import com.kh.jpa.repository.MemberRepository;
import com.kh.jpa.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;

    @Override
    public String createNotice(NoticeDto.Create createDto) {
        Member member = memberRepository.findOne(String.valueOf(createDto.getUser_id()))
                .orElseThrow(() -> new NoSuchElementException("작성자 정보가 없습니다."));

        Notice notice = createDto.toEntity(member);
        noticeRepository.save(notice);
        return String.valueOf(notice.getNoticeNo());
    }

    @Override
    public NoticeDto.Response findNotice(Long noticeNo) {
        Notice notice = noticeRepository.findOne(noticeNo)
                .orElseThrow(() -> new NoSuchElementException("해당 공지를 찾을 수 없습니다."));
        return NoticeDto.Response.toDto(notice);
    }

    @Override
    public List<NoticeDto.Response> findAllNotices() {
        return noticeRepository.findAll().stream()
                .map(NoticeDto.Response::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public NoticeDto.Response updateNotice(Long noticeNo, NoticeDto.Update updateDto) {
        Notice notice = noticeRepository.findOne(noticeNo)
                .orElseThrow(() -> new NoSuchElementException("해당 공지를 찾을 수 없습니다."));
        notice.updateNoticeInfo(updateDto.getNotice_title(), updateDto.getNotice_content());
        return NoticeDto.Response.toDto(notice);
    }

    @Override
    public void deleteNotice(Long noticeNo) {
        Notice notice = noticeRepository.findOne(noticeNo)
                .orElseThrow(() -> new NoSuchElementException("해당 공지를 찾을 수 없습니다."));
        noticeRepository.delete(notice);
    }

    @Override
    public List<NoticeDto.Response> findByTitle(String title) {
        return noticeRepository.findByTitle(title).stream()
                .map(NoticeDto.Response::toDto)
                .collect(Collectors.toList());
    }
}

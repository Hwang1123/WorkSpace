package com.kh.board.service;

import com.kh.board.entity.Board;
import com.kh.board.mapper.BoardMapper;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() { return boardMapper.findAll(); }

    @Override
    public void insertBoard(String title, String userId, String contents, MultipartFile upfile) {
        String fileName = null;
        if (upfile != null && !upfile.isEmpty()) {
            fileName = upfile.getOriginalFilename();
            // 실제 서버에 저장하는 로직은 생략하거나, /resources/static/upload에 저장 가능
        }

        Board board = new Board(
                null, title, contents, fileName, userId,
                LocalDateTime.now(), LocalDateTime.now()
        );

        boardMapper.insertBoard(board);
    }
}
package com.kh.board.service;

import com.kh.board.entity.Board;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    List<Board> findAll();

    void insertBoard(String title, String userId, String contents, MultipartFile upfile);
}
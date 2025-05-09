package com.kh.board.controller;

import com.kh.board.controller.dto.response.BoardResponse;
import com.kh.board.entity.Board;
import com.kh.board.mapper.BoardMapper;
import com.kh.board.service.BoardService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //게시글목록을 가져오는 api
    @GetMapping
    public ResponseEntity<List<BoardResponse.SimpleDTO>> getBoardList() {
        List<Board> boardList = boardService.findAll();

        List<BoardResponse.SimpleDTO> result = new ArrayList<>();
        for (Board board : boardList) {
            result.add(BoardResponse.SimpleDTO.formEntity(board));
        }
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insertBoard(
            @RequestParam("title") String title,
            @RequestParam("userId") String userId,
            @RequestParam("contents") String contents,
            @RequestParam(value = "upfile", required = false) MultipartFile upfile
    ) {
        boardService.insertBoard(title, userId, contents, upfile);
        return new ResponseEntity<>("글 등록 완료", HttpStatus.CREATED);
    }

}
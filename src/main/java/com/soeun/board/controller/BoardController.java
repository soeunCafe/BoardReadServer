package com.soeun.board.controller;

import com.soeun.board.config.SecurityService;
import com.soeun.board.model.BoardDto;
import com.soeun.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    SecurityService securityService;

    @Autowired
    BoardDto boardDto;


    //    전체 게시물 조회
    @GetMapping
    public List<BoardDto> selectCategory() {

        return boardService.selectBoard();
    }

    // 게시판 조회
    @GetMapping("/{cafeid}/{categoryid}")
    public List<BoardDto> getBoard(@PathVariable Integer cafeid, @PathVariable Integer categoryid) {
        // 토큰에서 아이디 가져오기
        boardDto.setUserid(securityService.getIdAtToken());
        //boardrDto.setUsername(securityService.getIdAtToken());
        //boardrDto.setUserimg(securityService.getIdAtToken());
        return boardService.getBoard(cafeid,categoryid);
    }

    // 게시물 조회
    @GetMapping("/{cafeid}/{categoryid}/{Id}")
    public BoardDto getBoard2(@PathVariable Integer cafeid, @PathVariable Integer categoryid, @PathVariable Integer Id){
        boardDto.setUserid(securityService.getIdAtToken());
        return boardService.getBoard2(cafeid,categoryid,Id);
    }

}

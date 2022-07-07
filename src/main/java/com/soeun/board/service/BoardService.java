package com.soeun.board.service;

import com.soeun.board.model.BoardDto;
import com.soeun.board.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;


    //    전체 게시물 조회
    public List<BoardDto> selectBoard() {
        return boardMapper.findAll();
    }


    // 게시물 조회
    public List<BoardDto> getBoard(Integer cafeid, Integer categoryid) {
        return (List<BoardDto>) boardMapper.findByCafeidAndCategoryid(cafeid,categoryid);
        //.orElseThrow(IllegalArgumentException::new);
    }

    public BoardDto getBoard2(Integer cafeid, Integer categoryid, Integer Id) {
        return (BoardDto) boardMapper.findByCafeidAndCategoryidAndId(cafeid,categoryid,Id).orElseThrow(IllegalArgumentException::new);
    }


}

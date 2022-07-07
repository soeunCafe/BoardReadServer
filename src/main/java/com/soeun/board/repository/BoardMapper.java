package com.soeun.board.repository;

import com.soeun.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface BoardMapper extends JpaRepository<BoardDto, Integer>{

    List<BoardDto> findByCafeidAndCategoryid(Integer cafeid, Integer categoryid);

    Optional<Object> findByCafeidAndCategoryidAndId(Integer cafeid, Integer categoryid, Integer Id);
}

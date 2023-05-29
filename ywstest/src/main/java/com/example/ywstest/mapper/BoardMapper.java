package com.example.ywstest.mapper;

import com.example.ywstest.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insertOne(BoardDto board);
    int updateOne(BoardDto board);
    int deleteOne(BoardDto board);
    BoardDto findByCId(String borad);
}

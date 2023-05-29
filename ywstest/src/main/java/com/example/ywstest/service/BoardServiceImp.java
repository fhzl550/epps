package com.example.ywstest.service;

import com.example.ywstest.dto.BoardDto;
import com.example.ywstest.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImp implements BoardService{
    private BoardMapper boardMapper;

    @Override
    public BoardDto detail(String cId) {
        BoardDto detail=boardMapper.findByCId(cId);
        return detail;
    }

    @Override
    public int register(BoardDto board) {
        int register=boardMapper.insertOne(board);
        return register;
    }

    @Override
    public int modify(BoardDto board) {
        return boardMapper.updateOne(board);
    }

    @Override
    public int dropout(BoardDto board) {
        return boardMapper.deleteOne(board);
    }

}

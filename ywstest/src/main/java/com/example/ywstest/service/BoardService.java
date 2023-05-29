package com.example.ywstest.service;

import com.example.ywstest.dto.BoardDto;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    BoardDto detail(String cId);
    int register(BoardDto board);
    int modify(BoardDto board);
    int dropout(BoardDto board);
}

package com.example.ywstest.mapper;

import com.example.ywstest.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;
    private static BoardDto boardDto;

    @Test
    void insertOne() throws Exception {
        boardDto=new BoardDto();
        boardDto.setCId("이피피에스4");
        boardDto.setRId("윤우상4");
        boardDto.setTitle("테스트진행중");
        boardDto.setTitleDate("2023-05-29");
        boardDto.setViewCount(3);
//        boardDto.setImgPath("null");
        boardDto.setPw("1234");
        boardDto.setDetail("안녕하세요 반갑습니다.");
        int insert=boardMapper.insertOne(boardDto);
        assertEquals(insert,1);
    }
    @Test
    void updateOne() throws Exception {
        boardDto=new BoardDto();
        boardDto.setCId("이피피에스1");
        boardDto.setRId("수정 테스트 하는사람");
        boardDto.setTitle("수정 테스트중");
        boardDto.setTitleDate("2022-01-01");
        boardDto.setViewCount(4);
        boardDto.setPw("1234수정 테스트");
        boardDto.setDetail("수정테스트중입니당");
        int update=boardMapper.updateOne(boardDto);
        assertEquals(update,1);
    }
    @Test
    public void deleteOne() throws Exception {
        boardDto=new BoardDto();
        boardDto.setCId("");
        boardDto.setPw("1234");
        int delete=boardMapper.deleteOne(boardDto);
        assertEquals(delete,1);
    }
    @Test
    public void findBycId() {
        BoardDto findcId=boardMapper.findByCId("이피피에스7");
        System.out.println("findcId = " + findcId);
        assertNotNull(findcId);
    }
}

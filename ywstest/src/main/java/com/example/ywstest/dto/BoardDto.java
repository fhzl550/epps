package com.example.ywstest.dto;

import lombok.Data;

@Data
public class BoardDto {
    private String cId;
    private String rId;
    private String title;
    private String titleDate;
    private int viewCount;
//    private java.lang.String imgPath;
    private String pw;
    private String detail;
}

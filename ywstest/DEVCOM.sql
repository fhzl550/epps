DROP USER IF EXISTS 'meet'@'localhost';

CREATE DATABASE DEVCOM CHARACTER SET utf8;

CREATE USER 'meet'@'localhost' IDENTIFIED BY 'meet1234';
GRANT ALL PRIVILEGES ON DEVCOM.* TO 'meet'@'localhost';

CREATE USER 'meet'@'localhost' IDENTIFIED BY 'meet1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON DEVCOM.* TO 'meet'@'localhost';

USE DEVCOM;

CREATE TABLE BOARD_COMPANY
(
    c_id        VARCHAR(255) primary key    NOT NULL COMMENT '회사명',
    r_id        VARCHAR(255)                NOT NULL COMMENT '등록자',
    title       VARCHAR(255)                NOT NULL COMMENT '제목',
    title_date  DATE                        NOT NULL COMMENT '등록일자',
    view_count  INT UNSIGNED                DEFAULT 0 COMMENT '조회수',
    img_path    VARCHAR(255)                COMMENT '첨부파일',
    pw          VARCHAR(255)                NOT NULL COMMENT '비밀번호',
    detail      VARCHAR(255)                COMMENT '내용'
);

INSERT INTO BOARD_COMPANY (c_id, r_id, title, title_date, img_path, pw, detail) VALUES
                                                                                    ('이피피에스1','윤우상1','테스트 진행중1','2023-05-28','1','1234','안녕하세요 지원자 윤우상 입니다.'),
                                                                                    ('이피피에스2','윤우상2','테스트 진행중2','2023-05-25','1','1234','안녕하세요 지원자 윤우상 입니다.'),
                                                                                    ('이피피에스3','윤우상3','테스트 진행중3','2023-05-26','1','1234','안녕하세요 지원자 윤우상 입니다.');
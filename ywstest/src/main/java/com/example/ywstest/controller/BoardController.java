package com.example.ywstest.controller;

import com.example.ywstest.dto.BoardDto;
import com.example.ywstest.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list.do")
    public String list() {
        return "/board/list";
    }

    //입력
    @GetMapping("/register.do")
    public String registerForm() {
        return "/board/register";
    }
    @PostMapping("/register.do")
    public String registerInsert(BoardDto board, RedirectAttributes redirectAttributes) {
        boardService.register(board);
        redirectAttributes.addFlashAttribute("result",board.getCId());
        return "redirect:/board/list.do";
    }
    //수정
    @GetMapping("/modify.do")
    public String modifyForm(Model model,BoardDto board) throws Exception {
        model.addAttribute("b",board);
        return "/board/modify";
    }
    @PostMapping("/modify.do")
    public String modifyAction(
            @ModelAttribute BoardDto board,
            RedirectAttributes redirectAttributes){
        int modify=0;
        String msg="수정 실패";
        String redirectPage="redirect:/board/list.do";
        try {
            modify= boardService.modify(board);
        }catch (Exception e){
            log.error(e.getMessage());
            msg+=" 에러 :"+e.getMessage();
        }
        if(modify>0){
            redirectPage="redirect:/board/list.do";
            msg="수정 성공";
        }

        redirectAttributes.addFlashAttribute("msg",msg);
        return redirectPage;
    }
    //삭제
    @GetMapping("/delete.do")
    public String deleteForm() {return "/board/delete";}

    @PostMapping("/delete.do")
    public String dropoutAction(
            @ModelAttribute BoardDto board,
            RedirectAttributes redirectAttributes){
        String msg="삭제 실패 (비밀번호 확인)";
        String redirectPage="redirect:/board/list.do";
        int delete=0;
        try {
            delete=boardService.dropout(board);
        }catch (Exception e){
            log.error(e.getMessage());
            msg+=" 에러 :"+e.getMessage();
        }
        if(delete>0){
            msg="이용해 주셔서 감사합니다.(삭제 성공)";
            redirectPage="redirect:/board/list.do";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return redirectPage;
    }
    @GetMapping("/detail.do")
    public String detail(Model model,
                         @PathVariable String cId) {
        BoardDto board=boardService.detail(cId);
        model.addAttribute("b",board);
        return "redirect:/board/list.do";
    }
}

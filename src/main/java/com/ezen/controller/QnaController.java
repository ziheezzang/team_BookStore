package com.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.dto.Member;
import com.ezen.dto.Qna;
import com.ezen.service.QnaService;
import com.ezen.service.ReplyService;

import jakarta.servlet.http.HttpSession;


@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
	@Autowired
	private ReplyService replyService;
	
	/*@GetMapping(value="/index")
	public String index() {
		return "index";
	} */
	
	
	@GetMapping("/getQnaList") //페이징 리뷰 목록 화면 표시
	public String getQnaList(Model model,@RequestParam(required = false, defaultValue = "0", value = "page")int page) {
		Page<Qna> qnaList = qnaService.getQnaList(page);
		
		int totalPage = qnaList.getTotalPages();
		
		List<Qna> list = qnaList.getContent();
		
		System.out.println("<<< Qna List >>>");
		for (Qna rv : list) {
			System.out.println(rv);
		}
		
		model.addAttribute("qna",qnaList.getContent());
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("qnaList", list); //getQnaList의 86번째 줄과 이름이 동일해야한다.
		return "qna/getQnaList";
	}
	
	
	
	
	@RequestMapping("/getQna") //리뷰 수정 및 삭제 페이지 & reply 등록 페이지
	public String getQna(Qna qna, Model model) {
		
		model.addAttribute("qna",qnaService.getQna(qna));
		
		model.addAttribute("replyList", replyService.getReplyListByQseq(qna.getSeq()));
		
		System.out.println(qnaService.getQna(qna));
		
		return "qna/getQna";
	}
	
	
	@GetMapping("/insertQna") // 리뷰 등록 페이지 불러오기
	public String insertQna() {
		
		return "getQnaList";
	} 
	
	
	@PostMapping("/insertQna")  //Qna 등록 처리
	public String insertQna(Qna qna, HttpSession session) { //session에 member의 정보가 등록되어있어야 하기 때문이다.
		// login구현이 되어있을때 사용
		//Member loginUser = (Member)session.getAttribute("loginUser" );
		Member loginUser = new Member("doolly123",null,null,null,0,null); //강제로 member에 대한 값을 넣어주었을때! 
		
		if(loginUser != null ) {
			qna.setMember(loginUser);
			qnaService.insertQna(qna);
		}
		
		return "redirect:/getQnaList"; 
	} 
	
	
	
	@PostMapping("/updateQna")
	public String updateQna(Qna qna) {
		qnaService.updateQna(qna);
		
		return "forward:getQna";
	}
	
	
	
	@GetMapping("/deleteQna")//QnA 삭제
	public String deleteQna(Qna qna) {
		qnaService.deleteQna(qna);
		
		return "forward:getQnaList";
	}
	
	
}

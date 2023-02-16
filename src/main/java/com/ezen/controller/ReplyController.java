package com.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.dto.Member;
import com.ezen.dto.Qna;
import com.ezen.dto.Reply;
import com.ezen.service.ReplyService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	
	/*
	@GetMapping("/getQna") //페이징 목록 화면 표시
	public String getQna(Model model,@RequestParam(required = false, defaultValue = "0", value = "page")int page) {
		Page<Reply> replyList = replyService.getQna(page);
		
		int totalPage = replyList.getTotalPages();
		
		List<Reply> list = replyList.getContent();
		
		System.out.println("<<< Reply List >>>");
		for (Reply rv : list) {
			System.out.println(rv);
		}
		
		model.addAttribute("reply",replyList.getContent());
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("replyList", list);
		return "qna/getQna";
	}*/
	
	
	
	
	@RequestMapping("/getReply") //답글 페이지
	public String getQna(Reply reply, Model model) {
		model.addAttribute("reply",replyService.getQna(reply));
		return "qna/getQna";
	}
	
	
	@GetMapping("/insertReply") // 답글 등록 페이지 불러오기
	public String insertReply() {
		
		return "getQna";
	} 
	
	@PostMapping("/insertReply")  // 답글 등록 처리
	public String insertReply(@RequestParam(value="seq") long seq,
							  @RequestParam(value="reply") String reply,
							  HttpSession session, RedirectAttributes model ) { //session에 member의 정보가 등록되어있어야 하기 때문이다.
		// login구현이 되어있을때 사용
		//Member loginUser = (Member)session.getAttribute("loginUser" );
		Member loginUser = new Member("doolly123",null,null,null,0,null); //강제로 member에 대한 값을 넣어주었을때! 
		
		Reply vo = new Reply();
		Qna qna = new Qna();
		
		qna.setSeq(seq);
		vo.setQna(qna);
		vo.setReply(reply);
		if(loginUser != null ) {
			vo.setMember(loginUser);
			replyService.insertReply(vo);
		}
		
		System.out.println("reply = " + vo );
		
		model.addAttribute("seq",seq);
		
		return "redirect:/getQna";  
	}
	
	

	@RequestMapping("/deleteReply")//답글 삭제,Qna 게시글의 번호도 받와야하기 때문에 
	public String deleteReply(Reply reply, @RequestParam(value="seq") long seq, RedirectAttributes redirect) {
		
		replyService.deleteReply(reply);
		
		Qna qna = new Qna();
		qna.setSeq(seq);
		redirect.addAttribute("qna", reply.getQna());
		
		return "forward:getQna"; 
	}
	
	
}

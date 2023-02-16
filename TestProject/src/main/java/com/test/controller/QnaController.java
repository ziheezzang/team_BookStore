package com.test.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.Member;
import com.test.dto.Qna;
import com.test.dto.Reply;
import com.test.service.QnaService;
import com.test.service.ReplyService;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@Autowired
	private ReplyService replyService;

	@RequestMapping("/getQnaList")
	public String getQnaList(Model model,
			@RequestParam(required = false, defaultValue = "0", value = "page") int page) {
		Page<Qna> qnaList = qnaService.getQnaList(page);

		int totalPage = qnaList.getTotalPages();

		model.addAttribute("qnaList", qnaList.getContent());
		model.addAttribute("totalPage", totalPage);
		return "qna/getQnaList";
	}

	@GetMapping("getQna")
	public String getQna(Qna qna, Reply reply, Model model) {
		model.addAttribute("qna", qnaService.getQna(qna));
		model.addAttribute("board", qna.getMember());

		List<Reply> replyList = replyService.getReplyList();
		model.addAttribute("replyList", replyList);
		return "qna/getQna";
	}

	@PostMapping("updateQna")
	public String updateQna(Qna qna) {
		qnaService.updateQna(qna);
		return "redirect:getQnaList";
	}

	@GetMapping("deleteQna")
	public String deleteQna(Qna qna) throws ConstraintViolationException {
		try {
			qnaService.deleteQna(qna);
			return "redirect:getQnaList";
		} catch (Exception e) {
			return "qna/alert";
		}

	}

	@GetMapping("insertQna")
	public String insertQna() {
		return "qna/insertQna";
	}

	@PostMapping("insertQna")
	public String insertQna(Qna qna) {
		qnaService.insertQna(qna);
		return "redirect:getQnaList";
	}

	@GetMapping("insertReply")
	public String insertReply() {
		return "qna/getQna";
	}

	@PostMapping("insertReply")
	public String insertReply(@RequestParam(value = "seq") long seq, @RequestParam(value = "user_id") long user_id,
			@RequestParam(value = "reply") String content) {
		Qna qna = new Qna();
		qna.setSeq(seq);
		Member member = new Member();
		member.setUser_id(user_id);
		Reply reply = new Reply();
		reply.setRecontent(content);

		reply.setQna(qna);
		reply.setMember(member);
		replyService.insertReply(reply);

		return "qna/alertOk";
	}

	@GetMapping("/deleteReply")
	public String deleteReply(Reply reply) {
		replyService.deleteReply(reply);
		return "qna/alertOk";
	}

	@PostMapping("updateReply")
	public String updateReply(Reply reply) {
		replyService.updateReply(reply);
		return "redirect:getQnaList";
	}

}

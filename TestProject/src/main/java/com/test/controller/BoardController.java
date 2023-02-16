package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.dto.Board;
import com.test.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("getBoardList")
	public String getBoardList(Model model, @RequestParam(required = false, defaultValue = "0",value="page")int page) {
		Page<Board> boardList = boardService.getBoardList(page);
		
		int totalPage = boardList.getTotalPages();
		
		model.addAttribute("boardList",boardList.getContent());
		model.addAttribute("totalPage",totalPage);
		return "board/getBoardList";
	}
	
	@GetMapping("getBoard")
	public String getBoard(Board board,Model model) {
		model.addAttribute("board",boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		System.out.println("deleteBoard(): board = " + board);
		boardService.deleteBoard(board);
		return "redirect:getBoardList";
	}

	
	@GetMapping("insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}
	@PostMapping("insertBoard")
	public String insertBoard(Board board,MultipartFile file) throws Exception {
		String fileName=file.getOriginalFilename();
		board.setImage(fileName);
		boardService.insertBoard(board, file);
		return "redirect:getBoardList";
	}
}

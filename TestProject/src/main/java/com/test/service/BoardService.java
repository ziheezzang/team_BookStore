package com.test.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.test.dto.Board;


public interface BoardService {

	void insertBoard(Board board, MultipartFile file) throws Exception;
	void updateBoard(Board board);
	void deleteBoard(Board board);
	Board getBoard(Board board);
	Page<Board> getBoardList(int page);
}

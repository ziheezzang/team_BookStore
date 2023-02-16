package com.test.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.dto.Board;
import com.test.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepo;

	@Override
	public void insertBoard(Board board, MultipartFile file) throws Exception {

		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";

		// UUID uuid = UUID.randomUUID();//랜덤으로 식별자를 만들어준다.
		// String fileName = uuid + "_" + file.getOriginalFilename();

		String fileName = file.getOriginalFilename();

		File saveFile = new File(projectPath, fileName);

		file.transferTo(saveFile);
		boardRepo.save(board);
	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById((long) board.getId()).get();

		findBoard.setType(board.getType());
		findBoard.setTitle(board.getTitle());
		findBoard.setPrice(board.getPrice());
		findBoard.setAuthor(board.getAuthor());
		findBoard.setPublisher(board.getPublisher());
		findBoard.setContent(board.getContent());
		findBoard.setImage(board.getImage());
		findBoard.setPurchase(board.getPurchase());
		findBoard.setQuantity(board.getQuantity());
		findBoard.setPer_point(board.getPer_point());

		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getId());
	}

	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getId()).get();
	}

	@Override
	public Page<Board> getBoardList(int page) {

		return boardRepo.findAll(PageRequest.of(page, 10, Sort.Direction.DESC, "id"));
	}

}


package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController

public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoard(){
		log.info("getBoard: All");
		return ResponseEntity.ok(boardService.getBoards());
	}
	
	@GetMapping("/board/{id}")
	public ResponseEntity<?> getBoard(@PathVariable Long id){
		log.info("getBoard: " + id);
		return ResponseEntity.ok(boardService.getBoard(id));
	}
	
	@PostMapping("/board")
	public ResponseEntity<?> insertBoard(@RequestBody Board board){
		log.info("insertBoard: " + board);
		Board saveBoard = boardService.insertBoard(board);
		return ResponseEntity.ok(saveBoard);
		
		
	}
	
	@DeleteMapping("/board/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id ){
		log.info("deleteBoard: " + id);
		boardService.deleteBoard(id);
		return ResponseEntity.ok(boardService.getBoards());
		
		}
	
	@PutMapping("/board")
	public ResponseEntity<?> updateBoard(@RequestBody Board board){
		log.info("updateBoard: " + board);
		return ResponseEntity.ok(boardService.updateBoard(board));
		
	}
	
	
		
	}



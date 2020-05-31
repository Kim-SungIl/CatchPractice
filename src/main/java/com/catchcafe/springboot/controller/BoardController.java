package com.catchcafe.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catchcafe.springboot.model.Board;
import com.catchcafe.springboot.service.BoardService;

// http://localhost:8080/boards 아래로 들어오는 요청을 이 Controller에서 처리할 수 있도록 RequestMapping을 
@Controller
@RequestMapping("/boards")
public class BoardController {
	
	// Spring의 DI (Dependency Injection) 개념으로, 미리 생성된 BoardService Bean을 사용하겠다는 뜻으로 이해하면 된다.
	@Autowired
	BoardService boardService;
	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Board getBoard(@PathVariable int id) {
		// 보통 Controller에서는 input의 validation을 check해주는 경우가 많음
		if (boardService.getBoardSize() < id){
			return null;
		}
		// 직접 요청을 처리하기 보다는 Service를 호출한다.
		Board board = boardService.getBoard(id);
		return board;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public int createBoard(@RequestBody Board board) {
		int size = boardService.createBoard(board);
		return size;
	}
}

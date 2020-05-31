package com.catchcafe.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.catchcafe.springboot.model.Board;

// @Service 어노테이션을 사용해서 Bean으로 등록한다 (Service 업무를 수행하는 Bean임을 명시하기 위해서 해당 어노테이션 사용)
@Service
public class BoardService {
	
	// 아직 DB를 사용하지 않기 때문에 임시로 List를 사용해서 프로그램을 만들었음.
	private List<Board> boards = new ArrayList<Board>();
	
	// 전체 게시글의 갯수를 리턴해주는 함수.
	public int getBoardSize() {
		return boards.size();
	}
	
	// 게시글 id로 글 읽어오는 함수
	public Board getBoard(int id) {
		return boards.get(id);
	}
	
	// 파라미터로 넘어온 board 객체를 리스트에 저장하는 함수, return 값은 총 게시글 갯수
	public int createBoard(Board board) {
		boards.add(board);
		return boards.size();
	}
}

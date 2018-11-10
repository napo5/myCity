package myCity;

import java.util.ArrayList;

public class BoardList {
	
	private ArrayList<Board> boards = new ArrayList<Board>();

	public BoardList() {
		
	}
	
	
	void addBoard(Board board) {
		boards.add(board);
	}

	
	void printBoards() {
		
		System.out.println("There are "+boards.size()+" boards.");
		
		for( int i =0; i < boards.size();i++) {
			
			System.out.println("-"+boards.get(i).getBoardID()+". "+boards.get(i).toString());
		}
	}


	public ArrayList<Board> getBoards() {
		return boards;
	}
	
	

}

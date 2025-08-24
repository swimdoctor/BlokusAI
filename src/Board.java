import java.util.List;

public class Board {
	public int[][] board;
	private int size;

	public Board(int size){
		this.size = size;
		board = new int[size][size];
	}

	public void displayBoard(){
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				switch (board[y][x]) {
					case 0:
						System.out.print("[]");
						break;
					case 1:
						System.out.print("\\033[0;31mn[]");
						break;
				}
			}
		}
 	}

	public int tryMove(List<Point> points){
		
		
		return -1;
	}
}
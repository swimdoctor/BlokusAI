import java.util.List;

public class Board {
	private int[][] board;
	public int size;

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
						System.out.print("\\033[0;31mn██");
						break;
					case 2:
						System.out.print("\\033[0;32mn██");
						break;
					case 3:
						System.out.print("\\033[0;33mn██");
						break;
					case 4:
						System.out.print("\\033[0;34mn██");
						break;
				}
			}
			System.out.println();
		}
 	}

	public boolean addPiece(List<Point> points, int playerIndex){
		
		
		return false;
	}

	public int getPoint(Point p) {
		if(p.x >= size || p.y >= size || p.x < 0 || p.y < 0) return -1;
		return board[p.x][p.y];
	}

	public int getPoint(int x, int y) {
		if(x >= size || y >= size || x < 0 || y < 0) return -1;
		return board[x][y];
	}
}
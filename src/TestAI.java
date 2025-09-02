import java.util.ArrayList;
import java.util.List;

public class TestAI extends BaseAI {
	public List<List<Point>> findAvailableMoves(Board board) {
        return null;
    }
	public List<Point> getMove(Board board) {
        return null;
    }
	public int getAvailableMoveCount() {
        return 0;
    }

    private List<Point> getAvailableStartingPoints(Board board) {
        List<Point> points = new ArrayList<Point>();
        if(board.getPoint(startingPoint) == 0) points.add(startingPoint);
        
        for(int x = 0; x < board.size; x++) {
            for(int y = 0; y < board.size; y++) {
                if(board.getPoint(x, y) != 0) continue;
                
            }
        }

        return points;
    }
}
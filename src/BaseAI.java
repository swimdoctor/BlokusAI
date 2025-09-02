import java.util.List;

public abstract class BaseAI {
	public List<List<Point>> moves;
	public Point startingPoint;
	public int playerIndex;
	public String getName() {
		return getClass().getName();
	}

	public abstract List<List<Point>> findAvailableMoves(Board board);
	public abstract List<Point> getMove(Board board);
	public abstract int getAvailableMoveCount();
}

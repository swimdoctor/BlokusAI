import java.util.List;

public abstract class BaseAI {
	public String getName() {
		return getClass().getName();
	}

	public abstract List<Point> getMove(Board board);
}

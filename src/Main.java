import java.util.List;
import java.util.Scanner;


public class Main {
	private static final List<Class<? extends BaseAI>> AITypes = List.of(
		TestAI.class
	);


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to BlokusBot");
		System.out.println("Do you wish to start a game? (y/n)");

		char c = sc.nextLine().charAt(0);
		if(c != 'y'){
			System.out.println("Alright then, cya!");
		}

		System.out.println("How many players are playing?");
		int playerCount = sc.nextInt();
		sc.nextLine(); //Clear whitespace
		if(playerCount < 2 || playerCount > 4){
			System.out.println("Invalid player count");
			return;
		}

		if(playerCount > 2) System.out.println("Only 2 players are supported at this time");

		
		BaseAI[] players = new BaseAI[playerCount];

		System.out.println("Time to choose the players, here are your options: ");
		for(int i = 0; i < AITypes.size(); i++){
			System.out.println("[" + i + "] " + AITypes.get(i).getName());
		}
		System.out.println();
		for(int i = 0; i < playerCount; i++){
			System.out.println("Who do you want for Player " + (i + 1));
			int playerIndex = sc.nextInt();
			sc.nextLine();
			try {
				players[i] = AITypes.get(playerIndex).getDeclaredConstructor().newInstance();
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Could not create AI");
				return;
			}
		}

		System.out.print("Alright, we have");
		for(int i = 0; i < playerCount; i++){
			if(i > 0) System.out.print(" vs");
			System.out.print(" " + players[i].getName());
		}
		System.out.println();
		System.out.println("Starting game...");

		Board board = new Board(20);
		int turn = 0;
		int currentPlayer = 0;
		
		while(!gameIsOver(players)) {
			players[currentPlayer].findAvailableMoves(board);
			if(players[currentPlayer].getAvailableMoveCount() > 0) 
			{
				List<Point> move = players[currentPlayer].getMove(board);
				if(!board.addPiece(move, currentPlayer)) {
					System.out.println("Invalid Move Played!");
					return;
				}
			}

			currentPlayer++;
			if(currentPlayer >= playerCount) {
				currentPlayer %= playerCount;
				turn++;
			}
			System.out.println("Player " + currentPlayer + "'s turn.");
			board.displayBoard();
			Thread.sleep(1000);
			System.out.println();
		}
    }

	private static boolean gameIsOver(BaseAI[] players) {
		return false;
	}

}
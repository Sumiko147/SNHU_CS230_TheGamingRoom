package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Instantiated GameService (singleton)
		GameService service = GameService.getInstance();		
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();

		
		System.out.println("\n\nTEST: Adding Team A, adding 2 players named Logan");

		// TEST: Adding team, expected output: Team [id=1, name=Team A]
		Team team1 = game1.addTeam("Team A");
		System.out.println(team1);

		// TEST: Adding player1, expected output: Player [id=1, name=Logan]
		Player player1 = team1.addPlayer("Logan");
		System.out.println(player1);
		
		// TEST: Adding same player to team, expected output: Player [id=1, name=Logan]
		//       Should NOT see a new ID number for player2
		Player player2 = team1.addPlayer("Logan");
		System.out.println(player2);

	}
}

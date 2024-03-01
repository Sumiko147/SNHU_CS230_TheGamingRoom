
package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;  

/*	A singleton service for the game engine
	@author coce@snhu.edu
	
	Added nextPlayerID, nextTeamId private attributes
	Added getNextPlayerId, getNextTeamId public methods
		These attributes and methods consolidates game management 
		in the GameServices class.
	@author sumiko.mitchell@snhu.edu
	@date   2024/01/28
*/

public class GameService {

	// 	A list of the active games 
	private static List<Game> games = new ArrayList<Game>();

	// 	Holds the next game, team and player identifier
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	
	// 	Private constructor to prevent the GameService class from being instantiated. */
	private GameService() {}
	
	/* 	First GameService instance will be initialized to null, allowing for getInstance 
		to create a new GameService, but preventing additional GameInstances instantiations.
	*/
	private static GameService service = null;
	
	// 	Create new GameService, if none exist.
	public static GameService getInstance() {
		if (service == null) {
			service = new GameService();
		} 
		return service;
	}

	/* 	Construct a new game instance
			@param name the unique name of the game
			@return the game instance (new or existing)
	*/
	public Game addGame(String name) {

		// 	a local game instance
		Game game = null;

		// 	Instantiate iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		// 	Iterate game set to locate game name
		while (gamesIterator.hasNext()) {
			// 	Set currentGame to next element
			Game currentGame = gamesIterator.next();
			// 	Check if current game matches game name
			if (currentGame.getName().equalsIgnoreCase(name) )
				return currentGame;
		}

		// 	if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// 	return the new/existing game instance to the caller
		return game;
	}

	/* 	Returns the game instance at the specified index.
		Scope is package/local for testing purposes.
			@param index index position in the list to return
    		@return requested game instance
	*/
	Game getGame(int index) {
		return games.get(index);
	}
	
	/*	Returns the game instance with the specified id.
			@param id unique identifier of game to search for
			@return requested game instance
	*/
	public Game getGame(long id) {

		// 	a local game instance
		Game game = null;

		// 	Instantiate iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		// 	Iterate game set to locate game ID
		while (gamesIterator.hasNext()) {
			// 	Set currentGame to next element
			Game currentGame = gamesIterator.next();
			// 	Check if currentGame ID matches game ID
			if (currentGame.getId() == id) {
				return currentGame;
			}
		}
		
		return game;
	}

	/*	Returns the game instance with the specified name.
			@param name unique name of game to search for
			@return requested game instance
	*/
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Instantiate iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		// Iterate game set to locate game name
		while (gamesIterator.hasNext()) {
			// Set currentGame to next element
			Game currentGame = gamesIterator.next();
			// Check if matches game name
			if (currentGame.getName().equalsIgnoreCase(name) )
				return currentGame;
		}		
		
		return game;
	}

	/*	Returns the number of games currently active
			@return the number of games currently active
	*/
	public int getGameCount() {
		return games.size();
	}
	
	/* 	Increment current player, team count for next IDs
			@ return player, team count + 1
	*/
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
}

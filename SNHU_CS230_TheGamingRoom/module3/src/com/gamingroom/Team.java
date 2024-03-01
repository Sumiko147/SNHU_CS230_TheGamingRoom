package com.gamingroom;

/*	A simple class to hold information about a team
	Notice the overloaded constructor that requires
 	an id and name to be passed when creating.
 	Also note that no mutators (setters) defined so
 	these values cannot be changed once a team is
 	created.
	@author coce@snhu.edu

	Updated Team class to utilize the newly created Entity class
	for sharing, organizing, maintaining code.
	@author sumiko,mitchell@snhu.edu
	@date   2024/01/28
 */


import java.util.ArrayList;
import java.util.Iterator;

public class Team extends Entity {
	
	// Array of players, per The Gaming Room UML
	private ArrayList<Player> players;
	
	// Public constructor (Entity id, name)
	public Team (long id, String name) {
		super(id, name);
		players = new ArrayList<>();  // Ensure that the players array list is not null
	}
	
	// Add new player name is unique
	public Player addPlayer(String name) {
		
		// A local player instance
		Player playerName = null;
		
		// Instantiate iterator
		Iterator<Player> playersIterator = players.iterator();
		
		// Iterate player set to locate player name
		while (playersIterator.hasNext()) {
			// Set currentPlayer to next element
			Player currentPlayer = playersIterator.next();
			// Check if current player matches team name
			if (currentPlayer.getName().equalsIgnoreCase(name)) {
				return currentPlayer;
			}
		}
		
		// If not found, make new player instance and add to list of players
		if (playerName == null) {
			playerName = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(playerName);
		}
		return playerName;
	}
	
	//	Team data string for logging
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";		
	}	
	
}
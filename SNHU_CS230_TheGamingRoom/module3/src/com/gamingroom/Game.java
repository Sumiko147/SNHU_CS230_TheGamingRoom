package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;


/*	A simple class to hold information about a game
	the overloaded constructor that requires
	an id and name to be passed when creating.
	Also note that no mutators (setters) defined so
	these values cannot be changed once a game is
	created.
	@author coce@snhu.edu
	
	Updated Game class to utilize the newly created Entity class
	for sharing, organizing, maintaining code.
	@author sumiko,mitchell@snhu.edu
	@date   2024/01/28 
 */

public class Game extends Entity {
	
	//	Array of teams, per The Gaming Room UML
	private ArrayList<Team> teams;
	
	//	Public constructor (Entity id, name)
	public Game(long id, String name) {
		super(id, name);
		teams = new ArrayList<>();  // Ensure that the teams array list is not null
	}
	
	//	Add new team, if team name is unique
	public Team addTeam(String name) {
		
		// A local team instance
		Team teamName = null;
		
		// Instantiate iterator
		Iterator<Team> teamsIterator = teams.iterator();
		
		// Iterate team set to locate team name
		while (teamsIterator.hasNext()) {
			// Set currentTeam to next element
			Team currentTeam = teamsIterator.next();
			// Check if current team matches team name
			if (currentTeam.getName().equalsIgnoreCase(name)) {
				return currentTeam;
			}
		}
		
		//	If not found, make a new team instance and add to list of teams
		if (teamName == null) {
			teamName = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(teamName);
		}
		return teamName;
		
	}
	
	//	Game data string for logging
	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + "]";		
	}

	
}
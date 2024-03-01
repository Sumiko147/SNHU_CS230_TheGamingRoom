package com.gamingroom;

/*	A simple class to hold information about a player Notice the overloaded
	constructor that requires an id and name to be passed when creating. Also
	note that no mutators (setters) defined so these values cannot be changed
	once a player is created.
	@author coce@snhu.edu
	
	Updated Player class to utilize the newly created Entity class
	for sharing, organizing, maintaining code.
	@author sumiko,mitchell@snhu.edu
	@date   2024/01/28
 */

public class Player extends Entity {
	
	// Public constructor (Entity id, name)
	public Player (long id, String name) {
		super(id, name);
	}
	
	//	Team player string for logging
	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";		
	}	
	
}
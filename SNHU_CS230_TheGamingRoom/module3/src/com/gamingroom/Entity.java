package com.gamingroom;

/*	Added the Entity class to serve as a base for inheritance for the
	Game, Teams, and Player classes.
	@author sumiko.mitchell@snhu.edu
	@date   2024/01/28
*/

public class Entity {
	
	//	Private attributes
	private long id;
	private String name;
	
	//	Private constructor
	private Entity() {}
	
	//	Public constructor with parameters, create id and name w/values
	public Entity(long id, String name) {
		this.id= id;
		this.name = name;
	}
	
	//	Public getters
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name; 
	}
	
	//	Entity data string for logging
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";		
	}

}

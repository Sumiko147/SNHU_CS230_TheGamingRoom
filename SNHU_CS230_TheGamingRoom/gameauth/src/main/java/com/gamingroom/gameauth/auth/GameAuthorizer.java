package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {
    	
        // DONE: Finish the authorize method based on BasicAuth Security Example
    	// SM: This statement checks if the user has roles and a specific role assigned.
    	return user.getRoles() != null && user.getRoles().contains(role);
    	
    }
}
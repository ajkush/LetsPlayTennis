package com.gamer.state.impl;

import com.gamer.common.Constants;
import com.gamer.state.GameState;

public class InitialGameState implements GameState {

	
	    public String getGameState(String namePlayer1, final String name) {
	        return Constants.LOVE_ALL;
	    }

	    public GameState scoredByPlayer1() {
	        return new PreDeuceGameState(1, 0);
	    }

	    public GameState scoredByPlayer2() {
	        return new PreDeuceGameState(0, 1);
	    }

	    
   
    
}
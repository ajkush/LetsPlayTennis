package com.gamer.state.impl;

import com.gamer.common.Constants;
import com.gamer.state.GameState;

public class DeuceGameState implements GameState {


	public String getGameState(String namePlayer1, String name) {
		return Constants.DEUCE;
	}


	public GameState scoredByPlayer1() {
		return new AdvantagePlayer1GameState();
	}


	public GameState scoredByPlayer2() {
		return new AdvantagePlayer2GameState();
	}
}
package com.gamer.state;

public interface GameState {

	GameState scoredByPlayer1();

	GameState scoredByPlayer2();

	String getGameState(String namePlayer1, final String name);

}
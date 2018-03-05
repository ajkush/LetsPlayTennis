package com.gamer.tennis.impl;

import com.gamer.state.GameState;
import com.gamer.state.impl.InitialGameState;
import com.gamer.tennis.Score;
public class TennisScore implements Score {

    private GameState gameState = new InitialGameState();
    private String nameOfPlayer1;
    private String nameOfPlayer2;

    public TennisScore(String nameOfPlayer1, String nameOfPlayer2) {
        this.nameOfPlayer1 = nameOfPlayer1;
        this.nameOfPlayer2 = nameOfPlayer2;
    }

    public void pointScoredBy(String playerName) {
        if (nameOfPlayer1.equals(playerName)) {
            gameState = gameState.scoredByPlayer1();
        } else if (nameOfPlayer2.equals(playerName)) {
            gameState = gameState.scoredByPlayer2();
        }
    }

    public String getGameScore() {
        return gameState.getGameState(nameOfPlayer1, nameOfPlayer2);
    }
}	
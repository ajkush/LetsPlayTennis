package com.gamer.state.impl;

import com.gamer.common.Constants;
import com.gamer.state.GameState;

public class AdvantagePlayer1GameState implements GameState {

    public String getGameState(String namePlayer1, final String namePlayer2) {
        return Constants.ADVANTAGE_ + namePlayer1;
    }

    public GameState scoredByPlayer1() {
        return new WinnerPlayer1GameState();
    }

    public GameState scoredByPlayer2() {
        return new DeuceGameState();
    }
}
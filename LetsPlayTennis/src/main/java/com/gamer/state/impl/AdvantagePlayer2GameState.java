package com.gamer.state.impl;

import com.gamer.common.Constants;
import com.gamer.state.GameState;

public class AdvantagePlayer2GameState implements GameState {

    public String getGameState(String namePlayer1, final String namePlayer2) {
        return Constants.ADVANTAGE_ + namePlayer2;
    }

    public GameState scoredByPlayer1() {
        return new DeuceGameState();
    }

    public GameState scoredByPlayer2() {
        return new WinnerPlayer2GameState();
    }
}

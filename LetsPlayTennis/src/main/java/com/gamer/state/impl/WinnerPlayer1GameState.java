package com.gamer.state.impl;

import com.gamer.common.Constants;
import com.gamer.state.GameState;

public class WinnerPlayer1GameState implements GameState {

    public String getGameState(String namePlayer1, final String namePlayer2) {
        return Constants.WIN_FOR_ + namePlayer1;
    }

    public GameState scoredByPlayer1() {
        return null;
    }

    public GameState scoredByPlayer2() {
        return null;
    }
}
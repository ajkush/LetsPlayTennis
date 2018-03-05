package com.gamer.state.impl;

import com.gamer.mapper.ScoreNameMapper;
import com.gamer.state.GameState;

public class PreDeuceGameState implements GameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    private final ScoreNameMapper scoreNameMapper;

    public PreDeuceGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
        scoreNameMapper = new ScoreNameMapper();
    }

    public String getGameState(String namePlayer1, final String name) {
        return String.format("%s-%s", scoreNameMapper.scoreMap(pointsPlayer1), scoreNameMapper.scoreMap(pointsPlayer2));
    }

    public GameState scoredByPlayer1() {

        final int incrementedPointsPlayer1 = pointsPlayer1 + 1;

        if (incrementedPointsPlayer1 == 4 && pointsPlayer2 != incrementedPointsPlayer1) {
            return new WinnerPlayer1GameState();
        }

        if (incrementedPointsPlayer1 == pointsPlayer2) {
            if (incrementedPointsPlayer1 >= 3) {
                return new DeuceGameState();
            }
            return new PostDucerGameState(incrementedPointsPlayer1);
        }

        return new PreDeuceGameState(incrementedPointsPlayer1, this.pointsPlayer2);
    }

    public GameState scoredByPlayer2() {

        final int incrementedPointsPlayer2 = pointsPlayer2 + 1;

        if (incrementedPointsPlayer2 == 4 && pointsPlayer1 != incrementedPointsPlayer2) {
            return new WinnerPlayer2GameState();
        }

        if (incrementedPointsPlayer2 == pointsPlayer1) {
            if (incrementedPointsPlayer2 >= 3) {
                return new DeuceGameState();
            }
            return new PostDucerGameState(incrementedPointsPlayer2);
        }

        return new PreDeuceGameState(this.pointsPlayer1, incrementedPointsPlayer2);
    }
}
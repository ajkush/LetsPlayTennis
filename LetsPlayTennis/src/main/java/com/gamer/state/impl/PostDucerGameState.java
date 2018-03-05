package com.gamer.state.impl;

import com.gamer.mapper.ScoreNameMapper;
import com.gamer.state.GameState;

public class PostDucerGameState implements GameState {

    private final int points;

    private final ScoreNameMapper scoreNameMapper;

    public PostDucerGameState(int points) {
        this.points = points;
        scoreNameMapper = new ScoreNameMapper();
    }

    public String getGameState(String namePlayer1, final String namePlayer2) {
        return scoreNameMapper.scoreMap(points) + "-All";
    }

    public GameState scoredByPlayer1() {

        final int incrementedPointsPlayer1 = points + 1;

        if (incrementedPointsPlayer1 == 4) {
            return new AdvantagePlayer1GameState();
        }

        return new PreDeuceGameState(incrementedPointsPlayer1, points);
    }

    public GameState scoredByPlayer2() {

        final int incrementedPointsPlayer2 = points + 1;

        if (incrementedPointsPlayer2 == 4) {
            return new AdvantagePlayer2GameState();
        }

        return new PreDeuceGameState(points, incrementedPointsPlayer2);
    }
}
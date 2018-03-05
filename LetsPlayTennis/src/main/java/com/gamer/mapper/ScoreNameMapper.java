package com.gamer.mapper;

import com.gamer.common.Constants;
import com.gamer.exception.IllegalScoreException;

public class ScoreNameMapper {

    public String scoreMap(int score) {
        switch (score) {
            case 0: return Constants.LOVE;
            case 1: return Constants.FIFTEEN;
            case 2: return Constants.THIRTY;
            case 3: return Constants.FORTY;
        }
        throw new IllegalScoreException("<Score: " + score + ">");
    }

}
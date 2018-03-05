package com.gamer.tennis;

import org.junit.Test;

import com.gamer.common.Constants;
import com.gamer.state.GameState;
import com.gamer.state.impl.AdvantagePlayer1GameState;
import com.gamer.state.impl.AdvantagePlayer2GameState;
import com.gamer.state.impl.DeuceGameState;
import com.gamer.state.impl.InitialGameState;
import com.gamer.state.impl.PostDucerGameState;

import static org.junit.Assert.*;

public class GameStateTest {

	@Test
	public void shouldHaveLoveAllAsInitialGameState() throws Exception {

		GameState state = new InitialGameState();

		assertEquals(Constants.LOVE_ALL, state.getGameState("player1", "player2"));
	}

	
	@Test
	public void givenInitialGameState_whenPlayerTwoScoringPoint_shouldBeFifteenLove() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer2();

		assertEquals(Constants.LOVE_FIFTEEN, newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerOneScoresTwoTimes_shouldBeThirtyLove() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer1().scoredByPlayer1();

		assertEquals(Constants.THIRTY_LOVE, newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerTwoScoresTwoTimes_shouldBeLoveThirty() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer2().scoredByPlayer2();

		assertEquals("Love-Thirty", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerTwoScoresThreeTimes_shouldBeLoveForty() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer2().scoredByPlayer2().scoredByPlayer2();

		assertEquals("Love-Forty", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerTwoScoresAndscoredByPlayer1_shouldBeFifteenAll() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer1().scoredByPlayer2();

		assertEquals("Fifteen-All", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerTwoScores4Times_shouldBeWinForPlayer2() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer2().scoredByPlayer2().scoredByPlayer2().scoredByPlayer2();

		assertEquals("Win for player2", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerOneAndTwoScoredThreeTimesAndPlayerTwoScores_shouldBeAdvantageForPlayer2()
			throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer1().scoredByPlayer2().scoredByPlayer1().scoredByPlayer2()
				.scoredByPlayer1().scoredByPlayer2().scoredByPlayer2();

		assertEquals("Advantage player2", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerOneAndTwoScoreThreeTimes_shouldBeDeuce() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer1().scoredByPlayer1().scoredByPlayer1().scoredByPlayer2()
				.scoredByPlayer2().scoredByPlayer2();

		assertEquals("Deuce", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenPlayerOneAndTwoScoreEqualTimesAboveThreeToTen_shouldBeDeuce()
			throws Exception {
		for (int scores = 0; scores < 7; scores++) {
			GameState state = new DeuceGameState();
			for (int j = 0; j < scores; j++) {
				state = state.scoredByPlayer1().scoredByPlayer2();
			}
			assertEquals("Deuce", state.getGameState("player1", "player2"));
		}
	}

	@Test
	public void givenAdvantageGameState_whenPlayerOneInAdvantageScores_shouldBeWin() throws Exception {

		final GameState advantageGameState = new AdvantagePlayer1GameState();

		final GameState result = advantageGameState.scoredByPlayer1();

		assertEquals("Win for player1", result.getGameState("player1", "player2"));
	}

	@Test
	public void givenAdvantageGameState_whenPlayerTwoInAdvantageScores_shouldBeWin() throws Exception {

		final GameState advantageGameState = new AdvantagePlayer2GameState();

		final GameState result = advantageGameState.scoredByPlayer2();

		assertEquals("Win for player2", result.getGameState("player1", "player2"));
	}

	@Test
	public void givenAdvantageGameState_whenPlayerTwoNotInAdvantageScores_shouldBeDeuce() throws Exception {

		final GameState advantageGameState = new AdvantagePlayer2GameState();

		final GameState result = advantageGameState.scoredByPlayer1();

		assertEquals("Deuce", result.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_BothPlayersScoredTwoTimes_shouldBeThirtyAll() throws Exception {

		GameState state = new InitialGameState();

		GameState newState = state.scoredByPlayer1().scoredByPlayer2().scoredByPlayer1().scoredByPlayer2();

		assertEquals("Thirty-All", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_whenGameIsEvenAfterAdvantage_shouldReportCorrectScore() throws Exception {

		GameState state = new InitialGameState();

		final GameState newState = state.scoredByPlayer1().scoredByPlayer2().scoredByPlayer1().scoredByPlayer2()
				.scoredByPlayer1().scoredByPlayer2().scoredByPlayer1().scoredByPlayer2().scoredByPlayer2()
				.scoredByPlayer1();

		assertEquals("Deuce", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenInitialGameState_PlayerOneScoresFourTimes_shouldBeWinForPlayerOne() throws Exception {

		GameState state = new InitialGameState();

		final GameState newState = state.scoredByPlayer1().scoredByPlayer1().scoredByPlayer1().scoredByPlayer1();

		assertEquals("Win for player1", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenAdvantagePlayer1_whenPlayer2Scores_shouldBeDeuce() throws Exception {

		GameState state = new AdvantagePlayer1GameState();

		final GameState newState = state.scoredByPlayer2();

		assertEquals("Deuce", newState.getGameState("player1", "player2"));
	}

	@Test
	public void givenEventGameStateThreePoints_whenPlayer1Scores_shouldBeAdvantagePlayer1() throws Exception {

		GameState state = new PostDucerGameState(3);

		final GameState newState = state.scoredByPlayer1();

		assertEquals("Advantage player1", newState.getGameState("player1", "player2"));
	}

}
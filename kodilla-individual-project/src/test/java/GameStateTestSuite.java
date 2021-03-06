import com.kodilla.game.logic.GameResult;
import com.kodilla.game.logic.GameState;
import com.kodilla.game.logic.Sign;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class GameStateTestSuite {

    GameState gameState = new GameState();

    @Test
    public void testAddSignAndIsFieldOccupied() {
        //when
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);
        gameState.addSign(2, Sign.CIRCLE);

        //Then
        Assert.assertFalse(gameState.isFieldOccupied(1));
        Assert.assertTrue(gameState.isFieldOccupied(3));
        Assert.assertTrue(gameState.isFieldOccupied(9));
        Assert.assertFalse(gameState.isFieldOccupied(7));
    }

    @Test
    public void testGetGameResultDraw() {
        //Given
        gameState.addSign(1, Sign.CROSS);
        gameState.addSign(2, Sign.CIRCLE);
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(4, Sign.CIRCLE);
        gameState.addSign(5, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);
        gameState.addSign(8, Sign.CROSS);
        gameState.addSign(7, Sign.CIRCLE);
        gameState.addSign(6, Sign.CROSS);

        //Then
        Assert.assertEquals(GameResult.DRAW, gameState.getGameResult());
    }

    @Test
    public void testGetGameResultNoResult() {
        //Given
        gameState.addSign(1, Sign.CROSS);
        gameState.addSign(2, Sign.CIRCLE);
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(4, Sign.CIRCLE);
        gameState.addSign(5, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);
        gameState.addSign(8, Sign.CROSS);
        gameState.addSign(7, Sign.CIRCLE);

        //Then
        Assert.assertEquals(GameResult.NO_RESULT, gameState.getGameResult());
    }

    @Test
    public void testGetGameResultPlayerWon() {
        //Given
        gameState.addSign(1, Sign.CROSS);
        gameState.addSign(2, Sign.CIRCLE);
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(4, Sign.CIRCLE);
        gameState.addSign(5, Sign.CROSS);
        gameState.addSign(8, Sign.CIRCLE);
        gameState.addSign(9, Sign.CROSS);

        //Then
        Assert.assertEquals(GameResult.PLAYER_WON, gameState.getGameResult());
    }

    @Test
    public void testGetGameResultComputerWon() {
        //Given
        gameState.addSign(1, Sign.CROSS);
        gameState.addSign(2, Sign.CIRCLE);
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(5, Sign.CIRCLE);
        gameState.addSign(9, Sign.CROSS);
        gameState.addSign(8, Sign.CIRCLE);

        //Then
        Assert.assertEquals(GameResult.COMPUTER_WON, gameState.getGameResult());
    }

    @Test
    public  void TestClearState() {
        //Given
        gameState.addSign(1, Sign.CROSS);
        gameState.addSign(2, Sign.CIRCLE);
        gameState.addSign(3, Sign.CROSS);

        //when
        gameState.clearState();

        //Then
        Assert.assertFalse(gameState.isFieldOccupied(1));
        Assert.assertFalse(gameState.isFieldOccupied(2));
        Assert.assertFalse(gameState.isFieldOccupied(3));
    }
}


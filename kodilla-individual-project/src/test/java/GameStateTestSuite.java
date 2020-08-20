import com.kodilla.game.*;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class GameStateTestSuite {

    GameState gameState = new GameState();

    @Test
    public void testGetState() {
        //Given
        final Map<Integer, Sign> expectedState = new HashMap<>();
        expectedState.put(3, Sign.CROSS);
        expectedState.put(9, Sign.CIRCLE);
        expectedState.put(2, Sign.CIRCLE);

        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);
        gameState.addSign(2, Sign.CIRCLE);

        //Then
        Assert.assertEquals(expectedState, gameState.getState());
    }

    @Test
    public void testIsFieldOccupied() {
        //Given
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);

        //Then
        Assert.assertTrue(gameState.isFieldOccupied(3));
        Assert.assertFalse(gameState.isFieldOccupied(7));
    }

    @Test
    public void testAddSign() {

        //When
        gameState.addSign(3, Sign.CROSS);
        gameState.addSign(9, Sign.CIRCLE);

        //Then
        Assert.assertEquals(2, gameState.getState().size());
    }

    @Test
    public void testGetGameResult() {
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
}


import com.kodilla.game.*;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;


public class GameStateTestSuite {


    @Test
    public void testGetStateWithMock() {
        //Given
        //SignDrawer signDrawerMock = BDDMockito.mock(SignDrawer.class);

        final Map<Integer, Sign> state = new HashMap<>();
        state.put(3, new Cross());
        state.put(9, new Circle());
        state.put(2, new Circle());
        //when(signDrawerMock.addSign(3, new Cross()).thenReturn(state));

        GameState gameState = new GameState(/*signDrawerMock*/);

        //When
        gameState.getState();

        //Then
        Assert.assertEquals(3, state.size());
    }

    @Test
    public void testIsFieldOccupied() {
        //Given
        GameState gameState = new GameState(/*new SignDrawer()*/);
        //final Map<Integer, Sign> state = new HashMap<>();
        gameState.addSign(3, new Cross());
        gameState.addSign(9, new Circle());

        //When
        //gameState.isFieldOccupied(3);
        //gameState.isFieldOccupied(4);

        //Then
        Assert.assertTrue(gameState.isFieldOccupied(3));
        Assert.assertFalse(gameState.isFieldOccupied(4));
    }

    @Test
    public void testAddSign() {
        //Given
        GameState gameState = new GameState();
        final Map<Integer, Sign> state = new HashMap<>();

        //When
        gameState.addSign(3, new Cross());
        gameState.addSign(9, new Circle());

        //Then
        Assert.assertEquals(2, gameState.getState().size());
    }

    @Test
    public void testGetGameResult() {
        //Given
        GameState gameState = new GameState();
        final Map<Integer, Sign> state = new HashMap<>();
        gameState.addSign(1, new Cross());
        gameState.addSign(2, new Circle());
        gameState.addSign(3, new Cross());
        gameState.addSign(4, new Circle());
        gameState.addSign(5, new Cross());
        gameState.addSign(9, new Circle());
        gameState.addSign(8, new Cross());
        gameState.addSign(7, new Circle());
        gameState.addSign(6, new Cross());

        //When
        gameState.getGameResult();

        //Then
        Assert.assertEquals(GameResult.DRAW, gameState.getGameResult());
    }
}


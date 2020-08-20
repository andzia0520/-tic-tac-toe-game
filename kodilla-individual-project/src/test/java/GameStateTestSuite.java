import com.kodilla.game.*;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GameStateTestSuite {


    @Test
    public void testGetStateWithMock() {
        //Given
        SignDrawer signDrawerMock = mock(SignDrawer.class);
        Cross cross = mock(Cross.class);
        Circle circle = mock(Circle.class);

        final Map<Integer, Sign> expectedState = new HashMap<>();
        expectedState.put(3, cross);
        expectedState.put(9, circle);
        expectedState.put(2, circle);


        GameState gameState = new GameState(signDrawerMock);

        gameState.addSign(3, cross);
        gameState.addSign(9, circle);
        gameState.addSign(2, circle);

        //Then
        Assert.assertEquals(expectedState, gameState.getState());
    }
/*@Ignore
    @Test
    public void testIsFieldOccupied() {
        //Given
        GameState gameState = new GameState(new SignDrawer());
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
@Ignore
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
@Ignore
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
    }*/
}


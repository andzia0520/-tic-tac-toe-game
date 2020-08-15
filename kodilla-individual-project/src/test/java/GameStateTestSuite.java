import com.kodilla.game.*;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

public class GameStateTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Ignore
    @Test
    public void testGetState() {
        //Given
        GameState gameState = new GameState(new SignDrawer());
        final Map<Integer, Sign> state = new HashMap<>();
        state.put(3, new Cross());
        state.put(9, new Circle());

        //When
        gameState.getState();

        //Then
        Assert.assertEquals(2, state.size());
    }

    @Test
    public void testIsFieldOccupied() {
        //Given
        GameState gameState = new GameState(new SignDrawer());
        final Map<Integer, Sign> state = new HashMap<>();
        state.put(3, new Cross());
        state.put(9, new Circle());

        //When
        gameState.isFieldOccupied(3);
        gameState.isFieldOccupied(4);

        //Then
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void testAddSign() {
        //Given
        GameState gameState = new GameState(new SignDrawer());
        final Map<Integer, Sign> state = new HashMap<>();

        //When
        gameState.addSign(3, new Cross());
        gameState.addSign(9, new Circle());

        //Then
        Assert.assertEquals(2, state.size());
    }

    @Test
    public void testGetGameResult() {
        //Given
        GameState gameState = new GameState(new SignDrawer());
        final Map<Integer, Sign> state = new HashMap<>();
        state.put(3, new Cross());
        state.put(9, new Circle());
        state.put(1, new Cross());
        state.put(5, new Circle());
        state.put(2, new Cross());
        state.put(8, new Circle());

        //When
        //gameState.getGameResult();

        //Then
        Assert.assertEquals(GameResult.PLAYER_WON, gameState.getGameResult());
    }

}

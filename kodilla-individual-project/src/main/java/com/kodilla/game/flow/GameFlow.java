package com.kodilla.game.flow;

import com.kodilla.game.logic.ComputersLogic;
import com.kodilla.game.logic.GameResult;
import com.kodilla.game.logic.GameState;
import com.kodilla.game.logic.Sign;
import com.kodilla.game.graphic.Circle;
import com.kodilla.game.graphic.Cross;
import com.kodilla.game.graphic.SignDrawer;
import com.kodilla.game.interaction.ConversionKeyToPosition;
import javafx.scene.input.KeyEvent;

public class GameFlow {

    private final SignDrawer signDrawer;
    private GameState gameState = null;
    private final ComputersLogic computersLogic;
    ConversionKeyToPosition conversion = new ConversionKeyToPosition();

    public GameFlow(SignDrawer signDrawer, GameState gameState, ComputersLogic computersLogic) {
        this.signDrawer = signDrawer;
        this.gameState = gameState;
        this.computersLogic = computersLogic;
    }

    public void handleKey(KeyEvent event) {
        Integer position = conversion.convertKeyToPosition(event);

        if (position == null || gameState.isFieldOccupied(position)) {
            signDrawer.showMessage();
            return;
        }

        gameState.addSign(position, Sign.CROSS);
        signDrawer.addSign(position, new Cross());

        if (gameState.getGameResult() == GameResult.PLAYER_WON) {
            signDrawer.showPlayerWon();
            signDrawer.playAgain();
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            signDrawer.showDraw();
            signDrawer.playAgain();
            return;
        }

        int computerPosition = computersLogic.getComputerTurn();
        gameState.addSign(computerPosition, Sign.CIRCLE);
        signDrawer.addSign(computerPosition, new Circle());

        if (gameState.getGameResult() == GameResult.COMPUTER_WON) {
            signDrawer.showComputerWon();
            signDrawer.playAgain();
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            signDrawer.showDraw();
            signDrawer.playAgain();
            return;
        }
    }
}

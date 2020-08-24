/*
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

    SignDrawer signDrawer;
    GameState gameState;

    public GameFlow(SignDrawer signDrawer, GameState gameState) {
        this.signDrawer = signDrawer;
        this.gameState = gameState;
    }

    ComputersLogic computer = new ComputersLogic(gameState);
    ConversionKeyToPosition conversion = new ConversionKeyToPosition();

    public void onKeyPressed(KeyEvent event) {
        Integer position = conversion.convertKeyToPosition(event);

        if (position == null || gameState.isFieldOccupied(position)) {

            System.out.println("niepoprawny ruch");
            return;
        }

        gameState.addSign(position, Sign.CROSS);
        signDrawer.addSign(position, new Cross());

        if (gameState.getGameResult() == GameResult.PLAYER_WON) {
            System.out.println("You won");
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }

        int computerPosition = computer.getComputerTurn();
        gameState.addSign(computerPosition, Sign.CIRCLE);
        signDrawer.addSign(computerPosition, new Circle());
        if (gameState.getGameResult() == GameResult.COMPUTER_WON) {
            System.out.println("Computer won");
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }
    }
}
*/

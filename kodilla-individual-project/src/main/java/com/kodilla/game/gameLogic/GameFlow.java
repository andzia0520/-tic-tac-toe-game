package com.kodilla.game.gameLogic;

import com.kodilla.game.graphic.Circle;
import com.kodilla.game.graphic.Cross;
import com.kodilla.game.graphic.SignDrawer;
import com.kodilla.game.interactionWithPlayer.ConversionKeyToPosition;
import javafx.scene.input.KeyEvent;

public class GameFlow {

    SignDrawer signDrawer = new SignDrawer();
    GameState state = new GameState();
    ComputersLogic computer = new ComputersLogic(state);
    ConversionKeyToPosition conversion = new ConversionKeyToPosition();

    public void onKeyPressed(KeyEvent event) {
        Integer position = conversion.convertKeyToPosition(event);

        if (position == null || state.isFieldOccupied(position)) {

            System.out.println("niepoprawny ruch");
            return;
        }

        state.addSign(position, Sign.CROSS);
        signDrawer.addSign(position, new Cross());

        if (state.getGameResult() == GameResult.PLAYER_WON) {
            System.out.println("You won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }

        int computerPosition = computer.getComputerTurn();
        state.addSign(computerPosition, Sign.CIRCLE);
        signDrawer.addSign(computerPosition, new Circle());
        if (state.getGameResult() == GameResult.COMPUTER_WON) {
            System.out.println("Computer won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }
    }
}

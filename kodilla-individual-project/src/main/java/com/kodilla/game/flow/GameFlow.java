package com.kodilla.game.flow;

import com.kodilla.game.TicTacToe;
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


    GameState state = new GameState();
    ComputersLogic computer = new ComputersLogic(state);
    ConversionKeyToPosition conversion = new ConversionKeyToPosition();
    TicTacToe tic = new TicTacToe(new SignDrawer());

    public void onKeyPressed(KeyEvent event) {
        Integer position = conversion.convertKeyToPosition(event);

        if (position == null || state.isFieldOccupied(position)) {

            System.out.println("niepoprawny ruch");
            return;
        }

        state.addSign(position, Sign.CROSS);
        tic.getSignDrawer().addSign(position, new Cross());

        if (state.getGameResult() == GameResult.PLAYER_WON) {
            System.out.println("You won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }

        int computerPosition = computer.getComputerTurn();
        state.addSign(computerPosition, Sign.CIRCLE);
        tic.getSignDrawer().addSign(computerPosition, new Circle());
        if (state.getGameResult() == GameResult.COMPUTER_WON) {
            System.out.println("Computer won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }
    }
}

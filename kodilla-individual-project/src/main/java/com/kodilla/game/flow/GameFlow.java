package com.kodilla.game.flow;

import com.kodilla.game.logic.ComputersLogic;
import com.kodilla.game.logic.GameResult;
import com.kodilla.game.logic.GameState;
import com.kodilla.game.logic.Sign;
import com.kodilla.game.graphic.Circle;
import com.kodilla.game.graphic.Cross;
import com.kodilla.game.graphic.SignDrawer;

public class GameFlow {

    private final SignDrawer signDrawer;
    private final GameState gameState;
    private final ComputersLogic computersLogic;


    public GameFlow(SignDrawer signDrawer, GameState gameState, ComputersLogic computersLogic) {
        this.signDrawer = signDrawer;
        this.gameState = gameState;
        this.computersLogic = computersLogic;
    }

    public void handleUserChoice(Integer position) {

        if (position == null || gameState.isFieldOccupied(position)) {
            signDrawer.showMessage();
            return;
        }

        gameState.addSign(position, Sign.CROSS);
        signDrawer.addSign(position, new Cross());

        if (gameState.getGameResult() == GameResult.PLAYER_WON) {
            signDrawer.showPlayerWon();
            signDrawer.playAgainOrClose();
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            signDrawer.showDraw();
            signDrawer.playAgainOrClose();
            return;
        }

        int computerPosition = computersLogic.getComputerTurn();
        gameState.addSign(computerPosition, Sign.CIRCLE);
        signDrawer.addSign(computerPosition, new Circle());

        if (gameState.getGameResult() == GameResult.COMPUTER_WON) {
            signDrawer.showComputerWon();
            signDrawer.playAgainOrClose();
            return;
        } else if (gameState.getGameResult() == GameResult.DRAW) {
            signDrawer.showDraw();
            signDrawer.playAgainOrClose();
            return;
        }
    }

    public void playAgainOrClose() {
        signDrawer.clearBoard();
        gameState.clearState();

    }
}

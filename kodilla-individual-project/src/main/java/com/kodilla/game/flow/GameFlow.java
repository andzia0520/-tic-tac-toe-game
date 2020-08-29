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

        checkIllegalMovement(position);
        addPlayerMove(position);

        GameResult result = gameState.getGameResult();
        if (result == GameResult.PLAYER_WON) {
            signDrawer.showPlayerWon();
            finish();
            return;
        } else if (result == GameResult.DRAW) {
            signDrawer.showDraw();
            finish();
            return;
        }

        addComputerMove();

        GameResult gameResult = gameState.getGameResult();
        if (gameResult == GameResult.COMPUTER_WON) {
            signDrawer.showComputerWon();
            finish();
        } else if (gameResult == GameResult.DRAW) {
            signDrawer.showDraw();
            finish();
        }
    }

    private void checkIllegalMovement(Integer position) {
        if (position == null || gameState.isFieldOccupied(position)) {
            signDrawer.showIllegalMovement();
        }
    }

    private void addPlayerMove(Integer position) {
        gameState.addSign(position, Sign.CROSS);
        signDrawer.addSign(position, new Cross());
    }

    private void addComputerMove() {
        int computerPosition = computersLogic.getComputerTurn();
        gameState.addSign(computerPosition, Sign.CIRCLE);
        signDrawer.addSign(computerPosition, new Circle());
    }

    private void playAgain() {
        gameState.clearState();
        signDrawer.clearBoard();
    }

    private void finish() {
        if (signDrawer.playAgainOrClose()) {
            playAgain();
        }
    }
}


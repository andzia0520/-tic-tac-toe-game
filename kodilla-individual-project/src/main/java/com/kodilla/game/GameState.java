package com.kodilla.game;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameState {

    private final SignDrawer signDrawer;
    private final Map<Integer, Sign> state = new HashMap<>();

    public GameState(SignDrawer signDrawer) {
        this.signDrawer = signDrawer;
    }

    public Map<Integer, Sign> getState() {
        return state;
    }

    public boolean isFieldOccupied(int position) {
        return state.containsKey(position);
    }

    public void addSign(int position, Sign sign) {
        state.put(position, sign);
        signDrawer.addSign(position, sign);
    }

    public GameResult getGameResult() {

        Set<Integer> playerPosition = getPlayersPositions(entry -> entry.getValue().isCross());

        Set<Integer> computerPositions = getPlayersPositions(entry -> !entry.getValue().isCross());

        if (isWinning(playerPosition)) {
            return GameResult.PLAYER_WON;
        } else if (isWinning(computerPositions)) {
            return GameResult.COMPUTER_WON;
        } else if (state.size() == 9) {
            return GameResult.DRAW;
        } else {
            return GameResult.NO_RESULT;
        }
    }

    private boolean isWinning(Set<Integer> positions) {

        return (positions.contains(1) && positions.contains(2) && positions.contains(3))
                || (positions.contains(4) && positions.contains(5) && positions.contains(6))
                || (positions.contains(7) && positions.contains(8) && positions.contains(9))
                || (positions.contains(1) && positions.contains(4) && positions.contains(7))
                || (positions.contains(2) && positions.contains(5) && positions.contains(8))
                || (positions.contains(3) && positions.contains(6) && positions.contains(9))
                || (positions.contains(1) && positions.contains(5) && positions.contains(9))
                || (positions.contains(3) && positions.contains(5) && positions.contains(7));
    }

    private Set<Integer> getPlayersPositions(Predicate<Map.Entry<Integer, Sign>> filterPredicate) {
        return state.entrySet().stream()
                .filter(filterPredicate)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}




package com.kodilla.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

        Set<Integer> playerPositions = state.entrySet().stream()
                .filter(entry -> entry.getValue().isCross())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        Set<Integer> computerPositions = state.entrySet().stream()
                .filter(entry -> !entry.getValue().isCross())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        Set<Integer> positions = new HashSet<>(state.keySet());

        if ((playerPositions.contains(1) && playerPositions.contains(2) && playerPositions.contains(3))
                || (playerPositions.contains(4) && playerPositions.contains(5) && playerPositions.contains(6))
                || (playerPositions.contains(7) && playerPositions.contains(8) && playerPositions.contains(9))
                || (playerPositions.contains(1) && playerPositions.contains(4) && playerPositions.contains(7))
                || (playerPositions.contains(2) && playerPositions.contains(5) && playerPositions.contains(8))
                || (playerPositions.contains(3) && playerPositions.contains(6) && playerPositions.contains(9))
                || (playerPositions.contains(1) && playerPositions.contains(5) && playerPositions.contains(9))
                || (playerPositions.contains(3) && playerPositions.contains(5) && playerPositions.contains(7))) {

            return GameResult.PLAYER_WON;

        } else if ((computerPositions.contains(1) && computerPositions.contains(2) && computerPositions.contains(3))
                || (computerPositions.contains(4) && computerPositions.contains(5) && computerPositions.contains(6))
                || (computerPositions.contains(7) && computerPositions.contains(8) && computerPositions.contains(9))
                || (computerPositions.contains(1) && computerPositions.contains(4) && computerPositions.contains(7))
                || (computerPositions.contains(2) && computerPositions.contains(5) && computerPositions.contains(8))
                || (computerPositions.contains(3) && computerPositions.contains(6) && computerPositions.contains(9))
                || (computerPositions.contains(1) && computerPositions.contains(5) && computerPositions.contains(9))
                || (computerPositions.contains(3) && computerPositions.contains(5) && computerPositions.contains(7))) {

            return GameResult.COMPUTER_WON;

        } else if (positions.size() == 9) {

            return GameResult.DRAW;

        } else {
            return GameResult.NO_RESULT;
        }

    }
}


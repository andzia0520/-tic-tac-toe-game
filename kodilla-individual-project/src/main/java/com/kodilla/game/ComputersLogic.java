package com.kodilla.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputersLogic {

    private final GameState state;
    private final Random random = new Random();

    public ComputersLogic(GameState state) {
        this.state = state;
    }

    public int getComputerTurn() {
        List<Integer> freeFields = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!state.isFieldOccupied(i)) {
                freeFields.add(i);
            }
        }
        return freeFields.get(random.nextInt(freeFields.size()));
    }
}


package com.kodilla.game;

import java.util.HashMap;
import java.util.Map;

public class GameState {

    private final SignDrawer signDrawer;

    private Map<Integer, Sign> state = new HashMap<>();

    public GameState(SignDrawer signDrawer) {
        this.signDrawer = signDrawer;
    }

    public Map<Integer, Sign> getState() {
        return state;
    }

    public void addSign(int position, Sign sign) {
        state.put(position, sign);
        signDrawer.addSign(position, sign);
    }
public boolean isFinnished() {
        return false;
}
    //sprawdza aktualny stan ggry i sprawdza czy ktos wygrał , kto wygrał
}


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

        }      else if(positions.size() == 9) {

            return GameResult.DRAW;

        } else {
            return GameResult.NO_RESULT;
        }

    }
}


// poniższa metoda to Sprawdzenie czy pole nie jest zajęte – czyli sprawdzenie czy mapa zawiera
// już ten klucz Chciałam skorzystać z metody containsKey i w klasie GameState napisać ogólnie
// a konkretne klucze np.2 , 3 , wstawiać w TICTacToe  i spiąć to z wyborem gracza ale nie wiem
// co wpisac w linii 31 GameState  - wiem ze klucz ale co tu ma być? Integer, int position nie działa, tylko jak wpiszę konkretna cyfrę

/*
    public void gameResult() {

        For(Map.Entry < Integer, Sign > entry :state.entrySet())
        if (entry.getValue(1 && 2 && 3)
        1 && 2 && 3 || 4 && 5 && 6 || 7 && 8 && 9 || 1 && 4 && 7 || 2 && 5 && 8 || 3 && 6 && 9 || 1 && 5 && 9 || 3 && 5 && 7
        eguals new Circle){
            System.out.println("wygrał komputer");

        }
        if else
        (1 && 2 && 3 || 4 && 5 && 6 || 7 && 8 && 9 || 1 && 4 && 7 || 2 && 5 && 8 || 3 && 6 && 9 || 1 && 5 && 9 || 3 && 5 && 7
        eguals new Cross){
            System.out.println("Gratulacje, wygrałeś");

        } else{
            System.out.println("Remis");
        }

        public boolean isFinished () {
            if (ktoś wygrał lub remis ) {
                return true;
            } else{
                return false;
            }
        }
    }*/



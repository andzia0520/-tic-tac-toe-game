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


    // poniższa metoda to Sprawdzenie czy pole nie jest zajęte – czyli sprawdzenie czy mapa zawiera
// już ten klucz Chciałam skorzystać z metody containsKey i w klasie GameState napisać ogólnie
// a konkretne klucze np.2 , 3 , wstawiać w TICTacToe  i spiąć to z wyborem gracza ale nie wiem
// co wpisac w linii 31 GameState  - wiem ze klucz ale co tu ma być? Integer, int position nie działa, tylko jak wpiszę konkretna cyfrę
    public boolean occupiedField() {
        if (state.containsKey(Integer)) {
            return true;
        } else {
            return false;
        }
    }

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
    }
}


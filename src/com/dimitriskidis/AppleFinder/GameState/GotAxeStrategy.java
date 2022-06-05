package com.dimitriskidis.AppleFinder.GameState;
import com.dimitriskidis.AppleFinder.Entity.Player;

public class GotAxeStrategy implements Strategy{
    private Player p;
    public GotAxeStrategy(Player p) {
        this.p = p;
    }
    @Override
    public void collectItem() {
        p.gotAxe();
    }
}

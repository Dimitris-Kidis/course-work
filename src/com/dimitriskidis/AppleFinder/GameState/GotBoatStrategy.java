package com.dimitriskidis.AppleFinder.GameState;
import com.dimitriskidis.AppleFinder.Entity.Player;


public class GotBoatStrategy implements Strategy{
    private Player p;
    public GotBoatStrategy(Player p) {
        this.p = p;
    }

    @Override
    public void collectItem() {
        p.gotBoat();
    }
}

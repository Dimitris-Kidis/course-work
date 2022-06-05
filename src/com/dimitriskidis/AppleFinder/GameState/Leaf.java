package com.dimitriskidis.AppleFinder.GameState;

import com.dimitriskidis.AppleFinder.Entity.Apple;
import com.dimitriskidis.AppleFinder.TileMap.TileMap;

import java.util.ArrayList;

public class Leaf implements Component{
    private Apple a;
    private TileMap tileMap;
    private int x;
    private int y;
    private ArrayList<Apple> apples;

    public Leaf(Apple a,TileMap tileMap, int x, int y, ArrayList<Apple> apples) {
        this.a = a;
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.apples = apples;
    }

    @Override
    public void setApplesOnMap() {
        a = new Apple(tileMap);
        a.setTilePosition(x, y);
        apples.add(a);
    }
}

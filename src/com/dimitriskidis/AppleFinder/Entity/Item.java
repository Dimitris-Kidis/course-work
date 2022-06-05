

package com.dimitriskidis.AppleFinder.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dimitriskidis.AppleFinder.GameState.Context;
import com.dimitriskidis.AppleFinder.GameState.GotAxeStrategy;
import com.dimitriskidis.AppleFinder.GameState.GotBoatStrategy;
import com.dimitriskidis.AppleFinder.GameState.Strategy;
import com.dimitriskidis.AppleFinder.Manager.Content;
import com.dimitriskidis.AppleFinder.TileMap.TileMap;

public class Item extends Entity{
	
	private BufferedImage sprite;
	private int type;
	public static final int BOAT = 0;
	public static final int AXE = 1;
	
	public Item(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 12;
	}
	
	public void setType(int i) {
		type = i;
		if(type == BOAT) {
			sprite = Content.ITEMS[1][0];
		}
		else if(type == AXE) {
			sprite = Content.ITEMS[1][1];
		}
	}
	
	public void collected(Player p) {
		// STRATEGY PATTERN
		Context context = new Context();
		if(type == BOAT) {
			Strategy strBoat = new GotBoatStrategy(p);
			context.setStrategy(strBoat);
			context.executeStrategy();
		}
		if(type == AXE) {
			Strategy strAxe = new GotAxeStrategy(p);
			context.setStrategy(strAxe);
			context.executeStrategy();
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}

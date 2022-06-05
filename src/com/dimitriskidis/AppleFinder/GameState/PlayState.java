

package com.dimitriskidis.AppleFinder.GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.dimitriskidis.AppleFinder.Entity.Apple;
import com.dimitriskidis.AppleFinder.Entity.Item;
import com.dimitriskidis.AppleFinder.Entity.Player;
import com.dimitriskidis.AppleFinder.Entity.Sparkle;
import com.dimitriskidis.AppleFinder.HUD.Hud;
import com.dimitriskidis.AppleFinder.Main.GamePanel;
import com.dimitriskidis.AppleFinder.Manager.Data;
import com.dimitriskidis.AppleFinder.Manager.GameStateManager;
import com.dimitriskidis.AppleFinder.Manager.JukeBox;
import com.dimitriskidis.AppleFinder.Manager.Keys;
import com.dimitriskidis.AppleFinder.TileMap.TileMap;

public class PlayState extends GameState {
	
	private Player player;
	
	private TileMap tileMap;
	
	private ArrayList<Apple> apples;
	
	private ArrayList<Item> items;
	
	private ArrayList<Sparkle> sparkles;
	
	private int xsector;
	private int ysector;
	private int sectorSize; 
	
	private Hud hud;
	
	private boolean blockInput;
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
	
	private ArrayList<Rectangle> boxes;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		apples = new ArrayList<Apple>();
		sparkles = new ArrayList<Sparkle>();
		items = new ArrayList<Item>();
		
		tileMap = new TileMap(16);
		tileMap.loadTiles("/Tilesets/testtileset.gif");
		tileMap.loadMap("/Maps/testmap.map");
		
		player = new Player(tileMap);
		
		populateApples();
		populateItems();
		
		player.setTilePosition(17, 17);
		player.setTotalApples(apples.size());
		
		sectorSize = GamePanel.WIDTH;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
		
		hud = new Hud(player, apples);
		
		JukeBox.load("/Music/bgmusic.mp3", "music1");
		JukeBox.setVolume("music1", -10);
		JukeBox.loop("music1", 1000, 1000, JukeBox.getFrames("music1") - 1000);
		JukeBox.load("/Music/finish.mp3", "finish");
		JukeBox.setVolume("finish", -10);
		
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/mapmove.wav", "mapmove");
		JukeBox.load("/SFX/tilechange.wav", "tilechange");
		JukeBox.load("/SFX/splash.wav", "splash");
		
		boxes = new ArrayList<Rectangle>();
		eventStart = true;
		eventStart();
			
	}
	
	private void populateApples() {

		Apple a;

		a = new Apple(tileMap);
		a.setTilePosition(20, 20);
		a.addChange(new int[] { 23, 19, 1 });
		a.addChange(new int[] { 23, 20, 1 });
		apples.add(a);
		a = new Apple(tileMap);
		a.setTilePosition(12, 36);
		a.addChange(new int[] { 31, 17, 1 });
		apples.add(a);
		a = new Apple(tileMap);
		a.setTilePosition(28, 4);
		a.addChange(new int[] {27, 7, 1});
		a.addChange(new int[] {28, 7, 1});
		apples.add(a);
		a = new Apple(tileMap);
		a.setTilePosition(4, 34);
		a.addChange(new int[] { 31, 21, 1 });
		apples.add(a);


		// COMPOSITE PATTERN
		Leaf apple1 = new Leaf(a, tileMap, 28, 19, apples);
		Leaf apple2 = new Leaf(a, tileMap, 35, 26, apples);
		Leaf apple3 = new Leaf(a, tileMap, 38, 36, apples);
		Leaf apple4 = new Leaf(a, tileMap, 27, 28, apples);
		Leaf apple5 = new Leaf(a, tileMap, 20, 30, apples);
		Leaf apple6 = new Leaf(a, tileMap, 14, 25, apples);
		Leaf apple7 = new Leaf(a, tileMap, 4, 21, apples);
		Leaf apple8 = new Leaf(a, tileMap, 9, 14, apples);
		Leaf apple9 = new Leaf(a, tileMap, 4, 3, apples);
		Leaf apple10 = new Leaf(a, tileMap, 20, 14, apples);
		Leaf apple11 = new Leaf(a, tileMap, 13, 20, apples);

		Composite composite1 = new Composite();

		composite1.addComponent(apple1);
		composite1.addComponent(apple2);
		composite1.addComponent(apple3);
		composite1.addComponent(apple4);
		composite1.addComponent(apple5);
		composite1.addComponent(apple6);
		composite1.addComponent(apple7);
		composite1.addComponent(apple8);
		composite1.addComponent(apple9);
		composite1.addComponent(apple10);
		composite1.addComponent(apple11);

		composite1.setApplesOnMap();

//		a = new Apple(tileMap);
//		a.setTilePosition(28, 19);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(35, 26);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(38, 36);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(27, 28);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(20, 30);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(14, 25);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(4, 21);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(9, 14);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(4, 3);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(20, 14);
//		apples.add(a);
//		a = new Apple(tileMap);
//		a.setTilePosition(13, 20);
//		apples.add(a);
	}
	
	private void populateItems() {
		
		Item item;
		
		item = new Item(tileMap);
		item.setType(Item.AXE);
		item.setTilePosition(26, 37);
		items.add(item);
		
		item = new Item(tileMap);
		item.setType(Item.BOAT);
		item.setTilePosition(12, 4);
		items.add(item);
		
	}
	
	public void update() {
		
		handleInput();
		
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
		
		if(player.numApples() == player.getTotalApples()) {
			eventFinish = blockInput = true;
		}
		
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap.update();
		
		if(oldxs != xsector || oldys != ysector) {
			JukeBox.play("mapmove");
		}
		
		if(tileMap.isMoving()) return;
		
		player.update();
		
		for(int i = 0; i < apples.size(); i++) {
			
			Apple d = apples.get(i);
			d.update();
			
			if(player.intersects(d)) {
				
				apples.remove(i);
				i--;
				
				player.collectedApple();
				
				JukeBox.play("collect");
				
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(d.getx(), d.gety());
				sparkles.add(s);
				
				ArrayList<int[]> ali = d.getChanges();
				for(int[] j : ali) {
					tileMap.setTile(j[0], j[1], j[2]);
				}
				if(ali.size() != 0) {
					JukeBox.play("tilechange");
				}
				
			}
		}
		
		for(int i = 0; i < sparkles.size(); i++) {
			Sparkle s = sparkles.get(i);
			s.update();
			if(s.shouldRemove()) {
				sparkles.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(player.intersects(item)) {
				items.remove(i);
				i--;
				item.collected(player);
				JukeBox.play("collect");
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(item.getx(), item.gety());
				sparkles.add(s);
			}
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		tileMap.draw(g);
		
		player.draw(g);
		
		for(Apple d : apples) {
			d.draw(g);
		}
		
		for(Sparkle s : sparkles) {
			s.draw(g);
		}
		
		for(Item i : items) {
			i.draw(g);
		}
		
		hud.draw(g);
		
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < boxes.size(); i++) {
			g.fill(boxes.get(i));
		}
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			JukeBox.stop("music1");
			gsm.setPaused(true);
		}
		if(blockInput) return;
		if(Keys.isDown(Keys.LEFT)) player.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player.setRight();
		if(Keys.isDown(Keys.UP)) player.setUp();
		if(Keys.isDown(Keys.DOWN)) player.setDown();
		if(Keys.isPressed(Keys.SPACE)) player.setAction();
	}
	
	//===============================================
	
	private void eventStart() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				boxes.add(new Rectangle(0, i * 16, GamePanel.WIDTH, 16));
			}
		}
		if(eventTick > 1 && eventTick < 32) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					r.x -= 4;
				}
				else {
					r.x += 4;
				}
			}
		}
		if(eventTick == 33) {
			boxes.clear();
			eventStart = false;
			eventTick = 0;
		}
	}
	
	private void eventFinish() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				if(i % 2 == 0) boxes.add(new Rectangle(-128, i * 16, GamePanel.WIDTH, 16));
				else boxes.add(new Rectangle(128, i * 16, GamePanel.WIDTH, 16));
			}
			JukeBox.stop("music1");
			JukeBox.play("finish");
		}
		if(eventTick > 1) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					if(r.x < 0) r.x += 4;
				}
				else {
					if(r.x > 0) r.x -= 4;
				}
			}
		}
		if(eventTick > 33) {
			if(!JukeBox.isPlaying("finish")) {
				Data.setTime(player.getTicks());
				gsm.setState(GameStateManager.GAMEOVER);
			}
		}
	}
	
}

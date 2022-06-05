

package com.dimitriskidis.AppleFinder.GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dimitriskidis.AppleFinder.Main.GamePanel;
import com.dimitriskidis.AppleFinder.Manager.Content;
import com.dimitriskidis.AppleFinder.Manager.Data;
import com.dimitriskidis.AppleFinder.Manager.GameStateManager;
import com.dimitriskidis.AppleFinder.Manager.JukeBox;
import com.dimitriskidis.AppleFinder.Manager.Keys;

public class GameOverState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;

	private BufferedImage backScreen;


	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		backScreen = Content.BACKSCREEN[0][0];
//		color = new Color(111, 3, 88);

		ticks = Data.getTime();
		if(ticks < 3600) rank = 1;       // 2 minutes
		else if(ticks < 5400) rank = 2;  // 3 minutes
		else if(ticks < 7200) rank = 3;  // 4 minutes
		else rank = 4;
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(backScreen, 0, 0, null);
//		g.setColor(color);
//		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "finish time", 20, 36);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, minutes + ":" + seconds, 44, 48);
		}
		
		Content.drawString(g, "rank", 48, 66);
		if(rank == 1) Content.drawString(g, "speed demon", 20, 78);
		else if(rank == 2) Content.drawString(g, "adventurer", 24, 78);
		else if(rank == 3) Content.drawString(g, "beginner", 32, 78);
		else if(rank == 4) Content.drawString(g, "Turtle", 8, 78);
		
		Content.drawString(g, "Press enter", 19, 110);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}

}
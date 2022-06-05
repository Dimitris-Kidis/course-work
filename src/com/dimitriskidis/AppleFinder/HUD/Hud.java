// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package com.dimitriskidis.AppleFinder.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.dimitriskidis.AppleFinder.Entity.Apple;
import com.dimitriskidis.AppleFinder.Entity.Player;
import com.dimitriskidis.AppleFinder.Manager.Content;
import com.dimitriskidis.AppleFinder.Main.GamePanel;

public class Hud {
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage apple;
	private BufferedImage boat;
	private BufferedImage axe;
	
	private Player player;
	
	private int numApples;
	
	private Font font;
	private Color textColor; 
	
	public Hud(Player p, ArrayList<Apple> d) {
		
		player = p;
		numApples = d.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		apple = Content.APPLE[0][0];
		boat = Content.ITEMS[0][0];
		axe = Content.ITEMS[0][1];
		
		font = new Font("Arial", Font.PLAIN, 10);
		textColor = new Color(148, 65, 180);
		
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bar, 0, yoffset, null);
		
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(28.0 * player.numApples() / numApples), 4);
		
		g.setColor(textColor);
		g.setFont(font);
		String s = player.numApples() + "/" + numApples;
		Content.drawString(g, s, 40, yoffset + 3);
		if(player.numApples() >= 10) g.drawImage(apple, 80, yoffset, null);
		else g.drawImage(apple, 72, yoffset, null);
		
		if(player.hasBoat()) g.drawImage(boat, 100, yoffset, null);
		if(player.hasAxe()) g.drawImage(axe, 112, yoffset, null);
		
		int minutes = (int) (player.getTicks() / 1800);
		int seconds = (int) ((player.getTicks() / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 85, 3);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, minutes + ":" + seconds, 85, 3);
		}
		
		
		
	}
	
}

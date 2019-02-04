
package com.neet.JavaKing.GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException; 

import com.neet.JavaKing.Main.GamePanel;
import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.Manager.Data;
import com.neet.JavaKing.Manager.GameStateManager;
import com.neet.JavaKing.Manager.JukeBox;
import com.neet.JavaKing.Manager.Keys;

public class InfoState extends GameState {
	
	private Color color;
	
	public InfoState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(164, 198, 222);
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "Key Info", 14, 10);
		Content.drawString(g, "move: arrow", 14, 35);
		Content.drawString(g, "space: action", 14, 47);
		Content.drawString(g, "esc: pause", 14, 59);
		Content.drawString(g, "F1: ", 14, 71);
		Content.drawString(g, "Go to menu", 14, 83);
		Content.drawString(g, "in pause", 14, 95);
		Content.drawString(g, "press ENTER", 14, 120);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}
	
}
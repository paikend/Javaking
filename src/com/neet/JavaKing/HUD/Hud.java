// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package com.neet.JavaKing.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.neet.JavaKing.Entity.Book;
import com.neet.JavaKing.Entity.Player;
import com.neet.JavaKing.Main.GamePanel;
import com.neet.JavaKing.Manager.Content;

public class Hud {
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage book;
	private BufferedImage Key1;
	private BufferedImage Key2;
	private BufferedImage Key3;
	
	private Player player;
	
	private int numBooks;
	
	private Font font;
	private Color textColor; 
	
	public Hud(Player p, ArrayList<Book> d) {
		
		player = p;
		numBooks = d.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		book = Content.BOOK[0][0];
		Key1 = Content.ITEMS[0][0];
		Key2 = Content.ITEMS[0][1];
		Key3 = Content.ITEMS[0][2];
		
		font = new Font("Arial", Font.PLAIN, 10);
		textColor = new Color(47, 64, 126);
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw hud
		g.drawImage(bar, 0, yoffset, null);
		
		// draw book bar
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(28.0 * player.numBooks() / numBooks), 4);
		
		// draw book amount
		g.setColor(textColor);
		g.setFont(font);
		String s = player.numBooks() + "/" + numBooks;
		Content.drawString(g, s, 40, yoffset + 3);
		if(player.numBooks() >= 10) g.drawImage(book, 80, yoffset, null);
		else g.drawImage(book, 72, yoffset, null);
		
		// draw items
		if(player.hasKey1()) g.drawImage(Key1, 88, yoffset, null);
		if(player.hasKey2()) g.drawImage(Key2, 100, yoffset, null);
		if(player.hasKey3()) g.drawImage(Key3, 112, yoffset, null);
		
		// draw time
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

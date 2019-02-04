//Show Ranking 

package com.neet.JavaKing.GameState;
import java.sql.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.neet.JavaKing.Main.GamePanel;
import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.Manager.Data;
import com.neet.JavaKing.Manager.GameStateManager;
import com.neet.JavaKing.Manager.JukeBox;
import com.neet.JavaKing.Manager.Keys;

public class RankState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;
	
	public RankState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(164, 198, 222);
		ticks = Data.getTime();
		if(ticks < 3600) rank = 1;
		else if(ticks < 5400) rank = 2;
		else if(ticks < 7200) rank = 3;
		else rank = 4;
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);

		Content.drawString(g, "RANKING", 14, 10);
		Content.drawString(g, "NO", 14, 30);
		Content.drawString(g, "NAME", 38, 30);
		Content.drawString(g, "TIME", 80, 30);
		int i=1;
		int y= 40;
		
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/javaking_db";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
		       
			String query = "SELECT * FROM javaking_table ORDER BY ticks ASC";
			Statement st = conn.createStatement();
		       
			ResultSet rs = st.executeQuery(query);
		       
			while (rs.next()) {
				long ticks_r = rs.getInt("ticks");
				String Name = rs.getString("Name");

		         
		        // print the results
		       
				if(i==6){
						break;
				}
					
				Content.drawString(g, ""+ i, 18, y);
				Content.drawString(g, Name, 38, y);
				i++;
				
				int minutes = (int) (ticks_r / 1800);
				int seconds = (int) ((ticks_r / 30) % 60);
				if(minutes < 10) {
					if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 80, y);
					else Content.drawString(g, "0" + minutes + ":" + seconds, 80, y);
				}
				else {
					if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 80, y);
					else Content.drawString(g, minutes + ":" + seconds, 80, y);
				}
					
				y+=10;
			}
			
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		Content.drawString(g, "press ENTER", 14, 120);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}
	
}
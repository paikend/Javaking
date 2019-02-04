
package com.neet.JavaKing.GameState;

import java.sql.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException; 

import com.neet.JavaKing.Main.GamePanel;
import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.Manager.Data;
import com.neet.JavaKing.Manager.GameStateManager;
import com.neet.JavaKing.Manager.JukeBox;
import com.neet.JavaKing.Manager.Keys;


public class NameState extends GameState {
	
	public String Name = "";
	private Color color;
	private long ticks;
	
	public NameState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(164, 198, 222);
		ticks = Data.getTime();
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "time : ", 9, 30);
		
		Content.drawString(g, "name :  " +Name, 9, 40);
		
		Content.drawString(g, "press ENTER", 18, 110);
		
	    if(minutes < 10) {
	    	if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 70, 30);
	    	else Content.drawString(g, "0" + minutes + ":" + seconds, 70, 30);
	    }	else {
	    	if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 70, 30);
	    	else Content.drawString(g, minutes + ":" + seconds, 70, 30);
	    } 
	}
	
	public void handleInput() {
		if(Name.length() <3) {
			if(Keys.isPressed(Keys.A))
				Name = Name + "A";
			else if(Keys.isPressed(Keys.B))
				Name = Name + "B";
			else if(Keys.isPressed(Keys.C))
				Name = Name + "C";
			else if(Keys.isPressed(Keys.D))
				Name = Name + "D";
			else if(Keys.isPressed(Keys.E))
				Name = Name + "E";
			else if(Keys.isPressed(Keys.F))
				Name = Name + "F";
			else if(Keys.isPressed(Keys.G))
				Name = Name + "G";
			else if(Keys.isPressed(Keys.H))
				Name = Name + "H";
			else if(Keys.isPressed(Keys.I))
				Name = Name + "I";
			else if(Keys.isPressed(Keys.J))
				Name = Name + "J";
			else if(Keys.isPressed(Keys.K))
				Name = Name + "K";
			else if(Keys.isPressed(Keys.L))
				Name = Name + "L";
			else if(Keys.isPressed(Keys.M))
				Name = Name + "M";
			else if(Keys.isPressed(Keys.N))
				Name = Name + "N";
			else if(Keys.isPressed(Keys.O))
				Name = Name + "O";
			else if(Keys.isPressed(Keys.P))
				Name = Name + "P";
			else if(Keys.isPressed(Keys.Q))
				Name = Name + "Q";
			else if(Keys.isPressed(Keys.R))
				Name = Name + "R";
			else if(Keys.isPressed(Keys.S))
				Name = Name + "S";
			else if(Keys.isPressed(Keys.T))
				Name = Name + "T";
			else if(Keys.isPressed(Keys.U))
				Name = Name + "U";
			else if(Keys.isPressed(Keys.V))
				Name = Name + "V";
			else if(Keys.isPressed(Keys.W))
				Name = Name + "W";
			else if(Keys.isPressed(Keys.X))
				Name = Name + "X";
			else if(Keys.isPressed(Keys.Y))
				Name = Name + "Y";
			else if(Keys.isPressed(Keys.Z))
				Name = Name + "Z";
		}
			
		if(Keys.isPressed(Keys.BACK_SPACE)) {
			if(Name.length() != 0 )
				Name =Name.substring(0, Name.length()-1) ;
		}
		
		else if(Keys.isPressed(Keys.ENTER)) {
			try {
				String myDriver = "org.gjt.mm.mysql.Driver";
				String myUrl = "jdbc:mysql://localhost/javaking_db";
				Class.forName(myDriver);
				Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
				String query = " insert into javaking_table (ticks,Name)" + " values (?,?)";
		 
		     
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setLong(1,ticks);
				preparedStmt.setString(2, Name);
				preparedStmt.execute();
		       
				conn.close();
			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
		else if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}
}
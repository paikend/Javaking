// The main menu GameState.

package com.neet.JavaKing.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.Manager.GameStateManager;
import com.neet.JavaKing.Manager.JukeBox;
import com.neet.JavaKing.Manager.Keys;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage book;
	
	private int currentOption = 0;
	private String[] options = {
		"START",
		"INFO",
		"RANK",
		"WEBSITE",
		"QUIT"
	};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		book = Content.BOOK[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		
		Content.drawString(g, options[0], 44, 80);
		Content.drawString(g, options[1], 48, 90);
		Content.drawString(g, options[2], 48, 100);
		Content.drawString(g, options[3], 38, 110);
		Content.drawString(g, options[4], 48, 120);
		
		if(currentOption == 0) g.drawImage(book, 20, 76, null);
		else if(currentOption == 1) g.drawImage(book, 20, 86, null);
		else if(currentOption == 2) g.drawImage(book, 20, 96, null);
		else if(currentOption == 3) g.drawImage(book, 20, 106, null);
		else if(currentOption == 4) g.drawImage(book, 20, 116, null);
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
			JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if(currentOption == 1) {
			gsm.setState(GameStateManager.INFO);
		}
		if(currentOption == 2) {
			gsm.setState(GameStateManager.RANK);
		}
		if(currentOption == 3) {
			ProcessBuilder builder = new ProcessBuilder("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "http://127.0.0.1:3000/"); 
			try {
				Process process = builder.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(currentOption == 4) {
			System.exit(0);
		}
	}
	
}

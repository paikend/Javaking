// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.JavaKing.Main;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Java King");
		
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

// The only subclass the fully utilizes the
// Entity superclass (no other class requires
// movement in a tile based map).
// Contains all the gameplay associated with
// the Player.

package com.neet.JavaKing.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.Manager.JukeBox;
import com.neet.JavaKing.TileMap.TileMap;

public class Player extends Entity {
	
	// sprites
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	
	// animation
	private final int DOWN = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	// gameplay
	private int numBooks;
	private int totalBooks;
	private boolean hasKey1;
	private boolean hasKey2;
	private boolean hasKey3;
	private long ticks;
	
	public Player(TileMap tm) {
		
		super(tm);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		moveSpeed = 8;
		
		numBooks = 0;
		
		downSprites = Content.PLAYER[0];
		leftSprites = Content.PLAYER[1];
		rightSprites = Content.PLAYER[2];
		upSprites = Content.PLAYER[3];
		
		animation.setFrames(downSprites);
		animation.setDelay(10);
		
	}
	
	private void setAnimation(int i, BufferedImage[] bi, int d) {
		currentAnimation = i;
		animation.setFrames(bi);
		animation.setDelay(d);
	}
	
	public void collectedBook() { numBooks++; }
	public int numBooks() { return numBooks; }
	public int getTotalBooks() { return totalBooks; }
	public void setTotalBooks(int i) { totalBooks = i; }
	
	public void gotKey1() { hasKey1 = true; }
	public void gotKey2() { hasKey2 = true; }
	public void gotKey3() { hasKey3 = true; }
	public boolean hasKey1() { return hasKey1; }
	public boolean hasKey2() { return hasKey2; }
	public boolean hasKey3() { return hasKey3; }
	
	// Used to update time.
	public long getTicks() { return ticks; }
	
	// Keyboard input. Moves the player.
	public void setDown() {
		super.setDown();
	}
	public void setLeft() {
		super.setLeft();
	}
	public void setRight() {
		super.setRight();
	}
	public void setUp() {
		super.setUp();
	}
	
	// Keyboard input.
	// If Player has Key, doors in front
	// of the Player will be opened.
	public void setAction() {
		
		if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 21) {
			tileMap.setTile(rowTile - 1, colTile, 4);
			tileMap.setTile(rowTile - 1, colTile + 1, 4);
			JukeBox.play("tilechange");	
		}
		if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 22) {
			tileMap.setTile(rowTile - 1, colTile, 4);
			tileMap.setTile(rowTile - 1, colTile - 1, 4);
			JukeBox.play("tilechange");
		}
		
		if(hasKey1) {
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 24) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile + 1, 4);
				JukeBox.play("tilechange");	
			}
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 25) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile - 1, 4);
				JukeBox.play("tilechange");
			}
		}
		
		if(hasKey2) {
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 26) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile + 1, 4);
				JukeBox.play("tilechange");	
			}
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 27) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile - 1, 4);
				JukeBox.play("tilechange");
			}
		}
		
		if(hasKey3) {
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 28) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile + 1, 4);
				JukeBox.play("tilechange");	
			}
			if(currentAnimation == UP && tileMap.getIndex(rowTile - 1, colTile) == 29) {
				tileMap.setTile(rowTile - 1, colTile, 4);
				tileMap.setTile(rowTile - 1, colTile - 1, 4);
				JukeBox.play("tilechange");
			}
		}
	}
	
	public void update() {
		
		ticks++;
		
		// set animation
		if(down && currentAnimation != DOWN) {
				setAnimation(DOWN, downSprites, 10);
		}
		if(left && currentAnimation != LEFT) {
				setAnimation(LEFT, leftSprites, 10);
		}
		if(right && currentAnimation != RIGHT) {
				setAnimation(RIGHT, rightSprites, 10);
		}
		if(up && currentAnimation != UP) {
				setAnimation(UP, upSprites, 10);
		}
		
		// update position
		super.update();
		
	}
	
	// Draw Player.
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
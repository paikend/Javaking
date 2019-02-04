// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package com.neet.JavaKing.Manager;

import java.awt.Graphics2D;

import com.neet.JavaKing.GameState.GameOverState;
import com.neet.JavaKing.GameState.GameState;
import com.neet.JavaKing.GameState.InfoState;
import com.neet.JavaKing.GameState.IntroState;
import com.neet.JavaKing.GameState.MenuState;
import com.neet.JavaKing.GameState.PauseState;
import com.neet.JavaKing.GameState.PlayState;
import com.neet.JavaKing.GameState.RankState;
import com.neet.JavaKing.GameState.NameState;


public class GameStateManager {
	
	private boolean paused;
	private PauseState pauseState;
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 7;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int INFO = 3;
	public static final int RANK = 4;
	public static final int NAME = 5;
	public static final int GAMEOVER = 6;
	
	public GameStateManager() {
		
		JukeBox.init();
		
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
		
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == INTRO) {
			gameStates[i] = new IntroState(this);
			gameStates[i].init();
		}
		else if(i == MENU) {
			gameStates[i] = new MenuState(this);
			gameStates[i].init();
		}
		else if(i == PLAY) {
			gameStates[i] = new PlayState(this);
			gameStates[i].init();
		}
		else if(i == INFO) {
			gameStates[i] = new InfoState(this);
			gameStates[i].init();
		}
		else if(i == RANK) {
			gameStates[i] = new RankState(this);
			gameStates[i].init();
		}
		else if(i == NAME) {
			gameStates[i] = new NameState(this);
			gameStates[i].init();
		}
		else if(i == GAMEOVER) {
			gameStates[i] = new GameOverState(this);
			gameStates[i].init();
		}
	}
	
	public void unloadState(int i) {
		gameStates[i] = null;
	}
	
	public void setPaused(boolean b) {
		paused = b;
	}
	
	public void update() {
		if(paused) {
			pauseState.update();
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}
	
	public void draw(Graphics2D g) {
		if(paused) {
			pauseState.draw(g);
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}
	
}

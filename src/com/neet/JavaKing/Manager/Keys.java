// Contains an array of current key state
// previous key state. A value of true
// means the key is pressed.

// The GamePanel KeyListener will update the array.
// All GameStates now have a handleInput() function
// in order to keep all keyboard input operations
// on the game thread rather than on the EDT to avoid
// problems.

package com.neet.JavaKing.Manager;

import java.awt.event.KeyEvent;

public class Keys {
	
	public static final int NUM_KEYS = 35;
	
	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];
	
	public static int UP = 0;
	public static int LEFT = 1;
	public static int DOWN = 2;
	public static int RIGHT = 3;
	public static int SPACE = 4;
	public static int ENTER = 5;
	public static int ESCAPE = 6;
	public static int F1 = 7;
	public static int A =8;
	public static int B =9;
	public static int C =10;
	public static int D =11;
	public static int E =12;
	public static int F =13;
	public static int G =14;
	public static int H =15;
	public static int I =16;
	public static int J =17;
	public static int K =18;
	public static int L =19;
	public static int M =20;
	public static int N =21;
	public static int O =22;
	public static int P =23;
	public static int Q =24;
	public static int R =25;
	public static int S =26;
	public static int T =27;
	public static int U =28;
	public static int V =29;
	public static int W =30;
	public static int X =31;
	public static int Y =32;
	public static int Z =33;
	public static int BACK_SPACE =34;
	
	public static void keySet(int i, boolean b) {
		if(i == KeyEvent.VK_UP) keyState[UP] = b;
		else if(i == KeyEvent.VK_LEFT) keyState[LEFT] = b;
		else if(i == KeyEvent.VK_DOWN) keyState[DOWN] = b;
		else if(i == KeyEvent.VK_RIGHT) keyState[RIGHT] = b;
		else if(i == KeyEvent.VK_SPACE) keyState[SPACE] = b;
		else if(i == KeyEvent.VK_ENTER) keyState[ENTER] = b;
		else if(i == KeyEvent.VK_ESCAPE) keyState[ESCAPE] = b;
		else if(i == KeyEvent.VK_F1) keyState[F1] = b;
		else if(i == KeyEvent.VK_A) keyState[A] = b;
		else if(i == KeyEvent.VK_B) keyState[B] = b;
		else if(i == KeyEvent.VK_C) keyState[C] = b;
		else if(i == KeyEvent.VK_D) keyState[D] = b;
		else if(i == KeyEvent.VK_E) keyState[E] = b;
		else if(i == KeyEvent.VK_F) keyState[F] = b;
		else if(i == KeyEvent.VK_G) keyState[G] = b;
		else if(i == KeyEvent.VK_H) keyState[H] = b;
		else if(i == KeyEvent.VK_I) keyState[I] = b;
		else if(i == KeyEvent.VK_J) keyState[J] = b;
		else if(i == KeyEvent.VK_K) keyState[K] = b;
		else if(i == KeyEvent.VK_L) keyState[L] = b;
		else if(i == KeyEvent.VK_M) keyState[M] = b;
		else if(i == KeyEvent.VK_N) keyState[N] = b;
		else if(i == KeyEvent.VK_O) keyState[O] = b;
		else if(i == KeyEvent.VK_P) keyState[P] = b;
		else if(i == KeyEvent.VK_Q) keyState[Q] = b;
		else if(i == KeyEvent.VK_R) keyState[R] = b;
		else if(i == KeyEvent.VK_S) keyState[S] = b;
		else if(i == KeyEvent.VK_T) keyState[T] = b;
		else if(i == KeyEvent.VK_U) keyState[U] = b;
		else if(i == KeyEvent.VK_V) keyState[V] = b;
		else if(i == KeyEvent.VK_W) keyState[W] = b;
		else if(i == KeyEvent.VK_X) keyState[X] = b;
		else if(i == KeyEvent.VK_Y) keyState[Y] = b;
		else if(i == KeyEvent.VK_Z) keyState[Z] = b;
		else if(i == KeyEvent.VK_BACK_SPACE) keyState[BACK_SPACE] = b;
		
	}
	
	public static void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean isDown(int i) {
		return keyState[i];
	}
		
}

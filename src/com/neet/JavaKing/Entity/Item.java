// Possibly redundant subclass of Entity.
// There are two types of items: KEY2 and boat.
// Upon collection, informs the Player
// that the Player does indeed have the item.

package com.neet.JavaKing.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.JavaKing.Manager.Content;
import com.neet.JavaKing.TileMap.TileMap;

public class Item extends Entity{
	
	private BufferedImage sprite;
	private int type;
	public static final int KEY1 = 0;
	public static final int KEY2 = 1;
	public static final int KEY3 = 2;
	
	public Item(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 12;
	}
	
	public void setType(int i) {
		type = i;
		
		if(type == KEY1) {
			sprite = Content.ITEMS[1][0];
		}
		else if(type == KEY2) {
			sprite = Content.ITEMS[1][1];
		}
		else if(type == KEY3) {
			sprite = Content.ITEMS[1][2];
		}
	}
	
	public void collected(Player p) {
		
		if(type == KEY1) {
			p.gotKey1();
		}
		else if(type == KEY2) {
			p.gotKey2();
		}
		else if(type == KEY3) {
			p.gotKey3();
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}

package main;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	enum NoteType {
		SPECIAL, NORMAL;
	}
	
	enum NoteLength {
		LONG, SHORT;
	}
	
	private Image normalBeatImage = new ImageIcon(getClass().getResource("../img/NormalBeatImage.png")).getImage();
	private Image specialBeatImage = new ImageIcon(getClass().getResource("../img/SpecialBeatImage.png")).getImage();
	
	private NoteType noteType;
	private NoteLength noteLength;
	private int x;
	private int y = 660 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED;
	
	public Note(NoteType noteType, NoteLength noteLength, int x) {
		this.noteType = noteType;
		this.noteLength = noteLength;
		this.x = x;
	}
	public void screenDraw(Graphics2D g) {
		switch(noteType) {
		case NORMAL : 
			if(noteLength.equals(NoteLength.SHORT)) {
				g.drawImage(normalBeatImage, x, y, null);
			}
			if(noteLength.equals(NoteLength.LONG)) {
				g.drawImage(normalBeatImage, x, y, null);
				g.drawImage(normalBeatImage, x, y + 40, null);
			}
			break;
		case SPECIAL : 
			if(noteLength.equals(NoteLength.SHORT)) {
				g.drawImage(specialBeatImage, x, y, null);
			}
			if(noteLength.equals(NoteLength.LONG)) {
				g.drawImage(specialBeatImage, x, y, null);
				g.drawImage(specialBeatImage, x, y + 40, null);
			}
			break;
		}
			
	}
	
	public void drop() {
		y+= Main.NOTE_SPEED;
	}
	
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package main;
/*
 *  value of variable y should be adjusted such that drops exactly at y = 660 after 1 second.
 *  current y = - 40, after 1 sec, y = -40 + 700 = 660
 *  660 is constant number determined by height of frame subtracted by height of judgement bar, 720 - 60 = 660 px.
 */
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	enum NoteType {
		SPECIAL, NORMAL;
	}

	enum NoteLength {
		LONG, SHORT;
	}
	
	enum NoteName {
		Q,W,E,R,SPACE,ENTER;
	}
	
	private Image normalBeatImage = new ImageIcon(getClass().getResource("../img/NormalBeatImage.png")).getImage();
	private Image specialBeatImage = new ImageIcon(getClass().getResource("../img/SpecialBeatImage.png")).getImage();

	private NoteType noteType;
	private NoteLength noteLength;
	private NoteName noteName;
	private int noteTime;
	private int x;
	private int y = 660 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private boolean isProceeded = false;
	
	public Note(int noteTime, NoteName noteName, NoteType noteType, NoteLength noteLength) {
		this.noteTime = noteTime;
		this.noteName = noteName;
		this.noteType = noteType;
		this.noteLength = noteLength;

		switch (noteName) {
		case Q:
			this.x = 332;
			break;

		case W:
			this.x = 436;
			break;

		case E:
			this.x = 540;
			break;

		case R:
			this.x = 644;
			break;

		case SPACE:
			this.x = 748;
			break;

		case ENTER:
			this.x = 852;
			break;
		}
	}

	public NoteType getNoteType() {
		return noteType;
	}

	public void setNoteType(NoteType noteType) {
		this.noteType = noteType;
	}

	public NoteLength getNoteLength() {
		return noteLength;
	}

	public void setNoteLength(NoteLength noteLength) {
		this.noteLength = noteLength;
	}

	public NoteName getNoteName() {
		return noteName;
	}

	public void setNoteName(NoteName noteName) {
		this.noteName = noteName;
	}

	public int getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(int noteTime) {
		this.noteTime = noteTime;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public boolean isProceeded() {
		return isProceeded;
	}
	public void close() {
		this.isProceeded = true;
	}
	
	public void screenDraw(Graphics2D g) {
		switch (noteType) {
		case NORMAL:
			if (noteLength.equals(NoteLength.SHORT)) {
				g.drawImage(normalBeatImage, x, y, null);
			}
			if (noteLength.equals(NoteLength.LONG)) {
				g.drawImage(normalBeatImage, x, y, null);
				g.drawImage(normalBeatImage, x, y + 40, null);
			}
			break;
		case SPECIAL:
			if (noteLength.equals(NoteLength.SHORT)) {
				g.drawImage(specialBeatImage, x, y, null);
			}
			if (noteLength.equals(NoteLength.LONG)) {
				g.drawImage(specialBeatImage, x, y, null);
				g.drawImage(specialBeatImage, x, y + 40, null);
			}
			break;
		}
	}
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 800) {
			close();
		}
		if(y >= 660) {
			normalBeatImage = null;
			specialBeatImage = null;
		}
	}

	public void judge() {
		if(y >= 720) {
			System.out.println("Missed");
		}
		else if(y >= 630) {
			System.out.println("Perfect");
		}
		else if(y >= 540) {
			System.out.println("Good");
		}
	}
	public void run() {
		try {
			while (true) {
				drop();
				if(!isProceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

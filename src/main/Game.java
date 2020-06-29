package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import music.Music;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(getClass().getResource("../img/gameinfo.png")).getImage();
	private Image judgementBar = new ImageIcon(getClass().getResource("../img/judgementBar.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(getClass().getResource("../img/noteRouteLine.png")).getImage();
	private Image noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image keyPadQImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();
	private Image keyPadWImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();
	private Image keyPadEImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();
	private Image keyPadRImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();
	private Image keyPadSPACEImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();
	private Image keyPadENTERImage = new ImageIcon(getClass().getResource("../img/KeypadBasic.png")).getImage();

	private Image normalFlareImage;
	private Image judgeImage;

	private InputMap im;
	private ActionMap am;

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	private int beatScore;
	private int beatCombo;
	
	private ArrayList<Note> noteList = new ArrayList<Note>();

	private boolean isMakingBeat = true;

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		this.gameMusic = new Music(this.musicTitle, false);
		gameMusic.start();
	}

	public Game() {
		super();
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteQImage, 332, 0, null);
		g.drawImage(noteRouteWImage, 436, 0, null);
		g.drawImage(noteRouteEImage, 540, 0, null);
		g.drawImage(noteRouteRImage, 644, 0, null);
		g.drawImage(noteRouteSPACEImage, 748, 0, null);
		g.drawImage(noteRouteENTERImage, 852, 0, null);
		g.drawImage(noteRouteLineImage, 328, 0, null);
		g.drawImage(noteRouteLineImage, 432, 0, null);
		g.drawImage(noteRouteLineImage, 536, 0, null);
		g.drawImage(noteRouteLineImage, 640, 0, null);
		g.drawImage(noteRouteLineImage, 744, 0, null);
		g.drawImage(noteRouteLineImage, 848, 0, null);
		g.drawImage(noteRouteLineImage, 952, 0, null);
		g.drawImage(judgementBar, 0, 660, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.isProceeded()) {
				if(note.isMissed()) {
					normalFlareImage = null;
					judgeImage = null;
					beatCombo = 0;
				}
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}

		g.drawImage(gameInfoImage, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 40);
		g.drawString(difficulty, 1190, 40);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("Q", 374, 700);
		g.drawString("W", 478, 700);
		g.drawString("E", 582, 700);
		g.drawString("R", 686, 700);
		g.drawString("SPACE", 740, 700);
		g.drawString("ENTER", 860, 700);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(Integer.toString(beatScore), 1000, 40);
		g.setColor(Color.YELLOW);
		if(beatScore > 0) g.drawString(Integer.toString(beatCombo), 600, 290);
		g.drawImage(judgeImage, 440, 300, null);
		g.drawImage(normalFlareImage, 420, 340, null);
		g.drawImage(keyPadQImage, 332, 680, null);
		g.drawImage(keyPadWImage, 436, 680, null);
		g.drawImage(keyPadEImage, 540, 680, null);
		g.drawImage(keyPadRImage, 644, 680, null);
		g.drawImage(keyPadSPACEImage, 748, 680, null);
		g.drawImage(keyPadENTERImage, 852, 680, null);
	}

	public void addKeyBind(JComponent component) {
		this.im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		this.am = component.getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), KeyAction.Action.Q_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), KeyAction.Action.W_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), KeyAction.Action.E_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), KeyAction.Action.R_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), KeyAction.Action.SPACE_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), KeyAction.Action.ENTER_PRESSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), KeyAction.Action.ESC_PRESSED);
		im.put(KeyStroke.getKeyStroke("released Q"), KeyAction.Action.Q_RELEASED);
		im.put(KeyStroke.getKeyStroke("released W"), KeyAction.Action.W_RELEASED);
		im.put(KeyStroke.getKeyStroke("released E"), KeyAction.Action.E_RELEASED);
		im.put(KeyStroke.getKeyStroke("released R"), KeyAction.Action.R_RELEASED);
		im.put(KeyStroke.getKeyStroke("released SPACE"), KeyAction.Action.SPACE_RELEASED);
		im.put(KeyStroke.getKeyStroke("released ENTER"), KeyAction.Action.ENTER_RELEASED);

		am.put(KeyAction.Action.Q_PRESSED, new KeyAction(KeyAction.Action.Q_PRESSED));
		am.put(KeyAction.Action.W_PRESSED, new KeyAction(KeyAction.Action.W_PRESSED));
		am.put(KeyAction.Action.E_PRESSED, new KeyAction(KeyAction.Action.E_PRESSED));
		am.put(KeyAction.Action.R_PRESSED, new KeyAction(KeyAction.Action.R_PRESSED));
		am.put(KeyAction.Action.SPACE_PRESSED, new KeyAction(KeyAction.Action.SPACE_PRESSED));
		am.put(KeyAction.Action.ENTER_PRESSED, new KeyAction(KeyAction.Action.ENTER_PRESSED));
		am.put(KeyAction.Action.ESC_PRESSED, new KeyAction(KeyAction.Action.ESC_PRESSED));
		am.put(KeyAction.Action.Q_RELEASED, new KeyAction(KeyAction.Action.Q_RELEASED));
		am.put(KeyAction.Action.W_RELEASED, new KeyAction(KeyAction.Action.W_RELEASED));
		am.put(KeyAction.Action.E_RELEASED, new KeyAction(KeyAction.Action.E_RELEASED));
		am.put(KeyAction.Action.R_RELEASED, new KeyAction(KeyAction.Action.R_RELEASED));
		am.put(KeyAction.Action.SPACE_RELEASED, new KeyAction(KeyAction.Action.SPACE_RELEASED));
		am.put(KeyAction.Action.ENTER_RELEASED, new KeyAction(KeyAction.Action.ENTER_RELEASED));
	}

	public void pressQ() {
		noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("Q");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " Q");
	}

	public void releaseQ() {
		noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressW() {
		noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("W");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " W");
	}

	public void releaseW() {
		noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressE() {
		noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("E");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " E");
	}

	public void releaseE() {
		noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressR() {
		noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("R");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " R");
	}

	public void releaseR() {
		noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressSPACE() {
		noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("SPACE");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " SPACE");
	}

	public void releaseSPACE() {
		noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressENTER() {
		noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
		judge("ENTER");
		//if (isMakingBeat) System.out.println(gameMusic.getTime() + " ENTER");
	}

	public void releaseENTER() {
		noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}

	public void pressESC() {

	}

	public void run() {
		dropNotes();
	}

	public void pause() {

	}

	// Terminate thread and turn off the music
	public void close() {
		gameMusic.close();
	}

	public void addBeats(ArrayList<Note> beats) throws Exception {
		File file;
		BufferedReader br;
		String str;
		int gap = Main.REACH_TIME * 1000;
		file = null;
		switch (this.titleName) {
		case "Joakim Karud - Might Love":
			if (this.difficulty == "Easy") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Might Love(Easy).txt");
			}

			if (this.difficulty == "Hard") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Might Love(Hard).txt");
			}
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				int time = Integer.parseInt(str.split(" ")[0]);
				String key = str.split(" ")[1];
				beats.add(
						new Note(time - gap, Note.NoteName.valueOf(key), Note.NoteType.NORMAL, Note.NoteLength.SHORT));
			}
			br.close();
			break;
		case "Vendredi - Follow me":
			if (this.difficulty == "Easy") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Follow me(Easy).txt");
			}

			if (this.difficulty == "Hard") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Follow me(Hard).txt");
			}
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				int time = Integer.parseInt(str.split(" ")[0]);
				String key = str.split(" ")[1];
				beats.add(
						new Note(time - gap, Note.NoteName.valueOf(key), Note.NoteType.NORMAL, Note.NoteLength.SHORT));
			}
			br.close();
			break;
		case "Ant Saunders - Yellow Hearts":
			if (this.difficulty == "Easy") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Yellow Hearts(Easy).txt");
			}

			if (this.difficulty == "Hard") {
				file = new File(
						"C:\\Users\\Luke\\eclipse-workspace\\VisualSoundProject\\src\\beat\\beat - Yellow Hearts(Hard).txt");
			}
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				int time = Integer.parseInt(str.split(" ")[0]);
				String key = str.split(" ")[1];
				beats.add(
						new Note(time - gap, Note.NoteName.valueOf(key), Note.NoteType.NORMAL, Note.NoteLength.SHORT));
			}
			br.close();
			break;
		}
	}

	public void dropNotes() {
		ArrayList<Note> beats = new ArrayList<Note>();
		try {
			addBeats(beats);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int i = 0;
		while (i < beats.size() && !isInterrupted()) {
			boolean dropped = false;
			if (beats.get(i).getNoteTime() <= gameMusic.getTime()) {
				beats.get(i).start();
				noteList.add(beats.get(i));
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
					this.interrupt();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteName().name())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			normalFlareImage = new ImageIcon(getClass().getResource("../img/FlareImage.png")).getImage();
			switch (judge) {
			case "Perfect":
				judgeImage = new ImageIcon(getClass().getResource("../img/PerefectImageJudge.png")).getImage();
				beatScore += 800;
				++beatCombo;
				break;
			case "Late":
				judgeImage = new ImageIcon(getClass().getResource("../img/LateImageJudge.png")).getImage();
				beatScore += 0;
				beatCombo = 0;
				break;
			case "Good":
				judgeImage = new ImageIcon(getClass().getResource("../img/GoodImageJudge.png")).getImage();
				beatScore += 400;
				++beatCombo;
				break;
			}
		}
	
		else if(judge.equals("None")) {
			judgeImage = null;
			normalFlareImage = null;
		}
		System.out.println(judge);
	}
}

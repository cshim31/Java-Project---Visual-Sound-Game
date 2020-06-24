package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(getClass().getResource("../img/gameinfo.png")).getImage();
	private Image judgementBar = new ImageIcon(getClass().getResource("../img/judgementBar.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(getClass().getResource("../img/noteRouteLine.png")).getImage();
	private Image normalBeatImage = new ImageIcon(getClass().getResource("../img/NormalBeatImage.png")).getImage();
	private Image specialBeatImage = new ImageIcon(getClass().getResource("../img/SpecialBeatImage.png")).getImage();
	
	private Image noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	
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
		g.drawImage(normalBeatImage, 332, 80, null);
		g.drawImage(normalBeatImage, 436, 30, null);
		g.drawImage(normalBeatImage, 540, 110, null);
		g.drawImage(normalBeatImage, 644, 330, null);
		g.drawImage(normalBeatImage, 748, 340, null);
		g.drawImage(normalBeatImage, 852, 500, null);
		
		g.drawImage(gameInfoImage, 0, 0, null);
		g.drawImage(judgementBar, 0, 660, null);
		g.setColor(Color.WHITE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Joakim Karud - Mighty Love", 20 , 40);
		g.drawString("Easy", 1190, 40);
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
		g.drawString("000000", 1000, 40);
	}
	
	public void pressQ() {
		noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseQ() {
		noteRouteQImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void pressW() {
		noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseW() {
		noteRouteWImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void pressE() {
		noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseE() {
		noteRouteEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void pressR() {
		noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseR() {
		noteRouteRImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void pressSPACE() {
		noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseSPACE() {
		noteRouteSPACEImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void pressENTER() {
		noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRouteEffect.png")).getImage();
	}
	
	public void releaseENTER() {
		noteRouteENTERImage = new ImageIcon(getClass().getResource("../img/noteRoute.png")).getImage();
	}
	
	public void run() {
		
	}
}

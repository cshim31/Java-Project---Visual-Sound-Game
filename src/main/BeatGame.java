package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import music.Music;

public class BeatGame extends JFrame {
	// Images
	private Image screenImage;
	private Image background = new ImageIcon(Main.class.getResource("../img/intro_background.jpg")).getImage();
	private ImageIcon exitButtonExited = new ImageIcon(getClass().getResource("../img/exitButtonExited.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(getClass().getResource("../img/exitButtonEntered.png"));
	private ImageIcon startButtonImage = new ImageIcon(getClass().getResource("../img/gameStartButtonOriginal.png"));
	private ImageIcon startButtonImageEntered = new ImageIcon(getClass().getResource("../img/gameStartButtonOriginalEntered.png"));
	//private ImageIcon startButtonImage = new ImageIcon(getClass().getResource("../img/gameStartButtonRevised.png"));
	//private ImageIcon startButtonImageEntered = new ImageIcon(getClass().getResource("../img/gameStartButtonRevisedEntered.png"));
	// Sounds
	Music introMusic = new Music("Razihel - Love U.mp3", true);

	// Interface Components
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../img/menubar.png")));
	private JButton exitButton = new JButton(exitButtonExited);
	private JButton gameStartButton = new JButton(startButtonImage);

	private Graphics screenGraphic;
	private int mouseX, mouseY;

	public BeatGame() {
		setUndecorated(true);
		setTitle("Visual Sound");
		setSize(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		// ExitButton Component
		exitButton.setBounds(983, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// Event Listener
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				exitButton.setIcon(exitButtonEntered);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonExited);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
				try {
					Thread.sleep(1000);
				} catch (Exception exception) {
					exception.printStackTrace();
				} finally {
					System.exit(0);
				}
			}
		});
		add(exitButton);

		// game start button component
		gameStartButton.setBounds(20, 200, 290, 156);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);

		gameStartButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				gameStartButton.setIcon(startButtonImageEntered);
				gameStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameStartButton.setIcon(startButtonImage);
				gameStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
				gameStartButton.setVisible(false);
				background = new ImageIcon(getClass().getResource("../img/music_background.jpg")).getImage();
			}
		});
		add(gameStartButton);

		// Menubar component
		menubar.setBounds(0, 0, 1200, 30);
		// Event Listener
		menubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// mouseX, mouseY = position relative to component
				mouseX = e.getX();
				mouseY = e.getY();

				// System.out.println("x :"+mouseX+" y: "+mouseY);
			}
		});

		menubar.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// x, y = position on screen
				// Setting initial location everytime dragged
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);

		introMusic.start();
	}

	// paint auto-executed once rendered
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}

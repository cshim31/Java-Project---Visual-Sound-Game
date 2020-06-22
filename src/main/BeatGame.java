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
	private Image background = new ImageIcon(Main.class.getResource("../img/intro_background.png")).getImage();
	private Image songImage = new ImageIcon(getClass().getResource("../img/Mighty Love - Joakim Karud (preview).jpg"))
			.getImage();
	private ImageIcon exitButtonExited = new ImageIcon(getClass().getResource("../img/exitButton.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(getClass().getResource("../img/exitButtonEntered.png"));
	private ImageIcon startButtonImage = new ImageIcon(getClass().getResource("../img/GameStartButton.png"));
	private ImageIcon quitButtonImage = new ImageIcon(getClass().getResource("../img/GameQuitButton.png"));
	private ImageIcon startButtonImageEntered = new ImageIcon(
			getClass().getResource("../img/GameStartButtonEntered.png"));
	private ImageIcon quitButtonImageEntered = new ImageIcon(
			getClass().getResource("../img/GameQuitButtonEntered.png"));
	private ImageIcon toMainImage = new ImageIcon(getClass().getResource("../img/ToMainButton.png"));
	private ImageIcon selectLeft = new ImageIcon(getClass().getResource("../img/SelectButtonLeft.png"));
	private ImageIcon selectRight = new ImageIcon(getClass().getResource("../img/SelectButtonRight.png"));
	// Sounds
	Music introMusic = new Music("Razihel - Love U.mp3", true);

	// Main background components
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../img/menubar3.png")));
	private JButton exitButton = new JButton(exitButtonExited);
	private JButton gameStartButton = new JButton(startButtonImage);
	private JButton gameQuitButton = new JButton(quitButtonImage);
	
	//Music select background components
	private JButton toMainButton = new JButton(toMainImage);
	private JButton selectLeftButton = new JButton(selectLeft);
	private JButton selectRightButton = new JButton(selectRight);
	// variables
	private Graphics screenGraphic;
	private int mouseX, mouseY;
	private boolean isMain;

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
		isMain = true;
		
		// ExitButton Component
		exitButton.setBounds(1250, 0, 30, 30);
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

		// game quit button component
		gameQuitButton.setBounds(20, 420, 300, 77);
		gameQuitButton.setBorderPainted(false);
		gameQuitButton.setContentAreaFilled(false);
		gameQuitButton.setFocusPainted(false);

		// Event Listener
		gameQuitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				gameQuitButton.setIcon(quitButtonImageEntered);
				gameQuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameQuitButton.setIcon(startButtonImage);
				gameQuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

		add(gameQuitButton);

		// To main button component
		toMainButton.setBounds(0, 0, 30, 30);
		toMainButton.setBorderPainted(false);
		toMainButton.setContentAreaFilled(false);
		toMainButton.setFocusPainted(false);

		// Event Listener
		toMainButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				toMainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameQuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			//Remove current interface components
			//Add next interface components
			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
				isMain = true;
				background = new ImageIcon(Main.class.getResource("../img/intro_background.png")).getImage();
				disableMusicSelectComponents();
				enableMainComponents();
			}
		});

		add(toMainButton);

		// Music select left button component
		selectLeftButton.setBounds(240, 310, 80, 50);
		selectLeftButton.setBorderPainted(false);
		selectLeftButton.setContentAreaFilled(false);
		selectLeftButton.setFocusPainted(false);

		// Event Listener
		selectLeftButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				selectLeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				selectLeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
			}
		});

		add(selectLeftButton);

		// Music select right button component
		selectRightButton.setBounds(960, 310, 80, 50);
		selectRightButton.setBorderPainted(false);
		selectRightButton.setContentAreaFilled(false);
		selectRightButton.setFocusPainted(false);

		// Event Listener
		selectRightButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				selectRightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				selectRightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
			}
		});

		add(selectRightButton);

		// game start button component
		gameStartButton.setBounds(20, 325, 300, 77);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);

		// Event Listener
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
				gameQuitButton.setVisible(false);
				background = new ImageIcon(getClass().getResource("../img/music_background.jpg")).getImage();
				isMain = false;
				disableMainComponents();
				enableMusicSelectComponents();
			}
		});

		add(gameStartButton);

		// Menubar component
		menubar.setBounds(0, 0, 1280, 30);

		// Event Listener
		// mouseX, mouseY = position relative to component
		menubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// x, y = position on screen
		// Setting initial location everytime dragged
		menubar.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);

		//Default Setting
		disableMusicSelectComponents();
		enableMainComponents();
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
		if (!isMain)
			g.drawImage(songImage, 340, 100, null);
		paintComponents(g);
		this.repaint();
	}
	
	public void enableMainComponents() {
		this.menubar.setVisible(true);
		this.gameStartButton.setVisible(true);
		this.gameQuitButton.setVisible(true);
	}
	
	public void disableMainComponents() {
		this.menubar.setVisible(false);
		this.gameStartButton.setVisible(false);
		this.gameQuitButton.setVisible(false);
	}
	
	public void enableMusicSelectComponents() {
		this.toMainButton.setVisible(true);
		this.selectLeftButton.setVisible(true);
		this.selectRightButton.setVisible(true);
	}
	
	public void disableMusicSelectComponents() {
		this.toMainButton.setVisible(false);
		this.selectLeftButton.setVisible(false);
		this.selectRightButton.setVisible(false);
	}
}

package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import music.Music;

public class BeatGame extends JFrame {

	// Main interfaces and components
	private Image background = new ImageIcon(Main.class.getResource("../img/intro_background (revised).png"))
			.getImage();
	private ImageIcon gameExitButtonExited = new ImageIcon(getClass().getResource("../img/gameExitButton.png"));
	private ImageIcon gameExitButtonEntered = new ImageIcon(getClass().getResource("../img/gameExitButtonEntered.png"));
	private ImageIcon startButtonImage = new ImageIcon(getClass().getResource("../img/GameStartButton.png"));
	private ImageIcon quitButtonImage = new ImageIcon(getClass().getResource("../img/GameQuitButton.png"));
	private ImageIcon startButtonImageEntered = new ImageIcon(
			getClass().getResource("../img/GameStartButtonEntered.png"));
	private ImageIcon quitButtonImageEntered = new ImageIcon(
			getClass().getResource("../img/GameQuitButtonEntered.png"));

	private JButton gameExitButton = new JButton(gameExitButtonExited);
	private JButton gameStartButton = new JButton(startButtonImage);

	// Music Selection interfaces and components
	private ImageIcon toMainImage = new ImageIcon(getClass().getResource("../img/ToMainButton.png"));
	private ImageIcon selectLeft = new ImageIcon(getClass().getResource("../img/SelectButtonLeft.png"));
	private ImageIcon selectRight = new ImageIcon(getClass().getResource("../img/SelectButtonRight.png"));
	private ImageIcon easyModeImage = new ImageIcon(getClass().getResource("../img/EasyModeButton.png"));
	private ImageIcon hardModeImage = new ImageIcon(getClass().getResource("../img/HardModeButton.png"));
	private ImageIcon easyModeImageEntered = new ImageIcon(getClass().getResource("../img/EasyModeButtonEntered.png"));
	private ImageIcon hardModeImageEntered = new ImageIcon(getClass().getResource("../img/HardModeButtonEntered.png"));

	private JButton toMainButton = new JButton(toMainImage);
	private JButton selectLeftButton = new JButton(selectLeft);
	private JButton selectRightButton = new JButton(selectRight);
	private JButton easyModeButton = new JButton(easyModeImage);
	private JButton hardModeButton = new JButton(hardModeImage);
		
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../img/menubar3.png")));
	private JButton gameQuitButton = new JButton(quitButtonImage);

	private Music selectedMusic = new Music("Razihel - Love U.mp3", true);

	private JPanel panel = (JPanel) getContentPane();
	
	private boolean isMain = false;

	private boolean isInGame = false;

	private ArrayList<Track> trackList = new ArrayList<Track>();

	private int nowSelected = 0;

	private Graphics screenGraphic;

	private int mouseX, mouseY;
	
	private Image screenImage;
	private Image songImage;
	private Image songTitle;

	public static Game game = new Game();
	
	public BeatGame() {
		setUndecorated(true);
		setTitle("Visual Sound");
		setSize(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBounds(10,10,Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		game.addKeyBind(panel);
		
		// Update musics in track list
		trackList.add(new Track("Joakim Karud - Mighty Love (preview).jpg", "MightyLove.png",
				"Mighty Love - Joakim Karud (preview).mp3", "Joakim Karud - Mighty Love.jpg",
				"Mighty Love - Joakim Karud.mp3"));
		trackList.add(new Track("Vendredi - Follow Me (preview).jpg", "YellowHeartsTitle.png",
				"Follow Me - Vendredi (preview).mp3", "Vendredi - Follow Me.jpg", "Follow Me - Vendredi.mp3"));
		trackList.add(new Track("Ant Saunders - Yellow Hearts (preview).jpg", "FollowmeTitle.png",
				"Ant Saunders - Yellow Hearts (preview).mp3", "Ant Saunders - Yellow Hearts.jpg",
				"Ant Saunders - Yellow Hearts.mp3"));
		// Load Interface
		gameExitButton.setBounds(1250, 0, 30, 30);
		gameExitButton.setBorderPainted(false);
		gameExitButton.setContentAreaFilled(false);
		gameExitButton.setFocusPainted(false);

		gameExitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				gameExitButton.setIcon(gameExitButtonEntered);
				gameExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameExitButton.setIcon(gameExitButtonExited);
				gameExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
		add(gameExitButton);

		gameQuitButton.setBounds(20, 420, 300, 77);
		gameQuitButton.setBorderPainted(false);
		gameQuitButton.setContentAreaFilled(false);
		gameQuitButton.setFocusPainted(false);

		gameQuitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				gameQuitButton.setIcon(quitButtonImageEntered);
				gameQuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				gameQuitButton.setIcon(quitButtonImage);
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

			// disenable and remove current interface components
			// Enable and add next interface components
			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
				disenableMainComponents();
				enableIntroComponents();
				selectMain();
			}
		});

		add(toMainButton);

		selectLeftButton.setBounds(240, 310, 80, 50);
		selectLeftButton.setBorderPainted(false);
		selectLeftButton.setContentAreaFilled(false);
		selectLeftButton.setFocusPainted(false);

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

				// Event
				selectLeft();
			}
		});

		add(selectLeftButton);

		selectRightButton.setBounds(960, 310, 80, 50);
		selectRightButton.setBorderPainted(false);
		selectRightButton.setContentAreaFilled(false);
		selectRightButton.setFocusPainted(false);

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

				// Event
				selectRight();
			}
		});

		add(selectRightButton);

		easyModeButton.setBounds(375, 580, 250, 80);
		easyModeButton.setBorderPainted(false);
		easyModeButton.setContentAreaFilled(false);
		easyModeButton.setFocusPainted(false);
		easyModeButton.setVisible(false);
		easyModeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				easyModeButton.setIcon(easyModeImageEntered);
				easyModeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				easyModeButton.setIcon(easyModeImage);
				easyModeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();

				// Event
				gameStart(nowSelected, "easy");
			}
		});

		add(easyModeButton);

		hardModeButton.setBounds(655, 580, 250, 80);
		hardModeButton.setBorderPainted(false);
		hardModeButton.setContentAreaFilled(false);
		hardModeButton.setFocusPainted(false);
		hardModeButton.setVisible(false);
		hardModeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Music buttonEnteredSound = new Music("../music/mouseEntered.mp3", false);
				buttonEnteredSound.start();
				hardModeButton.setIcon(hardModeImageEntered);
				hardModeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				hardModeButton.setIcon(hardModeImage);
				hardModeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();

				// Event
				gameStart(nowSelected, "hard");
			}
		});

		add(hardModeButton);

		gameStartButton.setBounds(20, 325, 300, 77);
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

			// Turn off main music and play music in track list
			// Remove main interface components and add next interface components
			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();

				// Event
				disenableIntroComponents();
				enableMainComponents();
				selectTrack(nowSelected);
			}
		});

		add(gameStartButton);

		menubar.setBounds(0, 0, 1280, 30);

		// mouseX, mouseY = position relative to component
		menubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		// x, y = position on screen
		// Set initial location everytime dragged
		menubar.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		add(menubar);
		disenableMainComponents();
		enableIntroComponents();
	}

	// paint auto-executed once rendered
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (isMain) {
			g.drawImage(songImage, 340, 100, null);
			g.drawImage(songTitle, 340, 70, null);
		}

		if (isInGame) {
			game.screenDraw(g);
		}
		paintComponents(g);
		this.repaint();
	}

	// Show track list in left direction and play the music
	public void selectLeft() {
		if (nowSelected > 0) {
			--nowSelected;
		} else {
			nowSelected = trackList.size() - 1;
		}
		selectTrack(nowSelected);
	}

	// Show track list in right direction and play the music
	public void selectRight() {
		if (nowSelected < trackList.size() - 1) {
			++nowSelected;
		} else {
			nowSelected = 0;
		}
		selectTrack(nowSelected);
	}

	// Play the selected music
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}

		songTitle = new ImageIcon(getClass().getResource("../img/" + trackList.get(nowSelected).getMusicTitle()))
				.getImage();
		songImage = new ImageIcon(getClass().getResource("../img/" + trackList.get(nowSelected).getMusicImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getMusicPreview(), true);
		selectedMusic.start();
	}

	// Play the main music
	public void selectMain() {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		this.nowSelected = 0;
		selectedMusic = new Music("Razihel - Love U.mp3", true);
		selectedMusic.start();
	}

	// Move from Music select screen to Intro screen
	public void toIntro() {
		disenableMainComponents();
		enableIntroComponents();
	}

	// Move from In Game screen to Music select screen
	public void toMain() {
		disenableInGameComponents();
		enableMainComponents();
	}

	// Load Game Screen
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}

		disenableMainComponents();
		background = new ImageIcon(getClass().getResource("../img/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getGameMusic(), false);
		selectedMusic.start();
		isInGame = true;
		setFocusable(true);
	}

	/*
	 * 
	 * Following functions enable/disenable interface components when moving from
	 * screen to another current disenable function and next enable function should
	 * pair
	 */

	// Main Screen
	public void enableIntroComponents() {
		this.isMain = false;
		this.isInGame = false;
		this.selectedMusic = new Music("Razihel - Love U.mp3", true);
		this.background = new ImageIcon(Main.class.getResource("../img/intro_background (revised).png")).getImage();
		this.gameStartButton.setVisible(true);
		this.gameQuitButton.setVisible(true);
		this.menubar.setVisible(true);
		this.gameExitButton.setVisible(true);
		this.toMainButton.setVisible(true);
		this.selectedMusic.start();
	}

	public void disenableIntroComponents() {
		this.isMain = true;
		this.gameStartButton.setVisible(false);
		this.gameQuitButton.setVisible(false);
		selectedMusic.close();
	}

	// Music Select Screen
	public void enableMainComponents() {
		this.isMain = true;
		this.isInGame = false;
		this.background = new ImageIcon(getClass().getResource("../img/music_background.jpg")).getImage();
		this.toMainButton.setVisible(true);
		this.selectLeftButton.setVisible(true);
		this.selectRightButton.setVisible(true);
		this.easyModeButton.setVisible(true);
		this.hardModeButton.setVisible(true);
		this.menubar.setVisible(true);
		this.gameExitButton.setVisible(true);
		this.toMainButton.setVisible(true);
	}

	public void disenableMainComponents() {
		this.isMain = false;
		this.toMainButton.setVisible(false);
		this.selectLeftButton.setVisible(false);
		this.selectRightButton.setVisible(false);
		this.easyModeButton.setVisible(false);
		this.hardModeButton.setVisible(false);
		this.gameExitButton.setVisible(false);
		this.toMainButton.setVisible(false);
		this.selectedMusic.close();
	}

	public void disenableInGameComponents() {
		this.menubar.setVisible(true);
		this.gameExitButton.setVisible(true);
		this.toMainButton.setVisible(true);
	}

	// Game Play Screen
	public void enableGameComponents() {

	}

	public void disenableGameComponents() {

	}

}

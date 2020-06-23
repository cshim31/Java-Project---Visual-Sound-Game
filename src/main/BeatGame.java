package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import music.Music;

public class BeatGame extends JFrame {

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
	private ImageIcon toMainImage = new ImageIcon(getClass().getResource("../img/ToMainButton.png"));
	private ImageIcon selectLeft = new ImageIcon(getClass().getResource("../img/SelectButtonLeft.png"));
	private ImageIcon selectRight = new ImageIcon(getClass().getResource("../img/SelectButtonRight.png"));

	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../img/menubar3.png")));
	private JButton gameExitButton = new JButton(gameExitButtonExited);
	private JButton gameStartButton = new JButton(startButtonImage);
	private JButton gameQuitButton = new JButton(quitButtonImage);
	private JButton toMainButton = new JButton(toMainImage);
	private JButton selectLeftButton = new JButton(selectLeft);
	private JButton selectRightButton = new JButton(selectRight);

	private Music selectedMusic = new Music("Razihel - Love U.mp3", true);

	private boolean isMain = true;

	private ArrayList<Track> trackList = new ArrayList<Track>();

	private int nowSelected = 0;

	private Graphics screenGraphic;

	private int mouseX, mouseY;

	private Image screenImage;
	private Image songImage;
	private Image songTitle;

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

		// Update musics in track list
		trackList.add(new Track("Joakim Karud - Mighty Love (preview).jpg", "MightyLove.png", "Ant Saunders - Yellow Hearts (preview).mp3", "Joakim Karud - Mighty Love.jpg",
				"Mighty Love - Joakim Karud.mp3"));
		trackList.add(new Track("Vendredi - Follow Me (preview).jpg","YellowHeartsTitle.png","Follow Me - Vendredi (preview).mp3","Vendredi - Follow Me.jpg","Follow Me - Vendredi.mp3"));
		trackList.add(new Track("Ant Saunders - Yellow Hearts (preview).jpg","FollowmeTitle.png","Mighty Love - Joakim Karud (preview).mp3","Ant Saunders - Yellow Hearts.jpg","Ant Saunders - Yellow Hearts.mp3"));

		//Load Interface
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

			// Disable and remove current interface components
			// Enable and add next interface components
			public void mousePressed(MouseEvent e) {
				Music buttonPressedSound = new Music("../music/mousePressed.mp3", false);
				buttonPressedSound.start();
				isMain = true;
				background = new ImageIcon(Main.class.getResource("../img/intro_background (revised).png")).getImage();
				disableMusicSelectComponents();
				enableMainComponents();
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
				
				//Event
				selectedMusic.close();
				gameStartButton.setVisible(false);
				gameQuitButton.setVisible(false);
				background = new ImageIcon(getClass().getResource("../img/music_background.jpg")).getImage();
				isMain = false;
				disableMainComponents();
				enableMusicSelectComponents();
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
		disableMusicSelectComponents();
		enableMainComponents();
		selectedMusic.start();
	}

	public void enableMainComponents() {
		this.gameStartButton.setVisible(true);
		this.gameQuitButton.setVisible(true);
	}

	public void disableMainComponents() {
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

	// paint auto-executed once rendered
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (!isMain) {
			g.drawImage(songImage, 340, 100, null);
			g.drawImage(songTitle, 340, 70, null);
		}
		paintComponents(g);
		this.repaint();
	}

	// Show track list in left direction and play the music
	public void selectLeft() {
		if(nowSelected > 0) {
			--nowSelected;
		} else {
			nowSelected = trackList.size() - 1;
		}
		selectTrack(nowSelected);
	}
	
	// Show track list in right direction and play the music
	public void selectRight() {
		if(nowSelected < trackList.size() - 1) {
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
}

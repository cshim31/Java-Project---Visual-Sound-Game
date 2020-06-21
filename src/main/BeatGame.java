package main;

import java.awt.Color;
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
	private Image introBackground = new ImageIcon(Main.class.getResource("../img/music_background.jpg")).getImage();
	private ImageIcon exitButtonExited = new ImageIcon(getClass().getResource("../img/exitButtonExited.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(getClass().getResource("../img/exitButtonEntered.png"));
	
	// Sounds
	Music introMusic = new Music("Ant Saunders - Yellow Hearts.mp3", true);
	Music buttonEnteredSound = new Music("../music/mouseEntered.mp3",false);
	Music buttonPressedSound = new Music("../music/mousePressed.mp3",false);
	
	//Interface Components
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../img/menubar.png")));
	private JButton exitButton = new JButton(exitButtonExited);

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

		//ExitButton Component
		exitButton.setBounds(983, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// Event Listener
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonEnteredSound.start();
				exitButton.setIcon(exitButtonEntered);
			}

			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonExited);
			}
			
			public void mousePressed(MouseEvent e) {
				buttonPressedSound.start();
				try {
					Thread.sleep(1000);
				}catch(Exception exception) {
					exception.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		//Menubar component
		menubar.setBounds(0, 0, 1200, 30);
		// Event Listener
		menubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// mouseX, mouseY = position relative to component
				mouseX = e.getX();
				mouseY = e.getY();
				
				System.out.println("x :"+mouseX+" y: "+mouseY);
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
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}

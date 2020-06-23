package main;

public class Track {
	private String musicImage;
	private String musicTitle;
	private String musicPreview;
	private String gameImage;
	private String gameMusic;
	
	public Track(String musicImage, String musicTitle, String musicPreview, String gameImage, String gameMusic) {
		super();
		this.musicImage = musicImage;
		this.musicTitle = musicTitle;
		this.musicPreview = musicPreview;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
	}
	
	public String getMusicImage() {
		return musicImage;
	}
	public void setMusicImage(String musicImage) {
		this.musicImage = musicImage;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicPreview() {
		return musicPreview;
	}
	public void setMusicPreview(String musicPreview) {
		this.musicPreview = musicPreview;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
}

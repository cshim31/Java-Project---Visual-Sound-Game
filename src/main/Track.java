package main;

public class Track {
	private String musicImage;	// Preview image on selected
	private String musicTitle;	// Preview title image on selected
	private String musicPreview;// Preview Music on selected
	private String gameImage;	// In - Game Music Image
	private String gameMusic;	// In - Game Music 
	private String titleName; 	// Music Title
	
	public Track(String musicImage, String musicTitle, String musicPreview, String gameImage, String gameMusic, String titleName) {
		super();
		this.musicImage = musicImage;
		this.musicTitle = musicTitle;
		this.musicPreview = musicPreview;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
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
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
}

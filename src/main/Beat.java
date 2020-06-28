package main;

import main.Note.NoteLength;
import main.Note.NoteType;

public class Beat {
	enum NoteType {
		SPECIAL, NORMAL;
	}
	
	enum NoteLength {
		LONG, SHORT;
	}
	enum NoteName {
		Q,W,E,R,SPACE,ENTER;
	}
	private NoteType noteType;
	private NoteLength noteLength;
	private int time;
	private NoteName noteName;
	
	public Beat(int time, NoteName noteName,NoteType noteType, NoteLength noteLength) {
		super();
		this.time = time;
		this.noteName = noteName;
		this.noteType = noteType;
		this.noteLength = noteLength;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public NoteName getNoteName() {
		return noteName;
	}
	public void setNoteName(NoteName noteName) {
		this.noteName = noteName;
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
	
}

package main;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class KeyAction extends AbstractAction{
	
	enum Action {
		Q_PRESSED, W_PRESSED, E_PRESSED, R_PRESSED, SPACE_PRESSED, ENTER_PRESSED,
		Q_RELEASED, W_RELEASED, E_RELEASED, R_RELEASED, SPACE_RELEASED, ENTER_RELEASED;
	}
	
	Action action;
	
	public KeyAction(Action action) {
		this.action = action;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (this.action) {
		case Q_PRESSED :
			BeatGame.game.pressQ();
			break;
		case Q_RELEASED :
			BeatGame.game.releaseQ();
			break;
		case W_PRESSED :
			BeatGame.game.pressW();
			break;
		case W_RELEASED :
			BeatGame.game.releaseW();
			break;
		case E_PRESSED :
			BeatGame.game.pressE();
			break;
		case E_RELEASED :
			BeatGame.game.releaseE();
			break;
		case R_PRESSED : 
			BeatGame.game.pressR();
			break;
		case R_RELEASED :
			BeatGame.game.releaseR();
			break;
		case SPACE_PRESSED :
			BeatGame.game.pressSPACE();
			break;
		case SPACE_RELEASED :
			BeatGame.game.releaseSPACE();
			break;
		case ENTER_PRESSED :
			BeatGame.game.pressENTER();
			break;
		case ENTER_RELEASED :
			BeatGame.game.releaseENTER();
			break;
		}
	}

}

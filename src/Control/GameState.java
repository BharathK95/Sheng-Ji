package Control;

public abstract class GameState {

	
	abstract void enter();
	
	abstract GameState processEvent();
	
}

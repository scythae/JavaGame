package game.state;

import game.entities.creature.Player;

public class GameState extends State{

	Player player;
	
	public GameState() {		
		player = new Player(20, 0);
	}
	
	@Override
	public void tick() {
		player.tick();		
	}

	@Override
	public void render() {
		player.render();
	}
}

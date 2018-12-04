package game.frameworks;

import game.gfx.Image;

public interface Framework {
	Display getDisplay();
	InputManager getInputManager();
	Image createImage(String path);
	void close();
}

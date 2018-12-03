package game.frameworks;

import game.gfx.Image;

public interface Framework {
	Display GetDisplay();
	InputManager GetInputManager();
	Image createImage(String path);
	void close();
}

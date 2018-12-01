package game.frameworks;

import game.display.Display;
import game.gfx.Image;
import game.input.InputManager;

public interface Framework {
	Display GetDisplay();
	InputManager GetInputManager();
	Image createImage(String path);
}

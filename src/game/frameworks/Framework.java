package game.frameworks;

import game.display.Display;
import game.input.InputManager;

public interface Framework {
	Display GetDisplay();
	InputManager GetInputManager();
}

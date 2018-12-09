package game.frameworks.swing;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.gfx.Image;

class SwingImage implements Image{
	private BufferedImage bufferedImage;

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public SwingImage loadFromFile(String path) {
		try {
			bufferedImage = ImageIO.read(SwingImage.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return this;
	}

	@Override
	public Image getSubimage(int x, int y, int width, int height) {
		SwingImage result = new SwingImage();
		result.bufferedImage = bufferedImage.getSubimage(x, y, width, height);
		return result;
	}
}

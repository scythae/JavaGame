package game.gfx.animations;

import game.gfx.Image;

public class AnimationFactory {
	private static int FRAMES_PER_IMAGE_DEFAULT = 6;

	private static AnimationFactory instance;
	private Animator animator;

	private boolean loop, reversible;
	private Image[] images;
	private int framesPerImage;

	private AnimationFactory() {}

	static public AnimationFactory getInstance(Animator animator) {
		if (instance == null)
			instance = new AnimationFactory();

		instance.reset();
		instance.animator = animator;

		return instance;
	}

	private void reset() {
		loop = false;
		reversible = false;
		images = null;
		framesPerImage = FRAMES_PER_IMAGE_DEFAULT;
	}

	public AnimationFactory setImages(Image[] images) {
		this.images = images;
		return this;
	}

	public AnimationFactory setImage(Image image) {
		return setImages(new Image[] {image});
	}

	public AnimationFactory setReversible() {
		reversible = true;
		return this;
	}

	public AnimationFactory setLooped() {
		loop = true;
		return this;
	}

	public AnimationFactory setFramesPerImage(int framesPerImage) {
		this.framesPerImage = framesPerImage;
		return this;
	}

	public void createIdle() {
		animator.idle = createAnimation();
	}

	public void createBirth() {
		animator.birth = createAnimation();
	}

	public void createDeath() {
		animator.death = createAnimation();
	}

	public void createMove() {
		animator.move = createAnimation();
	}

	private Animation createAnimation() {
		if (images == null)
			throw new RuntimeException("Animation must contain positive number of images");

		Animation result = new Animation();
		result.loop = loop;
		result.reversible = reversible;
		result.images = images;
		result.imageCount = images.length;
		result.framesPerImage = framesPerImage;

		return result;
	}
}

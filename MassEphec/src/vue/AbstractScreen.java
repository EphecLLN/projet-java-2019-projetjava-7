package vue;

import com.badlogic.gdx.Screen;

import Main.MassEphec;

public abstract class AbstractScreen implements Screen {
	
	private MassEphec app;
	
	public AbstractScreen(MassEphec app) {
		this.app = app;
	}

	@Override
	public abstract void dispose();

	@Override
	public abstract void hide();

	@Override
	public abstract void pause();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int heigth);

	@Override
	public abstract void resume();
	@Override
	public abstract void show();

}

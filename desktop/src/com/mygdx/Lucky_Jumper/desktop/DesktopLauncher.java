package com.mygdx.Lucky_Jumper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.Lucky_Jumper.GameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=(int) GameClass.WIDTH;
		config.height= (int) GameClass.HEIGTH;
		new LwjglApplication(new GameClass(), config);
	}
}

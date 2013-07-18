package de.tud.gdi1.boulderdash.ui;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.tud.gdi1.dropofwater.ui.GameplayState;
import de.tud.gdi1.dropofwater.ui.MainMenuState;
import de.tud.gdi1.dropofwater.ui.OptionsState;
import eea.engine.entity.StateBasedEntityManager;



public class Boulderdash extends StateBasedGame{
	
	public static final Vector2f SCREEN_SIZE = new Vector2f(800, 600);
	public static final Vector2f TILE_SIZE = new Vector2f(20, 20);
	
    public static final int MENU_STATE = 0;
    public static final int GAME_STATE = 1;
    public static final int OPT_STATE =  2;
	
	public Boulderdash() {
		super("Boulderdash");
	}
	

	
	
	public static void main(String[] args) throws SlickException
    {
	/*
    	// Setze den library Pfad abhaengig vom Betriebssystem
    	if (System.getProperty("os.name").toLowerCase().contains("windows")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/windows");
    	} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/macosx");
    	} else {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/" +System.getProperty("os.name").toLowerCase());
    	}
	*/
    	
    	// Setze dieses StateBasedGame in einen App Container (oder Fenster)
        AppGameContainer app = new AppGameContainer(new Boulderdash());
 
        // Lege die Einstellungen des Fensters fest und starte das Fenster
        // (nicht aber im Vollbildmodus)
        app.setDisplayMode((int) SCREEN_SIZE.x, (int) SCREEN_SIZE.y, false);
        app.setShowFPS(false);
        
        
        
        app.start();
    }

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MenuState(MENU_STATE));
        addState(new GameState(GAME_STATE));
        addState(new OptState(OPT_STATE));
        
        StateBasedEntityManager.getInstance().addState(MENU_STATE);
        StateBasedEntityManager.getInstance().addState(GAME_STATE);
        StateBasedEntityManager.getInstance().addState(OPT_STATE);
		
    }
}

package de.tud.gdi1.boulderdash.tests.adapter;

import java.io.IOException;

import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;

public class BoulderDashTestAdapterExtended1 extends BoulderDashTestAdapterMinimal{

	public BoulderDashTestAdapterExtended1() {
		super();
	}
	
	/**
	 * Pausiert das Spiel. Die Zeit soll nicht weiterlaufen und auch Bewegungen auf dem Spiel sollen deaktiviert werden.
	 */
	public void pauseGame(){
		/* To be done */
	}

	/**
	 * Setzt das Spiel fort. Die Zeit laeuft weiter und Bewegungen auf dem Spiel sind wieder moeglich.
	 */
	public void resumeGame(){
		/* To be done */
	}
	
	/**
	 * Ein gespeichertes Spiel soll geladen werden.
	 * @param s Ort des Spielstands als String
	 * @throws SyntaxException
	 * @throws SemanticException
	 * @throws IOException
	 */
	public void loadSaveGame(String s) throws SyntaxException, SemanticException, IOException{
		/* To be done */
	}
	
	/**
	 * Erstellt einen String im vorgegebenen Format der anschließend dazu genutzt werden kann um das Spiel in eine Datei zu schreiben
	 * @return Momentander Spielstand als String
	 */
	public String createSaveGameString(){
		/* To be done */
		return "YourSavegameString";
	}
	
	/**
	 * Initialisiert die Highscoreliste. Keine Scores sollen in der Liste sein
	 */
	public void initHighscoreList(){
		/* To be done */
	}
	
	/**
	 * Fuegt einen Score einem bestimmten Level hinzu.
	 * @param score Wert der eingespeichert werden soll
	 * @param lvl In welches Level der Score eingespeichert werden soll
	 */
	public void addHighscore(int score, int lvl){
		/* To be done */
	}
	
	/**
	 * Gibt einen Score an einer bestimmen Position zurueck. Die Werte sollen nach Score sortiert werden. Der hoechste Wert soll an erster Stelle stehen
	 * @param position Position des Scores
	 * @param lvl Aus welchem Level der Score extrahiert werden soll
	 * @return Score an bestimmter Stelle aus bestimmten Lvl
	 */
	public int getHighscoreEntry(int position, int lvl){
		/* To be done */
		return 0;
	}
	
	/**
	 * Gibt die Anzahl der Highscores fuer ein Level zurueck.
	 * @param lvl Aus welchem Level die Scores genommen werden soll
	 * @return Anzahl der Scores fuer das Level
	 */
	public int getNumOfHighscoreEntriesForLvl(int lvl){
		/* To be done */
		return 0;
	}
}

package de.tud.gdi1.boulderdash.tests.adapter;

import java.io.IOException;

import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;

public class BoulderDashTestAdapterMinimal {
	
	
	public BoulderDashTestAdapterMinimal() {
		/* To be done */
	}
	
	/**
	 * X-Wert des Spielers
	 * @return x-position als integer
	 */
	public int getPlayerXPosition() {
		/* To be done */
		return 0;
	}
	/**
	 * Y-Wert des Spielers
	 * @return y-position als integer
	 */
	public int getPlayerYPosition() {
		/* To be done */
		return 0;
	}
	/**
	 * Laedt das Level ein
	 * @param file
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	public void loadLevelFromFile(String file) throws SyntaxException, SemanticException {
		/* To be done */
	}
	/**
	 * Zaehlt die Diamanten auf der Karte
	 * @return Anzahl der Diamanten auf der Karte
	 */
	public int countDiamondsOnMap() {
		/* To be done */
		return 0;
	}
	/**
	 * Zaehlt die Gegner auf der Karte (Alle Typen)
	 * @return Anzahl der Gegner auf der Karte
	 */
	public int countEnemysOnMap() {
		/* To be done */
		return 0;
	}
	/**
	 * Zaehlt die Boulder auf der Karte
	 * @return Anzahl der Boulder auf der Karte
	 */
	public int countBouldersOnMap() {
		/* To be done */
		return 0;
	}
	/**
	 * Zaehlt die Erd-Felder auf der Karte
	 * @return Anzahl der Erd-Felder auf der Karte
	 */
	public int countMudOnMap() {
		/* To be done */
		return 0;
	}
	/**
	 * Prueft ob das Spiel verloren ist
	 * @return Wahr oder Falsch, je nachdem ob das Spiel verloren ist
	 */
	public boolean isGameLost() {
		/* To be done */
		return false;
	}
	/**
	 * Prueft ob das Spiel gewonnen ist
	 * @return Boolscher Wert
	 */
	public boolean isGameWon() {
		/* To be done */
		return false;
	}
	/**
	 * Gibt das Level (und nur das Level) als String aus.
	 * @return Darstellng des Levels als String
	 */
	public String getGameAsString() {
		/* To be done */
		return "Your game represented as a string";
	}
	/**
	 * Bewegt den Spieler auf der Karte nach links sofern moeglich
	 */
	public void movePlayerLeftAction() {
		/* To be done */
	}
	/**
	 * Bewegt den Spieler auf der Karte nach rechts sofern moeglich
	 */
	public void movePlayerRightAction() {
		/* To be done */
	}
	/**
	 * Bewegt den Spieler auf der Karte nach oben sofern moeglich
	 */
	public void movePlayerUpAction() {
		/* To be done */
	}
	/**
	 * Bewegt den Spieler auf der Karte nach unten sofern moeglich
	 */
	public void movePlayerDownAction() {
		/* To be done */
	}
	/**
	 * Fuehrt die Gravitation aus. Standardmaessig sind nur Steine und Diamanten davon betroffen
	 */
	public void moveRocksAndDiamonds() {
		/* To be done */
	}
	/**
	 * Gibt dne aktuellen Diamanten-Score zurueck
	 * @return
	 */
	public int getHighscore() {
		/* To be done */
		return 0;
	}
	/**
	 * Gibt zurueck wieviele Punkte fuer das aktuelle Level benoetgt werden um den Ausgang zu oeffnen
	 * @return
	 */
	public int getHighscoreNeeded(){
		/* To be done */
		return 0;
	}
	/**
	 * Startet das Level neu
	 */
	public void restartGame() {
		/* To be done */
	}
	/**
	 * Bewegt alle linken Walker
	 */
	public void doLeftEnemyMovement() {
		/* To be done */
	}
	/**
	 * Prueft ob der Spieler an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isPlayerOnPosition(int x, int y){
		/* To be done */
		return false;
	}
	/**
	 * Prueft ob ein Boulder an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isBoulderOnPosition(int x, int y){
		/* To be done */
		return false;
	}
	
	/**
	 * Prueft ob ein linker Walker an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isLeftWalkerOnPosition(int x, int y){
		/* To be done */
		return false;
	}
	
	/**
	 * Prueft ob ein Boulder an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isDiamondOnPosition(int x, int y){
		/* To be done */
		return false;
	}
	
	/**
	 * Prueft ob ein Erd-Feld an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isMudOnPosition(int x, int y){
		/* To be done */
		return false;
	}
	
	/**
	 * Prueft ob ein leeres Feld an einer Position im Spielfeld ist
	 * @param x X-Koordinate des Spielfelds
	 * @param y Y-Koordinate des Spielfelds
	 * @return Boolscher Wert
	 */
	public boolean isEmptyFieldOnPosition(int x, int y){
		/* To be done */
		return false;
	}
}

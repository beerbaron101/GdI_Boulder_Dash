package de.tud.gdi1.boulderdash.tests.students;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;
import de.tud.gdi1.boulderdash.tests.adapter.BoulderDashTestAdapterMinimal;

public class BoulderdashStudentsTestMinimal {
	
	protected BoulderDashTestAdapterMinimal adapter;
	
	@Before
	public void setUp() {
		adapter = new BoulderDashTestAdapterMinimal();
	}
	
	/**
	 * Testet ob eine Semantic Exception geworfen wird wenn der Spieler auf der Karte fehlt
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test(expected=SemanticException.class)
	public void testPlayerMissing() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/PlayerMissingMap.bdh");
	}
	
	/**
	 * Testet ob eine Semantic Exception geworfen wird wenn das Ziel auf der Karte fehlt
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test(expected=SemanticException.class)
	public void testGoalMissing() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/PlayerMissingMap.bdh");
	}
	
	/**
	 * Testet ob eine Semantic Exception geworfen wird wenn die Karte keine umschlossene Mauer besitzt
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test(expected=SemanticException.class)
	public void testWallIncomplete() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/PlayerMissingMap.bdh");
	}
	
	/**
	 * Testet ob eine SyntaxException geworfen wird wenn die Karte unbekannte Symbole enthaelt
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test(expected=SyntaxException.class)
	public void testMapContainsUnknownSymbols() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/SyntaxExceptionMap.bdh");
	}
	
	/**
	 * Testet ob eine SyntaxException geworfen wird wenn die Karte eine falsche Spielgr��e besitzt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test(expected=SyntaxException.class)
	public void testMapOfWrongSize() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/SyntaxException2Map.bdh");
	}
	
	/**
	 * Dieser Test ist dazu da um die Bewegungen des Spielers zu validieren.
	 * @throws SemanticException 
	 * @throws SyntaxException 
	 */
	@Test
	public void testLoadCorrectlyAndMoveAroundEmptyField() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/EmptyMap.bdh");
		int startX = adapter.getPlayerXPosition();
		int startY = adapter.getPlayerYPosition();
		assertTrue("Spieler startet an der falschen Stelle. Sollte x-Position 22 Sein", startX == 22);
		assertTrue("Spieler startet an der falschen Stelle. Sollte y-Position 12 Sein", startY == 12);
		adapter.movePlayerRightAction();
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 23 && adapter.getPlayerYPosition() == 12);
		adapter.movePlayerDownAction();
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 23 && adapter.getPlayerYPosition() == 13);
		adapter.movePlayerLeftAction();
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 22 && adapter.getPlayerYPosition() == 13);
		adapter.movePlayerUpAction();
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 22 && adapter.getPlayerYPosition() == 12);
	}
	
	/**
	 * Dieser Test dient dazu die leeren Felder die hinter dem Spieler entstehen zu validieren.
	 * @throws SemanticException 
	 * @throws SyntaxException 
	 */
	@Test
	public void testLoadCorrectlyAndCreateEmptyFieldTrail() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MudMap.bdh");
		int startX = adapter.getPlayerXPosition();
		int startY = adapter.getPlayerYPosition();
		assertTrue("Spieler startet an der falschen Stelle. Sollte x-Position 22 Sein", startX == 22);
		assertTrue("Spieler startet an der falschen Stelle. Sollte y-Position 12 Sein", startY == 12);
		adapter.movePlayerRightAction();
		assertTrue("Altes Feld sollte ein EmptyField sein", adapter.isEmptyFieldOnPosition(22, 12));
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 23 && adapter.getPlayerYPosition() == 12);
		adapter.movePlayerDownAction();
		assertTrue("Altes Feld sollte ein EmptyField sein", adapter.isEmptyFieldOnPosition(23, 12));
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 23 && adapter.getPlayerYPosition() == 13);
		adapter.movePlayerLeftAction();
		assertTrue("Altes Feld sollte ein EmptyField sein", adapter.isEmptyFieldOnPosition(23, 13));
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 22 && adapter.getPlayerYPosition() == 13);
		adapter.movePlayerUpAction();
		assertTrue("Altes Feld sollte ein EmptyField sein", adapter.isEmptyFieldOnPosition(22, 13));
		assertTrue("Spieler wurde an eine falsche Stelle bewegt", adapter.getPlayerXPosition() == 22 && adapter.getPlayerYPosition() == 12);
	}
	
	/**
	 * Testet ob der Spieler durch Mauern laufen kann.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testWallWalking() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/EmptyMap.bdh");
		for(int i = 0; i < 6; i++){
			if(i < 3){
				adapter.movePlayerDownAction();
			}else{
				adapter.movePlayerUpAction();
			}
		}
		assertTrue("Spieler steht nicht an richtiger Stelle", adapter.isPlayerOnPosition(22, 12));
		for(int i = 0; i < 6; i++){
			if(i < 3){
				adapter.movePlayerLeftAction();
			}else{
				adapter.movePlayerRightAction();
			}
		}
		assertTrue("Spieler steht nicht an richtiger Stelle", adapter.isPlayerOnPosition(24, 12));
	}

	/**
	 * Dieser Test dient dazu zu �berpr�fen ob ein Spiel gewonnen werden kann.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testGameWon() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MultipleTestsMap.bdh");
		for(int i = 0; i < 4; i++){
			adapter.movePlayerRightAction();
		}
		for(int i = 0; i < 3; i++){
			adapter.movePlayerDownAction();
		}
		assertTrue("Das Spiel wurde nicht als gewonnen erkannt", adapter.isGameWon());
	}
	
	/**
	 * Dieser Test dient dazu zu �berpr�fen ob ein Spiel f�lschlicherweise als gewonnen z�hlt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testGameNotWon() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MultipleTestsMap.bdh");
		adapter.movePlayerDownAction();
		for(int i = 0; i < 4; i++){
			adapter.movePlayerRightAction();
		}
		adapter.movePlayerDownAction();
		adapter.movePlayerDownAction();
		assertTrue("Das Spiel wurde nicht als gewonnen erkannt", !adapter.isGameWon());
	}
	
	/**
	 * Dieser Test dient dazu zu �berpr�fen ob Diamanten eingesammelt und der Highscore erh�ht wird.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testCollectDiamonds() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MultipleTestsMap.bdh");
		int score = adapter.getHighscore();
		assertTrue("Score wurde nicht mit 0 initialisiert", score == 0);
		assertTrue("Es sind keine 4 Start-Diamanten auf der Map zu finden", adapter.countDiamondsOnMap() == 4);
		for(int i = 3; i >= 0; i--){
			adapter.movePlayerRightAction();
			score += 500;
			assertTrue("Score wurde nicht korrekt erhoeht", adapter.getHighscore() == score);
			assertTrue("Falsche Anzahl an Diamanten im Spielfeld", adapter.countDiamondsOnMap() == i);
		}
		assertTrue("Es sollten keine Diamanten mehr auf dem Feld sein", adapter.countDiamondsOnMap() == 0);
		assertTrue("Der Score sollte 2000 betragen", adapter.getHighscore() == 2000);
	}
	
	/**
	 * Dieser Test dient dazu zu �berpr�fen ob ein Neustart alles zur�cksetzt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testRestartLevel() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MultipleTestsMap.bdh");
		int boulders = adapter.countBouldersOnMap();
		int diamonds = adapter.countDiamondsOnMap();
		int enemys = adapter.countEnemysOnMap();
		int mud = adapter.countMudOnMap();
		int score = adapter.getHighscore();
		for(int i = 3; i >= 0; i--){
			adapter.movePlayerRightAction();
		}
		for(int i = 1; i >= 0; i--){
			adapter.movePlayerDownAction();
		}
		assertTrue("Boulder sind verschwunden", boulders == adapter.countBouldersOnMap());
		assertTrue("Die Diamantenanzahl ist gr��er oder gleich geblieben", diamonds > adapter.countDiamondsOnMap());
		assertTrue("Die Dreck-Feld Anzahl ist gr��er oder gleich geblieben", mud > adapter.countMudOnMap());
		assertTrue("Der Score hat sich nicht erhoeht", score < adapter.getHighscore());
		adapter.restartGame();
		assertTrue("Nach Neustart ist die Boulderanzahl unterschiedlich", boulders == adapter.countBouldersOnMap());
		assertTrue("Nach Neustart ist die Diamantenanzahl unterschiedlich", diamonds == adapter.countDiamondsOnMap());
		assertTrue("Nach Neustart ist die Gegneranzahl unterschiedlich", enemys == adapter.countEnemysOnMap());
		assertTrue("Nach Neustart ist die Dreck-Feld Anzahl unterschiedlich", mud == adapter.countMudOnMap());
		assertTrue("Nach Neustart ist der Highscore unterschiedlich", score == adapter.getHighscore());
	}
	
	/**
	 * Dieser Test dient dazu zu �berpr�fen ob die Gravitation richtig ausgef�hrt wird.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testGravity() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MultipleTestsMap.bdh");
		int boulders = adapter.countBouldersOnMap();
		int diamonds = adapter.countDiamondsOnMap();
		adapter.moveRocksAndDiamonds();
		assertTrue("Nach Gravitation ist die Boulderanzahl unterschiedlich", boulders == adapter.countBouldersOnMap());
		assertTrue("Nach Gravitation ist die Diamantenanzahl unterschiedlich", diamonds == adapter.countDiamondsOnMap());
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(22, 15));
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(24, 15));
		assertTrue("Diamant nicht an der richtigen Stelle", adapter.isDiamondOnPosition(23, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(22, 15));
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(24, 15));
		assertTrue("Diamant nicht an der richtigen Stelle", adapter.isDiamondOnPosition(23, 14));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(22, 15));
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(24, 15));
		assertTrue("Diamant nicht an der richtigen Stelle", adapter.isDiamondOnPosition(23, 15));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(22, 15));
		assertTrue("Boulder nicht an der richtigen Stelle", adapter.isBoulderOnPosition(24, 15));
		assertTrue("Diamant nicht an der richtigen Stelle", adapter.isDiamondOnPosition(23, 15));
		assertTrue("Nach Gravitation ist die Boulderanzahl unterschiedlich", boulders == adapter.countBouldersOnMap());
		assertTrue("Nach Gravitation ist die Diamantenanzahl unterschiedlich", diamonds == adapter.countDiamondsOnMap());
	}
	
	/**
	 * Testet ob der linke Computergegner richtige Laufwegen vorweist.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testLeftWalkerMovement() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/LeftWalkerMap.bdh");
		assertTrue("Walker wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		
		// Gehe 5 mal in der Luft
		for(int i=0; i<5; i++)
		{  
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 15));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(25, 15));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(25, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 14));
		}
	}
	
	/**
	 * Testet ob der linke Computergegner richtige Laufwegen vorweist.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testLeftWalkerMovementExtended() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/LeftWalkerMapExtended.bdh");
		// Gehe 5 mal durch das Kreuz
		for(int i=0; i<5; i++)
		{  
		assertTrue("Walker wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 15));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(22, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 13));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(23, 14));
		adapter.doLeftEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 14));
		}
	}
	
	/**
	 * Testet ob der Spieler Boulder korrekt schieben kann.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testMoveBoulder() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/minimal/MoveBoulderMap.bdh");
		adapter.movePlayerRightAction();
		adapter.movePlayerRightAction();
		adapter.movePlayerDownAction();
		assertTrue("Boulder ist verschwunden", adapter.countBouldersOnMap() == 1);
		assertTrue("Boulder ist an falscher Stelle", adapter.isBoulderOnPosition(24, 13));
		adapter.movePlayerRightAction();
		adapter.movePlayerDownAction();
		adapter.movePlayerLeftAction();
		assertTrue("Boulder wurde nicht bewegt", adapter.isBoulderOnPosition(23, 13));
		assertTrue("Spieler hat sich nicht bewegt", adapter.isPlayerOnPosition(24, 13));
		adapter.movePlayerLeftAction();
		assertTrue("Boulder wurde nicht bewegt", adapter.isBoulderOnPosition(22, 13));
		assertTrue("Spieler hat sich nicht bewegt", adapter.isPlayerOnPosition(23, 13));
	}
}
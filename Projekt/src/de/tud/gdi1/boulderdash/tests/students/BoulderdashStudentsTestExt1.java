package de.tud.gdi1.boulderdash.tests.students;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;
import de.tud.gdi1.boulderdash.tests.adapter.BoulderDashTestAdapterExtended1;

public class BoulderdashStudentsTestExt1 {

	BoulderDashTestAdapterExtended1 adapter;
	
	@Before
	public void setUp() {
		adapter = new BoulderDashTestAdapterExtended1();
	}
	
	/**
	 * Testes ob ein gespeichertes Spiel geladen werden kann.
	 * @throws SyntaxException
	 * @throws SemanticException
	 * @throws IOException
	 */
	@Test
	public void loadGameTest() throws SyntaxException, SemanticException, IOException{
		adapter.loadSaveGame("testmaps/ext1/saveLoadGameMap.bdh");
		assertTrue("Spieler startet an der falschen Stelle. Position sollte (22,12) sein", adapter.isPlayerOnPosition(22, 12));
		assertTrue("Nicht alle Boulder wurden geladen", adapter.countBouldersOnMap() == 2);
		assertTrue("Nicht alle Diamanten wurden geladen", adapter.countDiamondsOnMap() == 2);
		assertTrue("Nicht alle Gegner wurden geladen", adapter.countEnemysOnMap() == 2);
		assertTrue("Nicht alle Erd-Felder wurden geladen", adapter.countMudOnMap() == 5);
		assertTrue("Der Highscore wurde falsch geladen", adapter.getHighscore() == 1000);
		assertTrue("Der MaxHighscore wurde falsch geladen", adapter.getHighscoreNeeded() == 500);
	}
	
	/**
	 * Testet ob der SaveGameString richtig erstellt wird.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void saveGameTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext1/saveLoadGameMap.bdh");
		StringBuffer sb = new StringBuffer();
		sb.append(adapter.getHighscore()+"\n"+adapter.getHighscoreNeeded()+"\n50\n120\n"+adapter.getGameAsString());
		assertTrue("SaveGameString ist nicht so wie er aussehen sollte", sb.toString().equalsIgnoreCase(adapter.createSaveGameString()));
	}
	
	/**
	 * Testet ob sich das Spielfeld waehrend einer pause veraendern kann
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void pauseDisablesGameTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext1/testPauseGameMap.bdh");
		adapter.pauseGame();
		String originalString = adapter.toString();
		adapter.moveRocksAndDiamonds();
		adapter.movePlayerDownAction();
		adapter.movePlayerLeftAction();
		adapter.doLeftEnemyMovement();
		adapter.moveRocksAndDiamonds();
		adapter.movePlayerLeftAction();
		adapter.movePlayerUpAction();
		adapter.movePlayerRightAction();
		assertTrue("Das Spiel hat sich veraendert", adapter.toString().equalsIgnoreCase(originalString));
	}
	
	/**
	 * Testet ob ein Highscore zum richtigen Lvl hinzugefuegt wird
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void addHighscoreToLvl() throws SyntaxException, SemanticException{
		int lvl = 1;
		int highscore = 1000;
		adapter.initHighscoreList();
		adapter.addHighscore(highscore, lvl);
		assertTrue("Highscore ist nicht identisch", adapter.getHighscoreEntry(0, lvl) == highscore);
		assertTrue("Es sind mehr oder weniger als 1 Highscore fuer dieses Lvl eingetragen", adapter.getNumOfHighscoreEntriesForLvl(lvl) == 1);
	}
	
	/**
	 * Testet ob mehrere Highscores zum richtigen Lvl hinzugefuegt werden und ob diese in der richtigen Reihenfolge sortiert werden
	 */
	@Test
	public void addMultipleHighscoresToLvlTest(){
		int lvl = 1;
		int[] highscores = {500,1000,501,20000};
		adapter.initHighscoreList();
		for (int score : highscores){
			adapter.addHighscore(score, lvl);
		}
		assertTrue("Keine 4 Eintraege fuer Level 1", adapter.getNumOfHighscoreEntriesForLvl(lvl) == 4);
		assertTrue("Groesster Eintrag ist nicht 20000", adapter.getHighscoreEntry(0, lvl) == 20000);
		assertTrue("Kleinster Eintrag ist nicht 500", adapter.getHighscoreEntry(3, lvl) == 500);
	}
	
	/**
	 * Testet ob die Highscores in die richtigen Lvl eingespeichert werden und ob die Sortierung korrekt ist.
	 */
	@Test
	public void addMultipleHighscoresToMultipleLvlsTest(){
		int[] lvl = {0,1,2};
		int[][] highscores = {{150,250,200},{75,50,60,65},{300,200}};
		adapter.initHighscoreList();
		for(int curLvl : lvl){
			int[] scores = highscores[curLvl];
			for (int score : scores){
				adapter.addHighscore(score, curLvl);
			}
		}
		assertTrue("Lvl 0 hat keine 3 Highscores, sondern "+adapter.getNumOfHighscoreEntriesForLvl(0), adapter.getNumOfHighscoreEntriesForLvl(0) == 3);
		assertTrue("Lvl 1 hat keine 4 Highscores, sondern "+adapter.getNumOfHighscoreEntriesForLvl(1), adapter.getNumOfHighscoreEntriesForLvl(1) == 4);
		assertTrue("Lvl 2 hat keine 2 Highscores, sondern "+adapter.getNumOfHighscoreEntriesForLvl(2), adapter.getNumOfHighscoreEntriesForLvl(2) == 2);
	}
	
	/**
	 * Testet ob der Boulder richtig herunterfaellt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testBoulderFallingRight() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext1/BoulderFallingRightMap.bdh");
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 8));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 9));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 9));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 10));
		adapter.moveRocksAndDiamonds();
		adapter.moveRocksAndDiamonds();
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 10));
	}
	
	/**
	 * Testet ob der Boulder richtig herunterfaellt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testBoulderFallingLeft() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext1/BoulderFallingLeftMap.bdh");
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 8));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 9));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 9));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 10));
		adapter.moveRocksAndDiamonds();
		adapter.moveRocksAndDiamonds();
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 10));
	}
	
	/**
	 * Testet ob der Boulder richtig herunterfaellt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testBoulderFallingLongrun() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext1/BoulderFallingExtended.bdh");
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 8));
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 12));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 9));
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 14));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 12));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(22, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder nicht auf richtiger Position", adapter.isBoulderOnPosition(23, 13));
		adapter.moveRocksAndDiamonds();
	}
	
	/**
	 * Testet ob der Gegner den Spieler toetet.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testWaysToDieByEnemy() throws SyntaxException, SemanticException{
			adapter.loadLevelFromFile("testmaps/ext1/introductionToDyingMap.bdh");
			assertTrue("Spieler nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isPlayerOnPosition(21, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 11));
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.doLeftEnemyMovement();
			adapter.doLeftEnemyMovement();
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.doLeftEnemyMovement();
			assertTrue("Spiel ist verloren.", adapter.isGameLost());
	}
	
	/**
	 * Testet ob der Boulder den Spieler erschlaegt.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testWayToDieByBoulder() throws SyntaxException, SemanticException{
			adapter.loadLevelFromFile("testmaps/ext1/introductionToDyingMap.bdh");
			assertTrue("Spieler nicht auf richtiger Position", adapter.isLeftWalkerOnPosition(24, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isPlayerOnPosition(21, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 11));
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.moveRocksAndDiamonds();
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.moveRocksAndDiamonds();
			assertTrue("Spiel ist verloren.", adapter.isGameLost());
			
	}
}

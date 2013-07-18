package de.tud.gdi1.boulderdash.tests.students;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;
import de.tud.gdi1.boulderdash.tests.adapter.BoulderDashTestAdapterExtended2;

public class BoulderdashStudentsTestExt2 {
	
	BoulderDashTestAdapterExtended2 adapter;
	
	@Before
	public void setUp() {
		adapter = new BoulderDashTestAdapterExtended2();
	}
	
	/**
	 * Testet ob die normale Explosion Diamanten erzeugt und den Gegner toetet.
	 */
	@Test
	public void normalExplosionTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/explosionMap.bdh");
		adapter.moveRocksAndDiamonds();
		assertTrue("Gegner ist nicht vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Es sind Diamanten auf der Map", adapter.countDiamondsOnMap() == 0);
		adapter.moveRocksAndDiamonds();
		assertTrue("Gegner ist nicht gestorben", adapter.countEnemysOnMap() == 0);
		assertTrue("Es sind keine 9 Diamanten auf der Map", adapter.countDiamondsOnMap() == 9);
	}
	
	/**
	 * Testet ob die Unzerstoerbares von der Explosion verschont bleibt.
	 */
	@Test
	public void indestructableExplosionTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/explosionIndestructableMap.bdh");
		adapter.moveRocksAndDiamonds();
		assertTrue("Gegner ist nicht vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Es sind Diamanten auf der Map", adapter.countDiamondsOnMap() == 0);
		adapter.moveRocksAndDiamonds();
		assertTrue("Gegner ist nicht gestorben", adapter.countEnemysOnMap() == 0);
		assertTrue("Es sind keine 8 Diamanten auf der Map", adapter.countDiamondsOnMap() == 8);
	}
	
	/**
	 * Testet ob die Zeit ordnungsgemaess ableuft.
	 */
	@Test
	public void timeOverTest() throws SyntaxException, SemanticException, InterruptedException{
		adapter.loadLevelFromFile("testmaps/ext2/timeMap.bdh");
		assertTrue("Zeit ist abgelaufen", !adapter.isTimeUp());
		Thread.sleep(2000);
		assertTrue("Zeit ist nicht abgelaufen", adapter.isTimeUp());
	}

	/**
	 * Testet ob eine Zauberwand Boulder erzeugt und ob diese in der Wand stecken koennen.
	 */
	@Test
	public void magicWallTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/magicWallMap.bdh");
		adapter.moveRocksAndDiamonds();
		adapter.moveRocksAndDiamonds();
		assertTrue("Diamant und Boulder sollten in der Wand sein und folglich nicht gezaehlt werden", adapter.countBouldersOnMap() == 0 && adapter.countDiamondsOnMap() == 0);
		adapter.moveRocksAndDiamonds();
		assertTrue("Diamant und Boulder sind nicht erschienen", adapter.countBouldersOnMap() == 1 && adapter.countDiamondsOnMap() == 1);
		assertTrue("Diamant ist an der falschen Stelle", adapter.isDiamondOnPosition(23, 15));
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(24, 15));
	}
	
	/**
	 * Testet ob eine Zauberwand Boulder erzeugt und ob diese in der Wand stecken koennen.
	 */
	@Test
	public void remainsOnWallTest() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/magicMoveWallMap.bdh");
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(23, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(23, 13));
		adapter.moveRocksAndDiamonds();
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(23, 13));
		adapter.movePlayerDownAction();
		adapter.movePlayerRightAction();
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(24, 13));
		adapter.movePlayerUpAction();
		adapter.movePlayerRightAction();
		adapter.movePlayerRightAction();
		adapter.movePlayerRightAction();
		adapter.movePlayerDownAction();
		adapter.movePlayerLeftAction();
		assertTrue("Boulder ist an der falschen Stelle", adapter.isBoulderOnPosition(23, 13));
	}
	
	/**
	 * Testet ob der rechte Computergegner richtige Laufwege vorweist.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testRightWalkerMovement() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/RightWalkerMap.bdh");
		assertTrue("Walker wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		
		// Gehe 5 mal in der Luft
		for(int i=0; i<5; i++)
		{  
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 15));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(22, 15));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(22, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		
		}
	}
	
	/**
	 * Testet ob der rechte Computergegner richtige Laufwege vorweist.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testRightWalkerMovementExtended() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext2/RightWalkerMapExtended.bdh");
		// Gehe 5 mal durch das Kreuz
		for(int i=0; i<5; i++)
		{  
		assertTrue("Walker wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(22, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 15));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(24, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 13));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(23, 14));
		adapter.doRightEnemyMovement();
		assertTrue("Walker nicht mehr vorhanden", adapter.countEnemysOnMap() == 1);
		assertTrue("Walker nicht auf richtiger Position", adapter.isRightWalkerOnPosition(22, 14));
		}
	}
	
	/**
	 * Testet ob der Gegner den Spieler toetet.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testWaysToDieByEnemy() throws SyntaxException, SemanticException{
			adapter.loadLevelFromFile("testmaps/ext2/testDyingAgain.bdh");
			assertTrue("Spieler nicht auf richtiger Position", adapter.isPlayerOnPosition(24, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isRightWalkerOnPosition(21, 13));
			assertTrue("Spieler nicht auf richtiger Position", adapter.isBoulderOnPosition(21, 11));
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.doRightEnemyMovement();
			adapter.doRightEnemyMovement();
			assertTrue("Spiel ist noch nicht verloren.", !adapter.isGameLost());
			adapter.doRightEnemyMovement();
			assertTrue("Spiel ist verloren.", adapter.isGameLost());
	}
}

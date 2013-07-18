package de.tud.gdi1.boulderdash.tests.students;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.tud.gdi1.boulderdash.exception.SemanticException;
import de.tud.gdi1.boulderdash.exception.SyntaxException;
import de.tud.gdi1.boulderdash.tests.adapter.BoulderDashTestAdapterExtended3;

public class BoulderdashStudentsTestExt3 {

	BoulderDashTestAdapterExtended3 adapter;
	
	@Before
	public void setUp() {
		adapter = new BoulderDashTestAdapterExtended3();
	}
	
	/**
	 * Testet ob der der Computergegner den Weg direkt findet.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testPersecutingWalkerMovementWay() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext3/persecutorMap.bdh");
		assertTrue("Persecutor wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		/*for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 30; j++) {
				if(adapter.isPlayerOnPosition(i, j))
					System.out.println(i +","+j);
			}	
		} */
		assertTrue("Player auf falschem Feld", adapter.isPlayerOnPosition(3, 6));
		assertTrue(adapter.isPersecutingWalkerOnPosition(10, 20));
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(9, 20));
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(8, 20));
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(7, 20));
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(7, 15));
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(3, 15));
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(3, 7));
		assertTrue("Spiel sollte noch nicht verloren sein.", !adapter.isGameLost());
		adapter.doPersecutingEnemyMovement();
		assertTrue("Spiel sollte noch verloren sein.", adapter.isGameLost());
		}
	
	/**
	 * Testet ob der der Computergegner den kuerzesten Weg direkt findet.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testPersecutingWalkerShortPath() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext3/persecutorMap2.bdh");
		assertTrue("Persecutor wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);
		/*for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 30; j++) {
				if(adapter.isPlayerOnPosition(i, j))
					System.out.println(i +","+j);
			}	
		} */
		assertTrue("Player auf falschem Feld", adapter.isPlayerOnPosition(12, 22));
		assertTrue(adapter.isPersecutingWalkerOnPosition(20, 21));
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(18, 21));
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(18, 20));
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(12, 20));
		adapter.doPersecutingEnemyMovement();
		assertTrue(adapter.isPersecutingWalkerOnPosition(12, 21));
		assertTrue("Spiel sollte noch nicht verloren sein.", !adapter.isGameLost());
		adapter.doPersecutingEnemyMovement();
		assertTrue("Spiel sollte noch verloren sein.", adapter.isGameLost());
		}
	
	
	/**
	 * Testet ob der der Computergegner den Weg direkt findet.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testPersecutingWalkerMovementNoPath() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext3/persecutorNoPathMap.bdh");
		assertTrue("Persecutor wurde nicht richtig geladen", adapter.countEnemysOnMap() == 1);		
		assertTrue("Player auf falschem Feld", adapter.isPlayerOnPosition(3, 6));
		assertTrue(adapter.isPersecutingWalkerOnPosition(10, 20));
		for (int i = 0; i < 100; i++) {
			adapter.doPersecutingEnemyMovement();
		}
		assertTrue(adapter.isPersecutingWalkerOnPosition(10, 20));
		assertTrue("Spiel sollte noch nicht verloren sein.", !adapter.isGameLost());
		}
	
	/**
	 * Testet einfach nochmal ob sich alle Gegner bewegen.
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	@Test
	public void testAllEnemiesSimple() throws SyntaxException, SemanticException{
		adapter.loadLevelFromFile("testmaps/ext3/allEnemies.bdh");
		assertTrue("Nicht genug Gegner auf dem Feld", adapter.countEnemysOnMap() == 6);
		
		assertTrue("Player auf falschem Feld", adapter.isPlayerOnPosition(2, 6));
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(4, 8));
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(17, 10));
		
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(25, 10));
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(33, 12));
		
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(25, 6));
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(31, 8));
		
		for (int i = 0; i < 4; i++) {
			adapter.doPersecutingEnemyMovement();
			adapter.doLeftEnemyMovement();
			adapter.doRightEnemyMovement();
		}
		
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(4, 12));
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(17, 8));
		
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(25, 12));
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(31, 10));
		
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(25, 8));
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(33, 6));
		
	
		for (int i = 0; i < 4; i++) {
			adapter.doPersecutingEnemyMovement();
			adapter.doLeftEnemyMovement();
			adapter.doRightEnemyMovement();
		}
	
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(3, 15));
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(14, 9));
		
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(25, 10));
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(33, 12));
		
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(25, 6));
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(31, 8));
	
		for (int i = 0; i < 8; i++) {
			adapter.doPersecutingEnemyMovement();
			adapter.doLeftEnemyMovement();
			adapter.doRightEnemyMovement();
		}
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(2, 8));
		assertTrue("Persecutor auf falschem Feld", adapter.isPersecutingWalkerOnPosition(19, 12));
		
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(25, 10));
		assertTrue("LeftWalker auf falschem Feld", adapter.isLeftWalkerOnPosition(33, 12));
		
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(25, 6));
		assertTrue("RightWalker auf falschem Feld", adapter.isRightWalkerOnPosition(31, 8));

		
		assertTrue("Spiel sollte noch nicht verloren sein.", !adapter.isGameLost());
		
		for (int i = 0; i < 2; i++) {
			adapter.doPersecutingEnemyMovement();
			adapter.doLeftEnemyMovement();
			adapter.doRightEnemyMovement();
		}
		
		assertTrue("Spiel sollte noch verloren sein.", adapter.isGameLost());
	}
}

package de.tud.gdi1.boulderdash.tests.students;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BoulderDashTestSuite {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Public tests for Boulderdash");
		suite.addTest(new JUnit4TestAdapter(BoulderdashStudentsTestMinimal.class));
		suite.addTest(new JUnit4TestAdapter(BoulderdashStudentsTestExt1.class));
		suite.addTest(new JUnit4TestAdapter(BoulderdashStudentsTestExt2.class));
		suite.addTest(new JUnit4TestAdapter(BoulderdashStudentsTestExt3.class));
		return suite;
	}
}

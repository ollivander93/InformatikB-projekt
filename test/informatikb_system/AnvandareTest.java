/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TP300LA-C4034
 */
public class AnvandareTest {
    
    public AnvandareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of valideraInloggning method, of class Anvandare.
     */
    @Test
    public void testValideraInloggning() {
        System.out.println("valideraInloggning");
        String anvandarnamn = "";
        String losenord = "";
        Anvandare instance = new Anvandare();
        boolean expResult = false;
        boolean result = instance.valideraInloggning(anvandarnamn, losenord);
        assertEquals(expResult, result);

    }

 
  
    
}

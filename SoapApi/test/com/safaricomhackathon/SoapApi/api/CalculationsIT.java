/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricomhackathon.SoapApi.api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jngetich
 */
public class CalculationsIT {

    public CalculationsIT() {
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
     * Test of addition method, of class Calculations.
     */
    @Test
    public void testAddition() {
        System.out.println("addition method test");
        int a = 5;
        int b = 8;
        Calculations instance = new Calculations();
        int expResult = 13;
        int result = instance.addition(a, b);
        assertEquals(expResult, result);
        System.out.println("If this line prints then the method is executed without errors");
    }

    /**
     * Test of division method, of class Calculations.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
        int a = 17;
        int b = 3;
        Calculations instance = new Calculations();
        double expResult = 5.666667;
        double result = instance.division(a, b);
        assertEquals(expResult, result);
        fail("If this prints out the end point has an error");
    }

    /**
     * Test of multiplication method, of class Calculations.
     */
    @Test
    public void testMultiplication() {
        System.out.println("multiplication");
        String a = "1999999999999999999999999";
        int b = 3;
        Calculations instance = new Calculations();
        int expResult = 0;
        int result = instance.multiplication(a, b);
        assertEquals(expResult, result);
        fail("This prints shows the server endpoint is sending an error");
    }

    /**
     * Test of subtraction method, of class Calculations.
     */
    @Test
    public void testSubtraction() {
        System.out.println("subtraction");
        int a = 21;
        int b = 13;
        Calculations instance = new Calculations();
        int expResult = 8;
        int result = instance.subtraction(a, b);
        assertEquals(expResult, result);
        System.out.println("If this line prints then the method is executed without errors");
    }

}

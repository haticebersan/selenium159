package myfirstproject;


import org.junit.Test;

import static org.junit.Assert.*;

public class Day02_JUnitAssertions {
    /*
    What is Assertion?
    Assertion is used for checking if the expected data is equal to actual data
    Assertion is very important for the quality of the application. It is mandatory.
    expected = actual --> PASS
    expected != actual --> FAIL

    assertEquals()
    assertTrue()
    assertFalse()

    Assertions are HARD Assertions --> if JUnit assertion fails, test case will stop the execution.
    Verification are SOFT Assertions --> if JUnit assertion fails, test case will not stop the execution.
    Note: There is no Soft Assertion in JUnit
     */

    @Test
    public void assertions() {

        assertEquals(1, 1);//assertEquals() --> if the first parameter value is equals to second parameter value, test will pass
        assertEquals("Hello", "Hello");
        assertTrue("Hello".contains("llo"));//assertTrue()--> if the value between parenthesis returns true, test will pass
        assertFalse(1 > 9);//assertFalse()--> if the value between parenthesis returns false, test will pass
    }
}

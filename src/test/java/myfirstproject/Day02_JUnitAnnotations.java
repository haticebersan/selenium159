package myfirstproject;


import org.junit.*;

public class Day02_JUnitAnnotations {
    /*
    In JUnit, there are 6 annotations:
    1. @Test: Created test cases.
        -Test methods must be public and void without any parameters
    2. @Before and @After: runs before and after each @Test annotations
    3. @BeforeClass and @AfterClass: runs before and after each class
        -@BeforeClass and @AfterClass methods should be static
    4. @Ignore: used to SKIP/IGNORE a test case

     */

    @Before//import org.junit.Before;
    public void setUp(){
        System.out.println("@Before method");
    }

    @After
    public void tearDown(){
        System.out.println("@After method");
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("@BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("@AfterClass method");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }

    @Test @Ignore
    public void test04(){
        System.out.println("Test 04");
    }

    @Test
    public void test05(){
        System.out.println("Test 05");
    }
    @Test
    public void test06(){
        System.out.println("Test 06");
    }

}
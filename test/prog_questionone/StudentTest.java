/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog_questionone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shail
 */
public class StudentTest {
    
    public StudentTest() {
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
     * Test of ageValidation method, of class Student. 
     */
    @Test
    public void TestStudentAge_StudentAgeValid() {
        System.out.println("TestStudentAge_StudentAgeValid");
        Student.ageValid=27;
        boolean expResult = true;
        boolean result = Student.StudentAge_StudentAgeValidation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        System.out.println("TestStudentAge_StudentAgeInvalid");
        Student.ageValid=13;
        boolean expResult = false;
        boolean result = Student.StudentAge_StudentAgeValidation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("TestStudentAge_StudentAgeInvalidCharacter");
        String temp ="cdg37";
        boolean expResult = false;
        boolean result = Student.StudentAge_StudentAgeInvalidCharacter(temp);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void testSaveStudent() {
        System.out.println("SaveStudent");
        int[] id = {1111,1112,1113,1114};
        String[] name = {"","","",""};
        int[] age = {18,19,20,30};
        String[] email = {"","","",""};
        String[] course = {"","","",""};
        int studAmt = 4;
        int expResult = 1114;
        int result = Student.SaveStudent(id, name, age, email, course, studAmt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    public void testSearchStudent_NotFound() {
        System.out.println("SearchStudent");
        int[] id = null;
        String[] name = null;
        int[] age = null;
        String[] email = null;
        String[] course = null;
        int studAmt = 0;
        int si = 1111;
        boolean expResult = false;
        boolean result = Student.SearchStudent(id, name, age, email, course, studAmt, si);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchStudent() {
        System.out.println("SearchStudent");
        int[] id = {1111,1112,1113,1114};
        String[] name = {"","","",""};
        int[] age = {18,19,20,21};
        String[] email = {"","","",""};
        String[] course = {"","","",""};
        int di=1111;
        int studAmt = 4;
        int si = 1111;
        boolean expResult = true;
        boolean result = Student.SearchStudent(id, name, age, email, course, studAmt, si);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteStudent method, of class Student.
     */
    @Test
    public void TestDeleteStudent() {
        System.out.println("DeleteStudent");
        int di=1112;
        String vert ="y";
        int[] id = {1111,1112,1113,1114};
        String[] name = {"a","b","c","d"};
        int[] age = {18,19,20,21};
        String[] email = {"a","b","c","d"};
        String[] course = {"a","b","c","d"};
        
        int studAmt = name.length;
        int  expResult = studAmt-1;
        int  result = Student.DeleteStudent(id, name, age, email, course, studAmt,di,vert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound()  {
        System.out.println("DeleteStudent");
        int di=1116;
        String vert ="y";
        int[] id = {1111,1112,1113,1114};
        String[] name = {"a","b","c","d"};
        int[] age = {18,19,20,21};
        String[] email = {"a","b","c","d"};
        String[] course = {"a","b","c","d"};
        
        int studAmt = name.length;
        int  expResult = studAmt;
        int  result = Student.DeleteStudent(id, name, age, email, course, studAmt,di,vert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

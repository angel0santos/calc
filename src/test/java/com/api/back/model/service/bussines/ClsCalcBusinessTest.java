package com.api.back.model.service.bussines;



import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClsCalcBusinessTest {
	 private ClsCalcBusiness calculator;
	 private ClsCalcBusiness calculatorNull;
	 private static ClsCalcBusiness calculatorStatic;


	    @BeforeAll
	    public static void beforeAllTests(){
	        calculatorStatic = new ClsCalcBusiness();
	        System.out.println("@BeforeAll -> beforeAllTests()");
	    }

	    @BeforeEach
	    public void setUp(){
	        calculator = new ClsCalcBusiness();
	        System.out.println("@BeforeEach -> setUp()");
	    }

	    @AfterEach
	    public void tearDown(){
	        calculator = null;
	        System.out.println("@AfterEach -> tearDown()");
	    }

	    @AfterAll
	    public static void afterAllTests(){
	        calculatorStatic = null;
	        System.out.println("@AfterAll -> afterAllTests()");
	    }

	    @Test
	    public void calculatorNotNullTest(){
	        assertNotNull(calculatorStatic, "Calculator debe ser not null");
	        assertNotNull(calculator, "Calculator debe ser not null");
	        System.out.println("@Test -> calculatorNotNullTest()");
	    }

	    @Test
	    public void calculatorNullTest(){
	        assertNull(calculatorNull);
	        System.out.println("@Test -> calculatorNullTest()");
	    }

	    
	    @Test
	    public void addTest(){
	        assertEquals(30, calculator.add(10,20));
	    }
	    
	    
	    @Test
	    public void assertTypesTest(){
	     
	        assertNull(calculatorNull);
	        assertNotNull(calculator);

	        ClsCalcBusiness calculator1 = new ClsCalcBusiness();
	        ClsCalcBusiness calculator2 = new ClsCalcBusiness();
	        ClsCalcBusiness calculator3 = calculator1;

	        assertSame(calculator1, calculator3);
	    

	        assertNotSame(calculator1, calculator2);
	    

	        assertEquals(1, 1.4, 0.5);
	    
	    }

	    @Test
	    public void add_ValidInput_ValidExpected_Test(){
	        assertEquals(11, calculator.add(7,4));
	    }

	    @Test
	    public void subtract_ValidInput_ValidExpected_Test(){
	        assertEquals(11, calculator.subtract(15,4));
	    }

	    @Test
	    public void subtract_ValidInput_ValidNegativeResultExpected_Test(){
	        assertEquals(-10, calculator.subtract(10,20));
	    }

	    @Test
	    public void divide_ValidInput_ValidResultExpected_Test(){
	        assertEquals(2, calculator.divide(10,5));
	    }
	    
	  

	    @Test
	    @DisplayName("Metodo Dividir -> Funciona")
	    public void divide_ValidInput_ValidResultExpected_Name_Test(){
	        assertEquals(2, calculator.divide(10,5));
	    }
	    

	  
	    @Nested
	    class AddTest{
	        @Test
	        public void add_Positive_Test(){
	            assertEquals(30, calculator.add(15,15));
	        }

	        @Test
	        public void add_Negative_Test(){
	            assertEquals(-30, calculator.add(-15,-15));
	        }

	        @Test
	        public void add_Zero_Test(){
	            assertEquals(0, calculator.add(0,0));
	        }
	    }

}

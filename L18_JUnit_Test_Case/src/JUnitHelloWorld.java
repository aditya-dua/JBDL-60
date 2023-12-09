
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JUnitHelloWorld {

	Calc c;
	
	@BeforeClass
	public static void setupBefore() {
		
		System.out.println("@BeforeClass Called");
	}
	
	@Before
	public void setup() {
		// you can pull out value of the object.
		c = new Calc();
		System.out.println("Before Called");
	}
	
	
	@Test
	public void messgae() {
		String msg = "Hello World!";
		
		assertEquals("Hello World!", msg);
		System.out.println("messgae Called");
	}
	
	@Test
	public void CalcAddTest() throws Exception {
		
		int sum = c.add(10, 20);
		//throw new Exception("some Exception");
		assertEquals(30, sum);
		System.out.println("CalcAddTest Called");
		
	}

}

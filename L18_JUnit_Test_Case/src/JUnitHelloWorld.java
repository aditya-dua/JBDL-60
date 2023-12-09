import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class JUnitHelloWorld {

	Calc c;
	
	@BeforeClass
	public void setupBefore() {
		c = new Calc();
		System.out.println("@BeforeClass function called");
	}
	
	@Before
	public void setup() {
		//c = new Calc();
		System.out.println("setup function called");
	}
	
	@Test
	void test() {
		
		assertEquals(20, c.add(10, 10));
		//fail("Not yet implemented");
	}
	
	@Test
	public void greetMessage() {
		
		assertEquals("Hello Aditya", c.greetMessage("Aditya"));
	}

}

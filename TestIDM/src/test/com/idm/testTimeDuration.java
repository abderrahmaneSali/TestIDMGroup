package test.com.idm;

import static org.junit.Assert.*;


import org.junit.Test;

import main.com.idm.BadBadValueException;
import main.com.idm.TimeDuration;

public class testTimeDuration {

	@Test
	public void testExample1 () throws BadBadValueException {
	String result =	new TimeDuration(0).toString();
	
		assertEquals( "0s", result);
		
	}
	@Test
	public void testExample2 () throws BadBadValueException {
	String result =	new TimeDuration(732).toString();
	
		assertEquals( "12mn 12s", result);
		
	}
	@Test
	public void testExample3 () throws BadBadValueException {
	String result =	new TimeDuration(7242).toString();
	
		assertEquals( "2h 0mn 42s", result);
		
	}
	 @Test (expected =BadBadValueException.class)
	public void testException () throws BadBadValueException {
	String result =	new TimeDuration(-2).toString();
	
		assertEquals( "2h 0mn 42s", result);
		
	}

}

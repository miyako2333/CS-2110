package a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElephantTest {

	@Test
	public void elephantTest() {
		Elephant e = new Elephant("Miyako",'F',2005,5);
		Elephant e2 = new Elephant("Minato",'M',2010,10);
		Elephant e3 = new Elephant("Minami",'M',2005,10);
		//Test for GroupA
		assertEquals("Miyako",e.name());
		assertEquals(true,e.isFemale());
		assertEquals("5/2005",e.date());
		assertEquals("Minato",e2.name());
		assertEquals(false,e2.isFemale());
		assertEquals("10/2010",e2.date());
		//Test for Group B
		e2.addMom(e);
		assertEquals(e,e2.mom());
		e2.addDad(e3);
		assertEquals(e3,e2.dad());
		//Test for Group C
		Elephant e4 = new Elephant("Misaki",'F',2005,5,null,null);
		assertEquals("Miyako",e.name());
		assertEquals(true,e.isFemale());
		assertEquals("5/2005",e.date());
		//Test for Group D
		assertEquals(true,e.isOlder(e2));
		assertEquals(false,e.areSibs(e3));
		//Test for asserts
		assertThrows(AssertionError.class, () -> {new Elephant("",'F',2005,5);});
		assertThrows(AssertionError.class, () -> {new Elephant("Miwako",'K',2005,5);});
		assertThrows(AssertionError.class, () -> {new Elephant("Miwako",'F',1990,5);});
		assertThrows(AssertionError.class, () -> {new Elephant("Miwako",'F',2005,0);});
	}

}

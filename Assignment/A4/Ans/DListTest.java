package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DListTest {

	@Test
    public void testPrependAndToStringR() {
        DList<String> dl= new DList<String>();
        dl.prepend("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringR());
        assertEquals(1, dl.size());
        
        dl.prepend("3110");
        assertEquals("[3110, 2110]", dl.toString());
        assertEquals("[2110, 3110]", dl.toStringR());
        assertEquals(2, dl.size());
        
        dl.prepend(" ");
        assertEquals("[ , 3110, 2110]", dl.toString());
        assertEquals("[2110, 3110,  ]", dl.toStringR());
        assertEquals(3, dl.size());
}
	
	@Test
    public void testAppend() {
        DList<String> d2= new DList<String>();
        d2.append("2110");
        assertEquals("[2110]", d2.toString());
        assertEquals("[2110]", d2.toStringR());
        assertEquals(1, d2.size());
        
        d2.append("3110");
        assertEquals("[2110, 3110]", d2.toString());
        assertEquals("[3110, 2110]", d2.toStringR());
        assertEquals(2, d2.size());
        
        d2.append("4110");
        assertEquals("[2110, 3110, 4110]", d2.toString());
        assertEquals("[4110, 3110, 2110]", d2.toStringR());
        assertEquals(3, d2.size());
}

	@Test
    public void testGetNode() {
        DList<String> d3= new DList<String>();
		d3.append("1110");d3.append("2110");d3.append("3110");d3.append("4110");d3.append("5110");

		assertEquals("2110", d3.getNode(1).value());
		assertEquals("4110", d3.getNode(3).value());
		assertEquals("5110", d3.getNode(4).value());
	}
	
	@Test
    public void testRemove() {
        DList<String> d4= new DList<String>();
        d4.append("1110");d4.append("2110");d4.append("3110");d4.append("4110");d4.append("5110");
        
        d4.remove(d4.getNode(0));
        assertEquals("[2110, 3110, 4110, 5110]", d4.toString());
        assertEquals("[5110, 4110, 3110, 2110]", d4.toStringR());
        assertEquals(4, d4.size());
        
        d4.remove(d4.getNode(3));
        assertEquals("[2110, 3110, 4110]", d4.toString());
        assertEquals("[4110, 3110, 2110]", d4.toStringR());
        assertEquals(3, d4.size());	
	
	    d4.remove(d4.getNode(1));
	    assertEquals("[2110, 4110]", d4.toString());
	    assertEquals("[4110, 2110]", d4.toStringR());
	    assertEquals(2, d4.size());	
	    }

	@Test
    public void testInsertAfter() {
        DList<String> d5= new DList<String>();
        d5.append("1110");d5.append("2110");d5.append("3110");d5.append("4110");d5.append("5110");
        
        d5.insertAfter("INS1", d5.getNode(1));
        assertEquals("[1110, 2110, INS1, 3110, 4110, 5110]", d5.toString());
        assertEquals("[5110, 4110, 3110, INS1, 2110, 1110]", d5.toStringR());
        assertEquals(6, d5.size());
        
        d5.insertAfter("INS2", d5.getNode(5));
        assertEquals("[1110, 2110, INS1, 3110, 4110, 5110, INS2]", d5.toString());
        assertEquals("[INS2, 5110, 4110, 3110, INS1, 2110, 1110]", d5.toStringR());
        assertEquals(7, d5.size());
        }
}

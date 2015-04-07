/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pera
 *
 */
public class TwitterPorukaTest {
	
	TwitterPoruka tp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnik() {
		tp.setKorisnik("Pera");
		
		assertEquals("Pera",tp.getKorisnik());
		
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("");
		tp1.setKorisnik(null);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPoruka() {
		tp.setPoruka("Danas je lep dan");
		
		assertEquals("Danas je lep dan",tp.getPoruka());
		
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setPoruka(null);
		tp1.setPoruka("The origins of the name Java are not clear.One possibility is that the island was named after the jáwa-wut plant, which was said to be common in the island during that time."); 
				
		
		
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("Zika");
		tp.setPoruka("Pozdrav!");
		
		assertEquals("KORISNIK:Zika PORUKA:Pozdrav!",tp.toString());
	}

}

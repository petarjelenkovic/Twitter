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
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPoruka() {
		tp.setPoruka("Danas je lep dan");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setPoruka(null);
		
		
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("Zika");
		tp.setPoruka("");
		
		assertEquals("KORISNIK:Zika PORUKA:",tp.toString());
	}

}

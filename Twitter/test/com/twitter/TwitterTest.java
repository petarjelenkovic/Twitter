/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author pera
 *
 */
public class TwitterTest {
	
	Twitter tw;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test 
	public void testVratiSvePoruke() {
		tw.unesi("Laza", "Kako ste?");
		assertEquals("KORISNIK:Laza PORUKA:Kako ste?",tw.vratiSvePoruke().getLast().toString());
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesi() {
		tw.unesi("Pera", "Zdravo!");
		assertEquals("Pera",tw.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Zdravo!",tw.vratiSvePoruke().getLast().getPoruka());
		tw.unesi(null,null);
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		
		tw.unesi("Pera", "Dobar dan");
		tw.unesi("Laza", "Dobar sam film gledao");
		
		TwitterPoruka[] a=tw.vratiPoruke(2, "Dobar");
		assertEquals("KORISNIK:Pera PORUKA:Dobar dan",a[0].toString());
		
	}

}

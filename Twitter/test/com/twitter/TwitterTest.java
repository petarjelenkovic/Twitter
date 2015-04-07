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
		assertEquals("Laza",tw.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Kako ste?",tw.vratiSvePoruke().getLast().getPoruka());
		
		
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
		tw.unesi("", null);
		tw.unesi(null, "The origins of the name Java are not clear.One possibility is that the island was named after the jáwa-wut plant, which was said to be common in the island during that time.");
		tw.unesi("", "The origins of the name Java are not clear.One possibility is that the island was named after the jáwa-wut plant, which was said to be common in the island during that time.");
		tw.unesi("Milos", null);
		tw.unesi("Milos", "The origins of the name Java are not clear.One possibility is that the island was named after the jáwa-wut plant, which was said to be common in the island during that time.");
		tw.unesi(null, "Zdravo!");
		tw.unesi("", "Zdarvo!");
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke() {
		
		tw.unesi("Pera", "Dobar dan");
		tw.unesi("Laza", "Dobar sam film gledao");
		
		TwitterPoruka[] a =tw.vratiPoruke(2, "Dobar");
		TwitterPoruka[] tw1 = new TwitterPoruka[2];
		TwitterPoruka pok = new TwitterPoruka();
		TwitterPoruka pok1 = new TwitterPoruka();
		tw1[0] = pok;
		tw1[0].setKorisnik("Pera");
		tw1[0].setPoruka("Dobar dan");
		tw1[1] = pok1;
		tw1[1].setKorisnik("Laza");
		tw1[1].setPoruka("Dobar sam film gledao");
		
		assertEquals(tw1[0].getKorisnik(),a[0].getKorisnik());
		assertEquals(tw1[0].getPoruka(),a[0].getPoruka());
		assertEquals(tw1[1].getKorisnik(),a[1].getKorisnik());
		assertEquals(tw1[1].getPoruka(),a[1].getPoruka());
		
		TwitterPoruka[] b = tw.vratiPoruke(-3, "Do");
		assertEquals(100,b.length);
		tw.vratiPoruke(2, null);
		tw.vratiPoruke(2, "");
	}

}

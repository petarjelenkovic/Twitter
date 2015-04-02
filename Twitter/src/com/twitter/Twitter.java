/**
 * Klasa Twitter
 * prekopirana sa http://jgrass.fon.bg.ac.rs/wp-content/uploads/2015/03/JUnit-JavaDoc-task1.pdf
 * sluzi za kreiranje liste twitter poruka, unos novih poruka i pretragu nizova korisnika
 */

package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

public class Twitter {
    /**
     * Lista objekata klase TwitterPoruka
     */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
    /**
     * Vraca listu objekata klase TwitterPoruka
     */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){

		return poruke;
    }
    /**
     * Kreira se objekat klase TwitterPoruka, odredjuju mu se atributi i ubacuje se na kraj liste
     * @param korisnik ime korisnika
     * @param poruka tekst Poruke
     */
	public void unesi(String korisnik, String poruka) {
     //Pravi se nova poruka i puni podacima.
        TwitterPoruka tp = new TwitterPoruka();
        
        tp.setKorisnik("korisnik");
        tp.setPoruka(poruka);
    //Poruka se unosi u listu na kraj
        poruke.addLast(tp);
    }
	/**
	 * Metoda koja pretrazuje elemente liste koje imaju zadati tag i ubacuje ih u niz
	 * @param maxBroj dimenzija niza
	 * @param tag tag koji se trazi
	 * @return niz objekata koji imaju zadati tag
	 */
    public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {

        if (tag==null || tag.isEmpty())
             throw new RuntimeException("Morate uneti tag");
    //Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
        if (maxBroj<=0)
              maxBroj = 100;
    //Pomocna promenljiva koja predstavlja brojac upisanih poruka
        int brojac = 0;
    //Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
    //sve poruke koje u sebi imaju zadati tag
        TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
    //Pretrazuju se poruke i traze se one koje sadrze tag.
    //Ako se nadje neka takva, i ako nije prekoracen maxBroj
   //ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
   //se prekida.
   
    for (int i = 0; i < poruke.size(); i++)
     if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
     if (brojac < maxBroj){
        rezultat[brojac+1]=poruke.get(i);
        brojac++;
     }
     else break;
     return rezultat;
     }
} 

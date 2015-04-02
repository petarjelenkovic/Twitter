/**
 * Klasa TwitterPoruka 
 * prekopiarana sa sajta jgrass
 * pruza informaciju o korisniku i poruci koju je objavio
 */
package com.twitter.poruke;

public class TwitterPoruka {
	/**
	 * Atribut koji odredjuje ime korisnika.
	 */
   private String korisnik;
   /**
    * Atribut koji odredjuje poruku korisnika.
    */
   private String poruka;
   /**
    * Metoda koja vraca vrednost atributa korisnik.
    */
   public String getKorisnik() {
     return korisnik;
   }
   /**
    * Metoda za odredjivanje imena korisnika.
    * Ime korisnika ne sme biti null ili prazan string.
    * @param korisnik ime korisnika kojeg unosimo
    */
   public void setKorisnik(String korisnik) {
     if (korisnik==null || korisnik.equals(""))
        throw new RuntimeException("Ime korisnika mora biti uneto");
     this.korisnik = korisnik;
     }
   /**
    * Metoda koja vraca vrednost atributa poruka.
    */
   public String getPoruka() {
      return poruka;
   }
   /**
    * Metoda za odredjivanje poruke korisnika. 
    * Uneta poruka ne sme biti null ili duza od 140 karaktera.
    * @param poruka tekst poruke koju unosimo
    */
   public void setPoruka(String poruka) {
       if (poruka==null || poruka.length()>140)
             throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
       this.poruka = poruka;
   }
   /**
    * Metoda koja vraca string oblika:
    * KORISNIK: ime korisnika PORUKA: poruka.
    */
   public String toString(){
         return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
   }
   
}

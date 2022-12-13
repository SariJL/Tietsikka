import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// MÄÄRITELLÄÄN TIETOKONEET 2kpl
     
     Tietokone tietsikka1 = new Tietokone("r5 3600", 16, 512, "Asus TUF GAMING B550-PLUS");
     Tietokone tietsikka2 = new Tietokone("r3 3100", 8, 256, "Asus PRIME B550M-K");
     
     //KUTSUTAAN METODEJA
     
     tietsikka1.tulostaTiedot();
     tietsikka2.tulostaTiedot();
     tietsikka1.kaynnista();
     tietsikka1.tulostaTiedot();
     tietsikka2.tallennaTiedosto("teksti.txt", 3);
     tietsikka2.tallennaTiedosto("teksti2.txt", 23);
     tietsikka2.tallennaTiedosto("teksti3.txt", 250);
     
       }
}
  //LUOKKA Tietokone

 class Tietokone {
  private String prosessori;
  private int ramMuisti;
  private int kovalevynKoko;
  private int kovalevyaKaytetty;
  private ArrayList<String>asennetutOhjelmat = new ArrayList<>();
  private String emolevynMalli;
  private boolean virtalahdePaalla;

  //KONSTRUKTORI

  public Tietokone(String prosessori, int ramMuisti, int kovalevynKoko, String emolevynMalli)
  {
    //THIS asetetaan private-juttuihin jotka aiemmin määritelty (luodaan tietokone)
    this.prosessori = prosessori;
    this.ramMuisti = ramMuisti;
    this.kovalevynKoko = kovalevynKoko;
    this.emolevynMalli = emolevynMalli;
    this.virtalahdePaalla = false;
    this.kovalevyaKaytetty = 0;
  }
  
  //METODEJA
  
  public void kaynnista() {
    this.virtalahdePaalla = true;
  }
  
  public void tulostaTiedot() {
    System.out.println("Prosessori: " + this.prosessori);
    System.out.println("Ram muisti: " + this.ramMuisti);
    System.out.println("Kovalevy: " + this.kovalevynKoko);
    System.out.println("Emolevy: " + this.emolevynMalli);
    System.out.println("Kone on: " + this.onkoKaynnissa());
  }
  public String onkoKaynnissa() {
    if(this.virtalahdePaalla) {
      return "Käynnissä";
    }
    else return "Pois päältä";
     }
     
  public void tallennaTiedosto(String tiedostonNimi, int tiedostonKoko) {
	  if(mahtuukoLevylle(tiedostonKoko)) {
    this.kovalevyaKaytetty += tiedostonKoko;
    //on sama asia kuin this.kovalevyaKaytetty = this.kovalevyaKaytetty + tiedostonKoko;
    System.out.println("Tiedosto: " + tiedostonNimi + "tallennettu. Kovalevyä vapaana: " + (this.kovalevynKoko - this.kovalevyaKaytetty));
  }
  }
  public void tulostaNaytolle(String teksti) {
    System.out.println(teksti);
  }
  public boolean mahtuukoLevylle(int asennettavanTiedostonKoko) {
	  if(asennettavanTiedostonKoko > (this.kovalevynKoko - this.kovalevyaKaytetty))
	  {
		  System.out.println("Levytila ei riitä.");
		  return false;
	  }
	  else
		  {
		  return true;
		  }
  		}
  }

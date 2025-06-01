/**
 * Razdred za prikaz modela steklenice, ki vsebuje tekočino
 * 
 * @author Žan Jarc
 * @version Primer 16 - Dedovanje
 */

public class Steklenica {

    // Deklariramo lastnosti

    /**
     * Kapaciteta steklenice v mililitrih
     */
    private int kapaciteta;

    /**
     * Stanje odprtosti steklenice
     * true - odprta
     * false - zaprta
     */
    private boolean jeOdprta;

    /**
     * Trenutna količina vsebine
     */
    private int kolicinaVsebine;

    /**
     * Vrsta vsebine
     */
    private String vrstaVsebine;

    /**
     * Konstruktor za inicializacijo nove steklenice, ki je polna in zaprta
     * Inicializira vse lastnosti
     * 
     * @param k Kapaciteta steklenice v (ml)
     * @param v Vrsta vsebine steklenice
     */
    public Steklenica(int k, String v) {

       // Inicializiramo vse lastnosti
       this.kapaciteta = k;
       this.jeOdprta = false;
       this.kolicinaVsebine = k;
       this.vrstaVsebine = v;

        // Izpišemo podatke o steklenici
        System.out.println("Ustvarjam steklenico " + v + " kapacitete " + k + " ml.");
    }


    /**
     * Metoda, ki steklenico odpre
     * 
     * @return uspešnost odpiranja
     * true - prej je bila zaprta
     * false - prej je bila zaprta
     */
    public boolean odpri() {

        // Če je steklenica že odprta
        if(jeOdprta) {

            return false;
        }

        else {

            // Odpre steklenico
            jeOdprta = true;
            System.out.println ("Odpiram steklenico " + vrstaVsebine + ".");
            return true;
        }

    }

    /**
     * Metoda, ki iz steklenice izprazni določeno količino
     * 
     * @param k Količina vsebine, ki jo želimo izprazniti (ml)
     * @return Količina vsebine, ki je ostala v steklenici po praznenju
     * @throws Exception če je steklenica zaprta, ko jo skušamo izprazniti
     */
    public int izprazni(int k) throws Exception {

        // Če je steklenica odprta
        if (jeOdprta) {

            // Od količine vsebine zmanjšamo željeno količino
            System.out.println("Iz steklenice v kateri je " + kolicinaVsebine + " ml "+ vrstaVsebine + " praznim " + k + " ml.");
            kolicinaVsebine -= k;

            // Preverimo, če se je kolučina preveč zmanjšala
            if (kolicinaVsebine < 0) {

                // Postavimo količino vsebine na 0
                kolicinaVsebine = 0;
                System.out.println("Steklenica " + vrstaVsebine + " je prazna.");

            }
        }
        // Če je steklenica zaprta
        else {

            // Vrže izjemo
            throw new Exception("Ne morem izprazniti steklenice, ker je zaprta.");

        }

        // Vrnemo količino vsebine po praznenju
        return kolicinaVsebine;
    }

}
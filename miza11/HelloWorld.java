// Uvozimo paket za delo z vhodno/izhodnimi operacijami
// import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Razdred za prikaz delovanja objektno orientiranega programiranja
 * 
 * @author Žan Jarc
 * @version Primer 19
 */

class HelloWorld {

    /**
     * Statični atribut/lastnost za branje vhoda iz konzole (tipkovnice)
     */
    private static BufferedReader in;


    /**
     * Glavna metoda programa. Zažene se vedno ob zagonu.
     * 
     * @param args Seznam argumentov iz ukazne vrstice 
    */

    /**
     * Seznam objektov tipa PivskaSteklenica + kot lastnost/atribut
     */
    private static ArrayList<PivskaSteklenica> pivskeSteklenice;


    public static void main(String[] args) {

        // izpišemo pozdrav v konzolo
        System.out.println("Pozdravljen, Svet!");

        // Inicializiramo objekt in za zajem podatkov iz tipkovnice preko konzole
        in = new BufferedReader(new InputStreamReader(System.in));

        // Inicializiramo seznam pivskih steklenic
        pivskeSteklenice = new ArrayList<>();

        // Deklariramo in inicializiramo lastnosti steklenice        
        String znamkaPiva = "";
        int velikostSteklenice = 500;
        double temperaturaSteklenice = 5.0;

        //Poskusimo prebrati iz ukazne konzole
        try { 

            // Vnos podatkov o pivski steklenici - znamka
            System.out.print("Vnesi znamko piva: ");
            znamkaPiva = in.readLine();

            // Vnos podatkov o pivski steklenici - velikost
            System.out.print("Je pivo veliko (d/n): ");
            if (in.readLine().equals("n")) {

                velikostSteklenice = 330;

            }

            // Vnos podatkov o pivski steklenici - temperatura
            System.out.print("Vnesi temperaturo pivo: ");
            temperaturaSteklenice = Double.parseDouble(in.readLine());
        }
        // Lovljenje in obravnava napake pri branju vrstice
        catch(Exception e) {
            
            System.out.println("Napaka pri branju znamke piva: " + e);

        }

        // Ustvarimo objekt tipa Steklenica
        Steklenica plastenkaVode =  new Steklenica(500, "Voda");

        // Ustvarimo objekt tipa PivskaSteklenica glede na vnešene podatke
        PivskaSteklenica mojePivo =  new PivskaSteklenica(velikostSteklenice, znamkaPiva, temperaturaSteklenice);

        // Objekt dodamo v seznam
        pivskeSteklenice.add(mojePivo);

        // V seznam dodamo še nekaj anonimnih objektov
        pivskeSteklenice.add(new PivskaSteklenica(500, "Laško", 8.0));
        pivskeSteklenice.add(new PivskaSteklenica(500, "Union", 8.0));
        pivskeSteklenice.add(new PivskaSteklenica(500, "IPA", 8.0));
        pivskeSteklenice.add(new PivskaSteklenica(500, "Drugo", 8.0));

        // Odpremo vse steklenice na seznamu
        for(int c=0; c<pivskeSteklenice.size(); c++) {

            // Odpremo trenutno pivsko steklenico
            pivskeSteklenice.get(c).odpri();

        }

        // Izpišemo število steklenic na seznamu
        System.out.println("Na seznamu je " + pivskeSteklenice.size() + " steklenic.");

        // Izpijemo požirek piva
        try {

            System.out.println("Po požirku je vsebine še " + mojePivo.izprazni(50));

        }
        catch (Exception e) {

            System.out.println("Izjema pri praznenju steklenice: " + e);

        }

        
        mojePivo.odpri();
        try {

            System.out.println("Po požirku je vsebine še " + mojePivo.izprazni(50));

            // Izpijemo požirek vode
            plastenkaVode.odpri();
            System.out.println("Po požirku vode je v plastenki še " + plastenkaVode.izprazni(30));
        }
        catch (Exception e) {

            System.out.println("Izjema pri praznenju steklenice: " + e);

        }
   } 
}
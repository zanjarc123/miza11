/**
 * Razdred za prikaz uporabe dedovanja
 * razširja razdred steklenica
 * 
 * @author Žan Jarc
 * @version Primer 19a
 */

public class PivskaSteklenica extends Steklenica implements AlkoholnaPijaca {

    // Vse lastnosti od nadrazreda se prenesejo
    // Deklariramo dodatne lastnosti, ki so skupne le pivskim steklenicam

    /**
     * Znamka piva
     */

    private String znamka;

    /**
     * Temperatura piva v steklenici v stopinjah celzija
     */

    private double temperatura;

    /**
     * Stopnja alkohola pijače v procentih (in ne deležih)
     */

    private double stopnjaAlkohola;

    /**
     * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
     * Inicializira vse lastnosti
     * 
     * @param k Kapaciteta steklenice v (ml)
     * @param z Znamka piva
     * @param t Začetna temperatura steklenice v stopinjah celzija
     * @param s Stopnja alkohola v odstotkih
     */
    public PivskaSteklenica(int k, String z, double t, double s) {


        // Pokličemo konstruktor nadrazreda - Steklenica
        // ki bo inicializiral lastnosti nadrazreda
        super(k, "Pivo");

        // Inicializiramo dodatne lastnosti
        znamka = z;
        temperatura = t;
        stopnjaAlkohola = s;
        System.out.println("Pivska steklenica je znamke " + z + " s stopnjo alkohola " + s +"%.");
    }

   /**
     * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
     * Inicializira vse lastnosti
     * 
     * @param k Kapaciteta steklenice v (ml)
     * @param z Znamka piva
     * @param t Začetna temperatura steklenice v stopinjah celzija
     */
    public PivskaSteklenica(int k, String z, double t) {

        // Pokličemo drug konstruktor nadrazreda
        this(k, z, t, 4.50);
        
    }

   /**
     * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
     * Inicializira vse lastnosti
     * 
     * @param k Kapaciteta steklenice v (ml)
     * @param z Znamka piva
     */
    public PivskaSteklenica(int k, String z) {

        // Pokličemo drug konstruktor nadrazreda
        this(k, z, 8.0);
        
    }

    /**
     * Metoda, predpisana z vmesnikom AlkoholnaPijaca
     * vrne stopnjo alkohola v odstotkih
     */
    public double getStopnjaAlkohola() {
        
        return stopnjaAlkohola;
    
    }

}

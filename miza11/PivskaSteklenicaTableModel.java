import javax.swing.table.*;

/**
 * Razred za delo s tabelo pivskih steklenic
 * razširja privzeti razred za tabele
 * 
 * @author Žan Jarc
 * @version Primer 20 - GUI
 */
public class PivskaSteklenicaTableModel extends DefaultTableModel {

    /**
     * Konstruktor, ki ustvari tabelo steklenic na mizi
     */
    public PivskaSteklenicaTableModel() {

        // Pokličemo kontruktor nadrazreda
        super();

        // Dodamo stolpce v tabelo
        addColumn("Znamka");
        addColumn("Stopnja alkohola");

        // Ustvarimo seznam objektov (nizov), ki predstavljajo vrstico tabele
        Object[] vrstica = new Object[] {"Testna znamka", "5.0"};

        // Vrstico vstavimo v tabelo
        addRow(vrstica);

    }

    /**
     * Javna metoda, ki doda pivsko steklenico v tabelo
     * @param ps objekt, ki ga dodamo tabelo
     */
    public void addPivskaSteklenica(PivskaSteklenica ps) {

        // Ustvarimo seznam objektov (nizov), ki predstavljajo vrstico tabele
        Object[] vrstica = new Object[] {ps.getZnamka(), ps.getStopnjaAlkohola()};       

        // Vrstico vstavimo v tabelo
        addRow(vrstica);

    }
}
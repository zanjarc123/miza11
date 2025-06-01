// Uvozimo paket za delo z vhodno/izhodnimi operacijami
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Razred za prikaz delovanja grafičnega uporabniškega vmesnika
 * razširja razred za delo z okni
 * 
 * @author Žan Jarc
 * @version Primer 20 - GUI
 */
public class Miza extends JFrame implements ActionListener {

     // Deklariramo zasebne lastnosti GUI
     private JPanel povrsina;

     private JButton dodajButton;
     private JTextField znamkaTextField;
     private JTextField stopnjaAlkoholaTextField;
     
     private PivskaSteklenicaTableModel modelTabele;

     /**
          * Glavna metoda programa. Zažene se vedno ob zagonu.
          * 
          * @param args Seznam argumentov iz ukazne vrstice 
     */
     public static void main(String[] args) {

          // Izpišemo začetek
          System.out.println("Zaganjam GUI...");   

          // Ustvarimo objekt razreda Miza (kličemo konstruktor razreda Miza)
          Miza m = new Miza(); 

     }

     /**
      * Konstruktor, ki postavi osnovne lastnosti okna
      */
     public Miza() {

          // Pokličemo kontruktor nadrazreda
          super("Miza s steklenicami");

          // Nastavimo obnašanje [X] tako, da ustavi aplikacijo
          setDefaultCloseOperation(EXIT_ON_CLOSE);

          // Nastavimo velikost okna
          setSize(800,600);

          // Inicializiramo elemente GUI;
          povrsina = new JPanel();

          // vnosna polja za dodajanje steklenice
          znamkaTextField = new JTextField(32);
          stopnjaAlkoholaTextField = new JTextField(4);
               
          // dodamo vnosna polja na površino
          povrsina.add(new JLabel("Znamka piva:"));
          povrsina.add(znamkaTextField);

          povrsina.add(new JLabel("Stopnja alkohola:"));
          povrsina.add(stopnjaAlkoholaTextField);

          // gumb za dodajanje
          dodajButton = new JButton("Dodaj");

          // gumbu dodamo listener za dodajanje steklenice
          dodajButton.addActionListener(this);

          // Dodamo gumb na površino
          povrsina.add(dodajButton);

          // Inicializiramo model tabele
          modelTabele = new PivskaSteklenicaTableModel();

          // Tabelo postavimo na površino
          // Ustvarimo anonimen objekt razreda JTable z modelTabele
          povrsina.add(new JTable(modelTabele));

          // Površino dodamo na okno
          add(povrsina);

          // Pikažemo okno
          setVisible(true);

     }

     /**
      * Metoda, ki jo predpisuje vmesnik ActionListener
      * se kliče vedno, ko je pritisnen gumb
      * @param e Dogodek ob kliku
      */
     public void actionPerformed(ActionEvent e) {

          // izpišemo podatke iz vnosnih polj
          System.out.println("Dodajam steklenico...");
          System.out.println("Znamka piva: " + znamkaTextField.getText());
          System.out.println("Stopnja alkohola: " + stopnjaAlkoholaTextField.getText());

          // Spemenljivka za stopnjo akolkohola
          double sa = Double.parseDouble(stopnjaAlkoholaTextField.getText());

          // ustvarimo nov objekt tipa pivska steklenica
          PivskaSteklenica nova = new PivskaSteklenica(500, znamkaTextField.getText(), 8.0, sa);

          // objekt dodamo v tabelo
          modelTabele.addPivskaSteklenica(nova);

     }

}
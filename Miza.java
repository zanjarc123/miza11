import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Miza {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField kapacitetaField;
    private JTextField vsebinaField;
    private ArrayList<Steklenica> steklenice;

    public Miza() {
        steklenice = new ArrayList<>();

        frame = new JFrame("Miza za delo s seznamom steklenic");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{"Kapaciteta (ml)", "Vsebina"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Kapaciteta (ml):"));
        kapacitetaField = new JTextField();
        inputPanel.add(kapacitetaField);

        inputPanel.add(new JLabel("Vsebina:"));
        vsebinaField = new JTextField();
        inputPanel.add(vsebinaField);

        JButton addButton = new JButton("Dodaj steklenico");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dodajSteklenico();
            }
        });
        inputPanel.add(addButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void dodajSteklenico() {
        try {
            int kapaciteta = Integer.parseInt(kapacitetaField.getText());
            String vsebina = vsebinaField.getText();

            Steklenica novaSteklenica = new Steklenica(kapaciteta, vsebina);
            steklenice.add(novaSteklenica);
            tableModel.addRow(new Object[]{kapaciteta, vsebina});

            kapacitetaField.setText("");
            vsebinaField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Prosim vnesite veljavno številko za kapaciteto.", "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Miza::new);
    }
}

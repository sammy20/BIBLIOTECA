package library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ActualizareCarte extends JFrame {

    public JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JLabel label1 = new JLabel("Introduceti ID-ul cartii pe care doriti sa o actualizati: ");
    public JLabel label2 = new JLabel("Introduceti noul titlu:");
    public JLabel label3 = new JLabel("Introduceti noul autor:");
    public JTextField txtId = new JTextField(10);
    public JTextField txtTitlu = new JTextField(10);
    public JTextField txtAutor = new JTextField(10);
    public JButton buton = new JButton("UPDATE");
    public Book carte = new Book();

    public ActualizareCarte() {
        setLayout(new GridLayout(4, 1));

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        panel1.add(label1);
        panel1.add(txtId);
        panel2.add(buton);
        panel2.add(label2);
        panel2.add(txtTitlu);
        panel3.add(label3);
        panel3.add(txtAutor);
        panel4.add(buton);

        buton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                carte.setBookid(Integer.parseInt(txtId.getText()));
                carte.setAutor(txtAutor.getText());
                carte.setTitlu(txtTitlu.getText());

                String url = "jdbc:mysql://localhost:3306/library";
                String username = "sammy20";
                String password = "labloc";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Eroare incarcare driver !");
                }
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                   String sql = "UPDATE carti SET titlu=?, autor=? WHERE id=?";

                    PreparedStatement pstate = connection.prepareStatement(sql);

                    pstate.setString(1, carte.getTitlu());
                    pstate.setString(2, carte.getAutor());
                    pstate.setInt(3, carte.getBookid());
                    pstate.executeUpdate();

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                dispose();
                ShowDatabase show = new ShowDatabase();

                show.carti();

            }
        }
        );

        
        setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();
    }

}

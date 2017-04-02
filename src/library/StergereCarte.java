package library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StergereCarte extends JFrame {

    public JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JLabel label1 = new JLabel("Introduceti ID-ul cartii pe care doriti sa o stergeti: ");
    public JTextField txtId = new JTextField(10);
    public JButton buton = new JButton("Sterge");
    public JButton buton2 = new JButton("Sterge toate cartile");
    public Book carte = new Book();

    public StergereCarte() {
        setLayout(new GridLayout(2, 2));

        add(panel1);
        add(panel2);
        panel1.add(label1);
        panel1.add(txtId);
        panel2.add(buton);
        panel2.add(buton2);

        buton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                carte.setBookid(Integer.parseInt(txtId.getText()));

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
                    String sql = "DELETE FROM carti WHERE id=?";

                    PreparedStatement pstate = connection.prepareStatement(sql);

                    pstate.setInt(1, carte.getBookid());
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
        
        buton2.addActionListener(  new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
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
                    String sql = "DELETE FROM carti ";
 
                    Statement state= connection.createStatement();
                    state.executeUpdate(sql);
                    
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose();
                ShowDatabase show = new ShowDatabase();
                show.carti();
            }
        });

        setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();
    }

}

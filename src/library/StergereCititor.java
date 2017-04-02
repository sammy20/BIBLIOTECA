package library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StergereCititor extends JFrame {

    public JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JLabel label1 = new JLabel("Introduceti ID-ul cititorului pe care doriti sa il stergeti: ");
    public JTextField txtId = new JTextField(10);
    public JButton buton = new JButton("Sterge");
    public JButton buton2 = new JButton("Sterge toti cititorii");
    public User cititor = new User();

    public StergereCititor() {
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
                cititor.setUserid(Integer.parseInt(txtId.getText()));

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
                    String sql = "DELETE FROM cititori WHERE id_cititor=?";

                    PreparedStatement pstate = connection.prepareStatement(sql);

                    pstate.setInt(1, cititor.getUserid());
                    pstate.executeUpdate();

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose();
                ShowDatabase show = new ShowDatabase();
                show.cititori();

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
                    String sql = "DELETE FROM cititori ";
 
                    Statement state= connection.createStatement();
                    state.executeUpdate(sql);
                    
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose();
                ShowDatabase show = new ShowDatabase();
                show.cititori();
            }
        });

        setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();
    }

}

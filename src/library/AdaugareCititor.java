package library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdaugareCititor extends JFrame {

    public User cititor = new User();
    public JLabel label1 = new JLabel("Id : ");
    public JLabel label2 = new JLabel("Nume : ");
    public JLabel label3 = new JLabel("CNP : ");

    public JTextField txtId = new JTextField(10);
    public JTextField txtNume = new JTextField(10);
    public JTextField txtCNP = new JTextField(10);
    public JButton btn = new JButton("Adauga");

    public JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel panel4 = new JPanel();

    public AdaugareCititor() {
        setLayout(new GridLayout(4, 1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        panel1.add(label1);
        panel1.add(txtId);
        panel2.add(label2);
        panel2.add(txtNume);
        panel3.add(label3);
        panel3.add(txtCNP);
        panel4.add(btn);

        btn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cititor.setUserid(Integer.parseInt(txtId.getText()));
                cititor.setName(txtNume.getText());
                cititor.setCNP(txtCNP.getText());

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
                    String sql = "INSERT INTO cititori VALUES (?,?,?)";

                    PreparedStatement pstate = connection.prepareStatement(sql);

                    pstate.setInt(1, cititor.getUserid());
                    pstate.setString(3, cititor.getName());
                    pstate.setString(2, cititor.getCNP());
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

        setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();

    }

}

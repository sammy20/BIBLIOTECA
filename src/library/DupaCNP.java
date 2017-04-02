package library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import library.Book;
import library.Library;
import static library.ShowDatabase.listaAux;

public class DupaCNP extends JFrame {

    public static ArrayList<User> lista = new ArrayList<>();
    public JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JTextField text = new JTextField(10);
    public User cititor=new User();
    public JLabel label1 = new JLabel("Dati CNP-ul cititorului: ");
    public JButton buton = new JButton("Cauta");

    public DupaCNP() {
        setLayout(new GridLayout(2, 1));
        add(panel);
        panel.add(label1);
        panel.add(text);
        add(buton, BorderLayout.SOUTH);

        buton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                cititor.setCNP(text.getText());
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
                    String sql = "SELECT * FROM cititori WHERE CNP = ?";

                    PreparedStatement pstate = connection.prepareStatement(sql);
                    pstate.setString(1, cititor.getCNP());

                    ResultSet rs = pstate.executeQuery();

                    while (rs.next()) {
                       User cit= new User();
                        cit.setUserid(rs.getInt(1));
                        cit.setName(rs.getString(3));
                        cit.setCNP(rs.getString(2));
                        //System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
                        lista.add(cit);

                    }

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose();
                Library.model1.clear();
                for (User c : lista) {
                    Library.model1.addElement(c);
                }
                lista.clear();
              }
                } 
                );
          setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();
            
            }
        }
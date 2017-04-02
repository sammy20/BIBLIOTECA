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

public class DupaAutor extends JFrame {

    public static ArrayList<Book> listaAux = new ArrayList<>();
    public JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JTextField text = new JTextField(10);
    public Book carte = new Book();
    public JLabel label1 = new JLabel("Dati autorul cartii: ");
    public JButton buton = new JButton("Cauta");

    public DupaAutor() {
        setLayout(new GridLayout(2, 1));
        add(panel);
        panel.add(label1);
        panel.add(text);
        add(buton, BorderLayout.SOUTH);

        buton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                carte.setAutor(text.getText());
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
                    String sql = "SELECT * FROM carti WHERE autor = ?";

                    PreparedStatement pstate = connection.prepareStatement(sql);
                    pstate.setString(1, carte.getAutor());

                    ResultSet rs = pstate.executeQuery();

                    while (rs.next()) {
                        Book bk = new Book();
                        bk.setBookid(rs.getInt(1));
                        bk.setAutor(rs.getString(3));
                        bk.setTitlu(rs.getString(2));
                        //System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
                        listaAux.add(bk);

                    }

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose();
                Library.model.clear();
                for (Book b : listaAux) {
                    Library.model.addElement(b);
                }
                listaAux.clear();
              }
                } 
                );
          setLocationRelativeTo(null);
        setSize(300, 300);
        setVisible(true);

        pack();
            
            }
        }
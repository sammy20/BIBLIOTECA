package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import library.Book;
import library.Library;

public class ShowDatabase {

    public static ArrayList<Book> listaAux = new ArrayList<>();
    public static ArrayList<User> lista = new ArrayList<>();

    public void carti() {
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

            String sql = "SELECT * FROM carti";
            Statement state = connection.createStatement();
            state.execute(sql);

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                Book bk = new Book();
                bk.setBookid(rs.getInt(1));
                bk.setAutor(rs.getString(3));
                bk.setTitlu(rs.getString(2));

                listaAux.add(bk);

                //System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Library.model.clear();
        for (Book b : listaAux) {
            Library.model.addElement(b);
        }
        listaAux.clear();

    }

    public void cititori() {
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

            String sql = "SELECT * FROM cititori";
            Statement state = connection.createStatement();
            state.execute(sql);

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                User cit = new User();
                cit.setUserid(rs.getInt(1));
                cit.setName(rs.getString(3));
                cit.setCNP(rs.getString(2));
               
                lista.add(cit);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Library.model1.clear();
        for (User c : lista) {
            Library.model1.addElement(c);
        }
        lista.clear();

    }

}

package library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Library extends JFrame {

    public JTextField txtId = new JTextField();
    public JTextField txtTitlu = new JTextField();
    public JTextField txtAutor = new JTextField();
    public JButton btn = new JButton("Flush");
    //Listener l= new Listener();
    //public static Book carte = new Book();

    public JMenuBar mb = new JMenuBar();
    public JMenu menu1 = new JMenu("Optiuni carti");
    public JMenu menu2 = new JMenu("Optiuni cititori");
    public JMenuItem m11 = new JMenuItem("Adauga carte");
    public JMenuItem m12 = new JMenuItem("Sterge carte");
    public JMenuItem m13 = new JMenuItem("Actualizeaza carte");
    public JMenuItem m14 = new JMenuItem("Cauta carte dupa titlu");
    public JMenuItem m15 = new JMenuItem("Cauta carte dupa autor");
    public JMenuItem m16 = new JMenuItem("Arata toate cartile");
    public JMenuItem m21 = new JMenuItem("Adauga cititor");
    public JMenuItem m22 = new JMenuItem("Sterge cititor");
    public JMenuItem m23 = new JMenuItem("Actualizeaza cititor");
    public JMenuItem m24 = new JMenuItem("Cauta cititor dupa nume");
    public JMenuItem m25 = new JMenuItem("Cauta cititor dupa CNP");
    public JMenuItem m26 = new JMenuItem("Arata toti cititorii");

    public static DefaultListModel<Book> model = new DefaultListModel<>();
    public static DefaultListModel<User> model1 = new DefaultListModel<>();
    
    public static JList<Book> lista = new JList<Book>(model);
    public static JList<User> lista1 = new JList<>(model1);
    
    public static JScrollPane scroll = new JScrollPane(lista);
    public static JScrollPane scroll1 = new JScrollPane(lista1);
    
    public JPanel panel1 = new JPanel();
    public JPanel panel2 = new JPanel();
   // public JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    

    public Library() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(mb);
        setLayout(new GridLayout(3,1));
        add(panel1);
        add(panel2);
       
      
        scroll.setPreferredSize(new Dimension(350,350));
        scroll1.setPreferredSize(new Dimension(350,300));
      
        panel1.add(scroll);
        panel2.add(scroll1);

        mb.add(menu1);
        mb.add(menu2);

        menu1.add(m11);
        menu1.add(m12);
        menu1.add(m13);
        menu1.add(m14);
        menu1.add(m15);
        menu1.add(m16);
        menu2.add(m21);
        menu2.add(m22);
        menu2.add(m23);
        menu2.add(m24);
        menu2.add(m25);
        menu2.add(m26);
        
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.clear();
                model1.clear();
            }
        }
        );

        m11.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AdaugareCarte();
            }
        }
        );

        m12.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new StergereCarte();
            }
        }
        );

        m13.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new ActualizareCarte();
            }
        }
        );

        m14.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DupaTitlu();
            }
        }
        );
        m15.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DupaAutor();
            }
        }
        );
        m16.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ShowDatabase show = new ShowDatabase();
                show.carti();
            }
        }
        );

        m21.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AdaugareCititor();
            }
        }
        );
        
           m22.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new StergereCititor();
            }
        }
        );
        
              m23.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new ActualizareCititor();
            }
        }
        );
        
                 m24.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DupaNume();
            }
        }
        );
        
                    m25.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DupaCNP();
            }
        }
        );
        
                   
        
        m26.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 ShowDatabase show = new ShowDatabase();
                show.cititori();
            }
        }
        );
        setLocationRelativeTo(null);
        setSize(400, 700);
        setVisible(true);
        //pack();

    }

    public static void main(String[] args) {
        new Library();

    }

}

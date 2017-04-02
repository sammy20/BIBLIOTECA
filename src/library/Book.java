
package library;

import java.io.IOException;
import java.util.Date;
public class Book {
    private int bookid;
    private String autor; 
    private String titlu; 
    private long returnare; 
    private int domeniu; 
    
    
     public void setDataImprumut() {
        long T=90; 
        long t1=new Date().getTime();
         returnare=t1+T*24*60*60*1000;
         System.out.println("Aceasta carte trebuie returnata la data de:" + new Date(returnare));
       
    }
     public boolean returnare(){
         long t1=new Date().getTime(); 
         return new Date(t1).before(new Date(returnare)); 
     }
    
     public Book() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
     
    
     public Book(String autor, String titlu) {
           this.autor=autor; 
           this.titlu=titlu;
     }
    
    public void setAutor(String autor){ 
         this.autor=autor;
    }
    public String getAutor(){ 
         return autor;
    }
    
    public void setTitlu(String titlu){
        this.titlu=titlu;
    }
    
    public String getTitlu(){
         return titlu;
    }
    
    public void setDomeniu(String nume){
        try{
            domeniu=Domeniu.valueOf(nume).getCod();
        }
        catch (Exception e) { 
            System.out.println("Domeniul introdus nu exista");
        }
    }
    
    public int getDomeniu(){
        return domeniu;
    }

    @Override
    public String toString() {
        return "ID=" + bookid + ", Autor:" + autor + ", Titlu:" + titlu;
    }
    
}

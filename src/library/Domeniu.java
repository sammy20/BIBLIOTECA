
package library;


public enum Domeniu {
    LITERATURA(10), MATEMATICA(20), STIINTE(30), ISTORIE(40); 
       
    private final int cod;
       
    private Domeniu(int cod) {
        this.cod = cod;
    }
    
     public int getCod() {
        return cod;
    }
    
}

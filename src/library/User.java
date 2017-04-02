package library;


public class User {
    private int userid; 
    private String name; 
    private String CNP;
    
    public User(String name, String CNP){
        this.name=name; 
        this.CNP=CNP;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "ID=" + userid + ", name=" + name + ", CNP=" + CNP;
    }

      
    
}

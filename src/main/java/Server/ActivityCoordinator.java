package Server;

//import javax.net.ssl.StandardConstants;

import java.util.ArrayList;

public class ActivityCoordinator extends User implements java.io.Serializable{

    private String name;
    private String email;
    private String CNP;

    public ActivityCoordinator(String username, String password, String type, String name, String email, String CNP){
        super(username, password, type);
        this.name = name;
        this.email = email;
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }



}

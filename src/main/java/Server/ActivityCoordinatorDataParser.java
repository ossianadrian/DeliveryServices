package Server;

public class ActivityCoordinatorDataParser implements java.io.Serializable{

    public int id;
    public String username;
    public String password;
    public String fullname;
    public String email;
    public String cnp;

    public ActivityCoordinatorDataParser(int id, String username, String password, String fullname, String email, String cnp){
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.cnp = cnp;

    }

}

package Server;

public class Administrator extends User implements java.io.Serializable{

    private String name;
    private String email;
    private String CNP;

    public Administrator(String username, String password, String type, String name, String email, String CNP){
        super(username, password, type);
        this.name = name;
        this.email = email;
        this.CNP = CNP;
    }

    public Mailer createMailer(String username, String password, String type, String name, String email, String CNP){
        return new Mailer(username, password, type, name, email, CNP);
    }

    public Mailer searchMailer(String name){

        return null;

    }

    public Mailer editMailer(String oldName, Mailer newMailer){
        Mailer oldMailer = searchMailer(oldName);
        oldMailer.setCNP(newMailer.getCNP());
        oldMailer.setName(newMailer.getName());
        oldMailer.setEmail(newMailer.getEmail());
        oldMailer.setUsername(newMailer.getUsername());
        oldMailer.setPassword(newMailer.getPassword());
        return oldMailer;
    }

    public void deleteMailer(String name){
        searchMailer(name);
        //do stuff
    }




}

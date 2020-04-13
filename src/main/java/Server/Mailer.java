package Server;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mailer extends User implements MailerPlanI, java.io.Serializable {

    private String name;
    private String email;
    private String CNP;
    public ArrayList<ParcelStandard> parcelsToDeliver;

    public Mailer(String username, String password, String type, String name, String email, String CNP){
        super(username, password, type);
        this.name = name;
        this.email = email;
        this.CNP = CNP;
        parcelsToDeliver = new ArrayList<ParcelStandard>();

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

    public ArrayList<ParcelStandard> viewAllParcels() {
        return parcelsToDeliver;
    }

    public ArrayList<Node> viewAllLocations() {

        ArrayList<Node> locations = new ArrayList<>();
        for(ParcelStandard parcel : parcelsToDeliver){
            locations.add(parcel.getAdress());
        }

        return locations;
    }

    public ParcelStandard searchByParcelNumber(int number) {

        return null;
    }

}

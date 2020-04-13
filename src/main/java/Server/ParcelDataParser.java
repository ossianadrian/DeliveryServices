package Server;

public class ParcelDataParser implements  java.io.Serializable {

    public int id;
    public String adress;
    public String receiver;
    public float weight;
    public int mailerId;

    public ParcelDataParser(int id, String adress, String receiver, float weight, int mailerId){

        this.id = id;
        this.adress = adress;
        this.receiver = receiver;
        this.weight = weight;
        this.mailerId = mailerId;

    }

}

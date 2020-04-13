package Server;


public class ParcelStandard implements Comparable , java.io.Serializable{

    private int parcelNumber;
    private Node adress;
    private String receiverName;
    private float weight;

    public ParcelStandard(int parcelNumber, Node adress, String receiverName, float weight){
        this.parcelNumber = parcelNumber;
        this.adress = adress;
        this.receiverName = receiverName;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(int parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public Node getAdress() {
        return adress;
    }

    public void setAdress(Node adress) {
        this.adress = adress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int compareTo(Object o) {
        ParcelStandard sp2 = (ParcelStandard)o;
        int distance2 = sp2.getAdress().getDistanceFromSpecificNode("A");
        /* For Ascending order*/
        return this.getAdress().getDistanceFromSpecificNode("A")-distance2;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
}

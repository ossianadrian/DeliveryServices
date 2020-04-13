package Server;

public class ParcelFragile extends ParcelStandard {

    private int fragilityGrade;


    ParcelFragile(int parcelNumber, Node adress, String receiverName, float weight, int fragilityGrade){
        super(parcelNumber,adress,receiverName,weight);
        this.fragilityGrade = fragilityGrade;

    }

    public int getFragilityGrade() {
        return fragilityGrade;
    }

    public void setFragilityGrade(int fragilityGrade) {
        this.fragilityGrade = fragilityGrade;
    }
}

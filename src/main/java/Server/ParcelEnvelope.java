package Server;

public class ParcelEnvelope extends ParcelStandard{

    private float thickness;

    ParcelEnvelope(int parcelNumber, Node adress, String receiverName, float weight, float thickness){
        super(parcelNumber, adress, receiverName, weight);
        this.thickness = thickness;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}

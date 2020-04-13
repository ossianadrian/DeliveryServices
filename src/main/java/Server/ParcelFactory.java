package Server;

public class ParcelFactory {

    public ParcelStandard makeParcel(String parcelType, int parcelNumber, Node adress, String receiverName, float weight){

        if(parcelType.equals("Standard")){
            return new ParcelStandard( parcelNumber, adress, receiverName, weight);
        }
        else{
            return null;
        }
    }

    public ParcelStandard makeParcel(String parcelType, int parcelNumber, Node adress, String receiverName, float weight, int fragilityGrade){

        if(parcelType.equals("Fragile")){
            return new ParcelFragile( parcelNumber, adress, receiverName, weight, fragilityGrade);
        }
        else{
            return null;
        }
    }

    public ParcelStandard makeParcel(String parcelType, int parcelNumber, Node adress, String receiverName, float weight, float thickness){

        if(parcelType.equals("Envelope")){
            return new ParcelEnvelope( parcelNumber, adress, receiverName, weight, thickness);
        }
        else{
            return null;
        }
    }



}

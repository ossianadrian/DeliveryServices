package Server;

import java.util.ArrayList;

public class Order {

    public ArrayList<ParcelStandard> parcels;

    public void addParcel(ParcelStandard parcel){
        if(parcels == null){
            parcels = new ArrayList<ParcelStandard>();
            parcels.add(parcel);
        }
        else{
            parcels.add(parcel);
        }
    }


}

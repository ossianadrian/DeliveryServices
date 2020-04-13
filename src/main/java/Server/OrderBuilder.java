package Server;

import java.util.ArrayList;

public class OrderBuilder {

    public Order buildOrder(ArrayList<ParcelStandard> parcels){

        Order order = new Order();

        for(ParcelStandard parcel : parcels){
            order.addParcel(parcel);
        }

        return order;
    }

}

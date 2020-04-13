package Server;

import java.util.ArrayList;

public interface MailerPlanI {

    public ArrayList<ParcelStandard> viewAllParcels();

    public ArrayList<Node> viewAllLocations();

    public ParcelStandard searchByParcelNumber(int number);


}

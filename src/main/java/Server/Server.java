// A Java program for a Server
package Server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
    //initialize socket and input stream
    private ServerSocket		 serverSocket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;
    private NodeNetwork nodeNetwork = null;

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            nodeNetwork = this.createNetwork();

            // reads message from client until "Over" is sent
            while (true)
            {
                // Create the Client Socket

                serverSocket = new ServerSocket(port);
                System.out.println("Server started");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted");
                // Create input and output streams to client
                ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

                try {
                    String request = "";
                    request = (String)inFromClient.readObject();

                    if(request.equals("log in Mailer")){
                        String username = (String)inFromClient.readObject();
                        String password = (String)inFromClient.readObject();
                        Mailer mailer = MailerDAO.findByUsername(username, password);
                        outToClient.writeObject(mailer);
                        if(mailer != null){
                            System.out.println("Logged in Mailer "+ mailer.getName());
                        }
                    }

                    if(request.equals("log in ActivityCoordinator")){
                        System.out.println("Trying to log in Activity Coordinator...");
                        String username = (String)inFromClient.readObject();
                        String password = (String)inFromClient.readObject();
                        ActivityCoordinator ac = ActivityCoordinatorDAO.findByName(username, password);
                        outToClient.writeObject(ac);
                        if(ac != null){
                            System.out.println("Logged in ActivityCoordinator "+ ac.getName());
                        }
                    }

                    if(request.equals("log in Administrator")){
                        String username = (String)inFromClient.readObject();
                        String password = (String)inFromClient.readObject();
                        Administrator admin = AdministratorDAO.findByName(username,password);
                        outToClient.writeObject(admin);
                        if(admin != null){
                            System.out.println("Logged in Admin "+ admin.getUsername());
                        }
                    }
                    if(request.equals("view Parcels for mailer")){
                        String mailerName = (String)inFromClient.readObject();
                        ArrayList<Object> parcelList = MailerDAO.viewParcelsForMailer(mailerName,nodeNetwork);
                        outToClient.writeObject(parcelList);
                        if(parcelList != null){
                            System.out.println("Parcels for mailer delivered "+ mailerName);
                        }
                        else{
                            System.out.println("Couldn't deliver parcels for mailer" + mailerName);
                        }
                    }
                    if(request.equals("view all parcels")){
                        ArrayList<Object> parcelList = ParcelDAO.viewAllForTablePrint(nodeNetwork);
                        outToClient.writeObject(parcelList);
                        if(parcelList != null){
                            System.out.println("All parcels delivered");
                        }
                        else{
                            System.out.println("Couldn't deliver parcels");
                        }
                    }
                    if(request.equals("find parcel by number")){
                        int parcelNo = (int)inFromClient.readObject();
                        ParcelStandard parcel = ParcelDAO.findByName(parcelNo , nodeNetwork);
                        outToClient.writeObject(parcel);
                        if(parcel != null){
                            System.out.println("Searched for parcel by number");
                        }
                        else{
                            System.out.println("Couldn't search for parcel by number");
                        }
                    }
                    if(request.equals("insert parcel")){
                        ParcelStandard parcel = (ParcelStandard)inFromClient.readObject();
                        ParcelDAO.insert(parcel);
                        if(parcel != null){
                            System.out.println("Parcel inserted");
                        }
                        else{
                            System.out.println("Parcel data is missing. Could not insert.");
                        }
                    }
                    if(request.equals("edit parcel")){
                        int parcelNo = (int)inFromClient.readObject();
                        ParcelStandard parcel = (ParcelStandard)inFromClient.readObject();
                        ParcelDAO.edit(parcelNo, parcel);
                        if(parcel != null && parcelNo > 0){
                            System.out.println("Parcel edited");
                        }
                        else{
                            System.out.println("Parcel data is missing. Could not edit.");
                        }
                    }
                    if(request.equals("delete parcel")){
                        int parcelNo = (int)inFromClient.readObject();
                        ParcelDAO.delete(parcelNo);
                        if(parcelNo > 0){
                            System.out.println("Parcel delete");
                        }
                        else{
                            System.out.println("Parcel data is missing. Could not delete.");
                        }
                    }
                    if(request.equals("assign parcel to mailer")){
                        String mailerName = (String)inFromClient.readObject();
                        int parcelNo = (int)inFromClient.readObject();
                        ParcelDAO.assignToMailer(mailerName,parcelNo);
                        if(parcelNo > 0){
                            System.out.println("Parcel assigned");
                        }
                        else{
                            System.out.println("Parcel data is missing. Could not assign.");
                        }
                    }
                    if(request.equals("view all parcels for mailers")){
                        String mailerName = (String)inFromClient.readObject();
                        ArrayList<ParcelStandard> parcelList = MailerDAO.viewParcelsForMailerAsParcels(mailerName,nodeNetwork);
                        outToClient.writeObject(parcelList);
                        System.out.println("All parcels for mailer delivered for computational work");
                    }
                    if(request.equals("view all mailers")){
                        ArrayList<Object> mailersList = MailerDAO.viewAllForTablePrint();
                        outToClient.writeObject(mailersList);
                        System.out.println("All mailers delivered");
                    }
                    if(request.equals("view all activity coordinators")){
                        ArrayList<Object> acList = ActivityCoordinatorDAO.viewAllForTablePrint();
                        outToClient.writeObject(acList);
                        System.out.println("All activity coordinators delivered");
                    }
                    if(request.equals("insert Mailer")){
                        Mailer mailer = (Mailer)inFromClient.readObject();
                        MailerDAO.insertMailer(mailer);
                        System.out.println("Mailer inserted");
                    }
                    if(request.equals("insert activity coordinator")){
                        ActivityCoordinator ac = (ActivityCoordinator)inFromClient.readObject();
                        ActivityCoordinatorDAO.insertActivityCoordinator(ac);
                        System.out.println("Activity Coordinator inserted");
                    }
                    if(request.equals("delete mailer")){
                        String name = (String)inFromClient.readObject();
                        MailerDAO.delete(name);
                        System.out.println("Mailer deleted");
                    }
                    if(request.equals("delete activity coordinator")){
                        String name = (String)inFromClient.readObject();
                        ActivityCoordinatorDAO.delete(name);
                        System.out.println("Activity Coordinator deleted");
                    }
                    if(request.equals("edit mailer")){
                        Mailer mailer = (Mailer)inFromClient.readObject();
                        MailerDAO.edit(mailer);
                        System.out.println("Mailer edited");
                    }
                    if(request.equals("edit activity coordinator")){
                        ActivityCoordinator ac = (ActivityCoordinator) inFromClient.readObject();
                        ActivityCoordinatorDAO.edit(ac);
                        System.out.println("Activity coordinator edited");
                    }

                } catch (Exception e) {
                    System.out.println(e);;
                }


                serverSocket.close();
                System.out.println("Closing connection");

            }

        }
        catch(Exception i)
        {
            System.out.println(i);
        }
    }

    public NodeNetwork createNetwork(){

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        Node L = new Node("L");

        //A
        Edge AB = new Edge(A,B, 3);
        Edge BA = new Edge(B,A, 3);

        Edge AC = new Edge(A,C, 3);
        Edge CA = new Edge(C,A, 3);

        //B
        Edge BD = new Edge(B,D, 2);
        Edge DB = new Edge(D,B, 2);

        Edge BE = new Edge(B,E, 2);
        Edge EB = new Edge(E,B, 2);

        //C
        Edge CE = new Edge(C,E, 5);
        Edge EC = new Edge(E,C, 5);

        Edge CF = new Edge(C,F, 2);
        Edge FC = new Edge(F,C, 2);

        //D
        Edge DG = new Edge(D,G, 5);
        Edge GD = new Edge(G,D, 5);

        //E
        Edge EG = new Edge(E,G,3);
        Edge GE = new Edge(G,E,3);

        Edge EF = new Edge(E,F,4);
        Edge FE = new Edge(F,E,4);

        //F
        Edge FG = new Edge(F,G,7);
        Edge GF = new Edge(G,F,7);

        Edge FH = new Edge(F,H,7);
        Edge HF = new Edge(H,F,7);

        //G
        Edge GL = new Edge(G,L,5);
        Edge LG = new Edge(L,G,5);

        Edge GH = new Edge(G,H,7);
        Edge HG = new Edge(H,G,7);

        //H
        Edge HI = new Edge(H,I,3);
        Edge IH = new Edge(I,H,3);

        Edge HK = new Edge(H,K,4);
        Edge KH = new Edge(K,H,4);

        //I
        Edge IJ = new Edge(I,J,2);
        Edge JI = new Edge(J,I,2);

        Edge IK = new Edge(I,K,2);
        Edge KI = new Edge(K,I,2);


        ArrayList<Edge> Aedges = new ArrayList<Edge>();
        Aedges.add(AB);
        Aedges.add(AC);

        ArrayList<Edge> Bedges = new ArrayList<Edge>();
        Bedges.add(BA);
        Bedges.add(BD);
        Bedges.add(BE);

        ArrayList<Edge> Cedges = new ArrayList<Edge>();
        Cedges.add(CA);
        Cedges.add(CE);
        Cedges.add(CF);

        ArrayList<Edge> Dedges = new ArrayList<Edge>();
        Dedges.add(DB);
        Dedges.add(DG);

        ArrayList<Edge> Eedges = new ArrayList<Edge>();
        Eedges.add(EB);
        Eedges.add(EC);
        Eedges.add(EF);
        Eedges.add(EG);

        ArrayList<Edge> Fedges = new ArrayList<Edge>();
        Fedges.add(FE);
        Fedges.add(FC);
        Fedges.add(FG);
        Fedges.add(FH);

        ArrayList<Edge> Gedges = new ArrayList<Edge>();
        Gedges.add(GD);
        Gedges.add(GE);
        Gedges.add(GF);
        Gedges.add(GH);
        Gedges.add(GL);

        ArrayList<Edge> Hedges = new ArrayList<Edge>();
        Hedges.add(HG);
        Hedges.add(HF);
        Hedges.add(HI);
        Hedges.add(HK);

        ArrayList<Edge> Iedges = new ArrayList<Edge>();
        Iedges.add(IJ);
        Iedges.add(IK);
        Iedges.add(IH);

        ArrayList<Edge> Jedges = new ArrayList<Edge>();
        Jedges.add(JI);

        ArrayList<Edge> Kedges = new ArrayList<Edge>();
        Kedges.add(KI);
        Kedges.add(KH);

        ArrayList<Edge> Ledges = new ArrayList<Edge>();
        Ledges.add(LG);

        A.updateEdges(Aedges);
        B.updateEdges(Bedges);
        C.updateEdges(Cedges);
        D.updateEdges(Dedges);
        E.updateEdges(Eedges);
        F.updateEdges(Fedges);
        G.updateEdges(Gedges);
        H.updateEdges(Hedges);
        I.updateEdges(Iedges);
        J.updateEdges(Jedges);
        K.updateEdges(Kedges);
        L.updateEdges(Ledges);

        A.setNodeDistances(0,6,6,10,10,10,16,24,30,35,32,26);
        B.setNodeDistances(6,0,12,4,4,12,10,24,32,36,32,20);
        C.setNodeDistances(6,12,0,16,10,4,16,18,24,28,26,26);
        D.setNodeDistances(10,4,16,0,8,16,10,24,30,34,32,20);
        E.setNodeDistances(10,4,10,8,0,8,6,20,26,30,28,16);
        F.setNodeDistances(10,12,4,16,8,0,14,14,20,24,22,24);
        G.setNodeDistances(16,10,16,10,6,14,0,14,20,24,22,10);
        H.setNodeDistances(24,24,18,24,20,14,14,0,6,10,8,24);
        I.setNodeDistances(30,32,24,30,26,20, 20,6,0,4,4,30);
        J.setNodeDistances(35,36,28,24,30,24,24,10,4,0,8,34);
        K.setNodeDistances(32,32,26,32,28,22,22,8,4,8,0,32);
        L.setNodeDistances(26,20,26,20,16,24,10,24,30,34,32,0);

        ArrayList<Node> allNodes = new ArrayList<Node>();
        allNodes.add(A);
        allNodes.add(B);
        allNodes.add(C);
        allNodes.add(D);
        allNodes.add(E);
        allNodes.add(F);
        allNodes.add(G);
        allNodes.add(H);
        allNodes.add(I);
        allNodes.add(J);
        allNodes.add(K);
        allNodes.add(L);

        nodeNetwork = new NodeNetwork(allNodes);

        return nodeNetwork;

    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}

package Client;

import Server.*;
import Utils.CSVUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

import Utils.JSONArray;
import Utils.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {

    public ArrayList<ParcelStandard> allParcels;

    public NodeNetwork nodeNetwork;

    public void sortAscending(Mailer mailer){

        Collections.sort(mailer.parcelsToDeliver);

    }

    public ArrayList<Node> aStar(String startNodeLetter, String endNodeLetter){

        Node startNode = nodeNetwork.getNode(startNodeLetter);
        Node endNode = nodeNetwork.getNode(endNodeLetter);

        ArrayList<Node> path = new ArrayList<Node>();
        path.add(endNode);

        //We start from finish to beginning
        Node nextNode = endNode;

        int cost = 0;
        int heuristic = 0;
        int distance = 0;

        int bestHeuristic = 100000000;

        while(nextNode != startNode){

            Node selectedNode = nextNode.neighbors.get(0).getTo();
            bestHeuristic = cost + nextNode.neighbors.get(0).getTo().getDistanceFromSpecificNode(startNodeLetter)+ nextNode.neighbors.get(0).getDistance();
            distance = nextNode.neighbors.get(0).getDistance();

            for(Edge e : nextNode.neighbors){
                heuristic = cost + e.getTo().getDistanceFromSpecificNode(startNodeLetter) + e.getDistance();

                if(heuristic < bestHeuristic){
                    bestHeuristic = heuristic;
                    selectedNode = e.getTo();
                    distance = e.getDistance();
                }
            }

            path.add(0,selectedNode);
            cost += distance;
            nextNode = selectedNode;




        }

        return path;


    }

    public ArrayList<Node> searchBestTrip(Mailer mailer){

        sortAscending(mailer);

        Node startNode = nodeNetwork.getNode("A");
        ArrayList<Node> trip = new ArrayList<Node>();

        for(ParcelStandard parcel : mailer.parcelsToDeliver){

            Node destinationNode = parcel.getAdress();
            trip.addAll(aStar(startNode.getAdress(),destinationNode.getAdress()));
            startNode = trip.get(trip.size() - 1);

        }

        /*
        //remove duplicates
        for(int i = 0; i < trip.size() - 1 ; i++){
            if(trip.get(i) == trip.get(i+1)){
                trip.remove(i);
            }
        }
        */

        return trip;

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

    public void saveReports(String type, NodeNetwork nodeNetwork){

        if(type.equals("CSV")){
            saveCSV(nodeNetwork);
        }
        else if(type.equals("XML")){
            saveXML(nodeNetwork);
        }
        else if(type.equals("JSON")){
            saveJSON(nodeNetwork);
        }
        else{
            System.out.println("Error! Format for saving report is not correct.");
        }



    }

    public void saveCSV(NodeNetwork nodeNetwork){

        try{

            ArrayList<ParcelStandard> parcels = ParcelDAO.viewAllAsParcelStandard(nodeNetwork);

            String csvFile = "report.csv";
            FileWriter writer = new FileWriter(csvFile);

            CSVUtils.writeLine(writer, Arrays.asList("ID", "Adress", "Reciver", "weight"));

            for(ParcelStandard parcel : parcels){
                CSVUtils.writeLine(writer, Arrays.asList( String.valueOf(parcel.getParcelNumber()), parcel.getAdress().getAdress(), parcel.getReceiverName(), String.valueOf(parcel.getWeight())));
            }

            writer.flush();
            writer.close();

        } catch(Exception e){
            System.out.println("Oops. Could not export to CSV file.");
        }

    }

    public void saveXML(NodeNetwork nodeNetwork){

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Parcel");
            document.appendChild(root);

            ArrayList<ParcelStandard> parcels = ParcelDAO.viewAllAsParcelStandard(nodeNetwork);

            Element myParcel = document.createElement("parcel");

            root.appendChild(myParcel);

            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            myParcel.setAttributeNode(attr);


            for(ParcelStandard parcel : parcels){

                Element firstName = document.createElement("ID");
                firstName.appendChild(document.createTextNode(String.valueOf(parcel.getParcelNumber())));
                myParcel.appendChild(firstName);

                Element lastname = document.createElement("Adress");
                lastname.appendChild(document.createTextNode( parcel.getAdress().getAdress()));
                myParcel.appendChild(lastname);

                Element email = document.createElement("Reciver");
                email.appendChild(document.createTextNode(parcel.getReceiverName()));
                myParcel.appendChild(email);

                Element department = document.createElement("Weight");
                department.appendChild(document.createTextNode( String.valueOf(parcel.getWeight())));
                myParcel.appendChild(department);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("reportXML"));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }


    }

    @SuppressWarnings("unchecked")
    public void saveJSON(NodeNetwork nodeNetwork)
    {

        ArrayList<ParcelStandard> parcels = ParcelDAO.viewAllAsParcelStandard(nodeNetwork);

        JSONArray parcelList = new JSONArray();

        for(ParcelStandard parcel : parcels){
            JSONObject myParcel = new JSONObject();
            myParcel.put("ID", String.valueOf(parcel.getParcelNumber()));
            myParcel.put("Adress", parcel.getAdress().getAdress());
            myParcel.put("Reciver", parcel.getReceiverName());
            myParcel.put("Weight", String.valueOf(parcel.getWeight()));

            JSONObject parcelObject = new JSONObject();
            parcelObject.put("parcel", myParcel);

            parcelList.add(parcelObject);

        }

        //Write JSON file
        try (FileWriter file = new FileWriter("reportJSON.json")) {

            file.write(parcelList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JTable createTable(ArrayList<Object> objects) {

        ArrayList<String> columns = new ArrayList<String>();
        columns = retrieveColumnsTable(objects.get(1));
        String column[] = new String[columns.size()];
        int i = 0;
        for (String s : columns) {
            column[i] = s;
            i++;
        }
        i = 0;
        int j = 0;
        String data[][] = new String[objects.size()][columns.size()];
        ArrayList<String> parseData = new ArrayList<String>();
        for (Object c : objects) {
            j = 0;
            parseData = retrieveObjectData(c);
            for (String ss : parseData) {
                data[i][j] = ss;
                j++;
            }
            i++;
        }

        return new JTable(data, column);

    }

    public static ArrayList<String> retrieveColumnsTable(Object object) {
        ArrayList<String> columns = new ArrayList<String>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // set modifier to public
            try {
                //if(!field.getName().equals("parcelsToDeliver"))
                {
                    columns.add(field.getName());
                }
                //    System.out.println(field.getName());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return columns;
    }

    public static ArrayList<String> retrieveObjectData(Object object) {
        ArrayList<String> data = new ArrayList<String>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // set modifier to public
            Object val;
            try {
                val = field.get(object);
                //if(val != null && !val.toString().contains("ParcelStandard"))
                {
                    data.add(val.toString());
                }

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return data;
    }


}

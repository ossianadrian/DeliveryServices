package Client;

// A Java program for a Client
import Server.*;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Client
{
    // initialize socket and input output streams
    private static Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;

    // constructor to put ip address and port
    public Client() { }

    public static Mailer logInMailer(String address, int port, String username, String password) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String logInMailer = "log in Mailer";

            outToServer.writeObject(logInMailer);
            outToServer.writeObject(username);
            outToServer.writeObject(password);
            try{

                Mailer mailer = (Mailer) inFromServer.readObject();

                socket.close();
                return mailer;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ActivityCoordinator logInActivityCoordinator(String address, int port, String username, String password) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "log in ActivityCoordinator";

            outToServer.writeObject(request);
            outToServer.writeObject(username);
            outToServer.writeObject(password);
            try{

                ActivityCoordinator ac = (ActivityCoordinator) inFromServer.readObject();

                socket.close();
                return ac;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static Administrator logInAdministrator(String address, int port, String username, String password) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "log in Administrator";

            outToServer.writeObject(request);
            outToServer.writeObject(username);
            outToServer.writeObject(password);
            try{

                Administrator admin = (Administrator) inFromServer.readObject();

                socket.close();
                return admin;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ArrayList<Object> requestParcelsForMailer(String address, int port, String mailerName) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "view Parcels for mailer";

            outToServer.writeObject(request);
            outToServer.writeObject(mailerName);
            try{

                ArrayList<Object> parcelList = (ArrayList<Object>) inFromServer.readObject();

                socket.close();
                return parcelList;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ArrayList<Object> requestAllParcels(String address, int port) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "view all parcels";

            outToServer.writeObject(request);
            try{

                ArrayList<Object> parcelList = (ArrayList<Object>) inFromServer.readObject();

                socket.close();
                return parcelList;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ParcelStandard findParcelByName(String address, int port, int parcelNo) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "find parcel by number";

            outToServer.writeObject(request);
            outToServer.writeObject(parcelNo);
            try{

                ParcelStandard parcel = (ParcelStandard) inFromServer.readObject();

                socket.close();
                return parcel;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static void insertParcel(String address, int port, ParcelStandard parcel) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "insert parcel";

            outToServer.writeObject(request);
            outToServer.writeObject(parcel);
            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void editParcel(String address, int port, int parcelNo, ParcelStandard parcel) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "edit parcel";

            outToServer.writeObject(request);
            outToServer.writeObject(parcelNo);
            outToServer.writeObject(parcel);

            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void deleteParcel(String address, int port, int parcelNo) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "delete parcel";

            outToServer.writeObject(request);
            outToServer.writeObject(parcelNo);

            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void requestAssignToMailer(String address, int port, String mailerName, int parcelNo) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "assign parcel to mailer";

            outToServer.writeObject(request);
            outToServer.writeObject(mailerName);
            outToServer.writeObject(parcelNo);


            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static ArrayList<ParcelStandard> viewParcelsForMailerAsParcels(String address, int port, String mailerName) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "view all parcels for mailers";

            outToServer.writeObject(request);
            outToServer.writeObject(mailerName);

            try{

                ArrayList<ParcelStandard> parcelList = (ArrayList<ParcelStandard>) inFromServer.readObject();

                socket.close();
                return parcelList;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ArrayList<Object> requestAllMailers(String address, int port) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "view all mailers";

            outToServer.writeObject(request);
            try{

                ArrayList<Object> parcelList = (ArrayList<Object>) inFromServer.readObject();

                socket.close();
                return parcelList;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ArrayList<Object> requestAllActivityCoordinators(String address, int port) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "view all activity coordinators";

            outToServer.writeObject(request);
            try{

                ArrayList<Object> parcelList = (ArrayList<Object>) inFromServer.readObject();

                socket.close();
                return parcelList;
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static void insertMailer(String address, int port, Mailer mailer) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "insert Mailer";

            outToServer.writeObject(request);
            outToServer.writeObject(mailer);

            try{

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void insertActivityCoordinator(String address, int port, ActivityCoordinator ac) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "insert activity coordinator";

            outToServer.writeObject(request);
            outToServer.writeObject(ac);

            try{

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void deleteMailer(String address, int port, String name) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "delete mailer";

            outToServer.writeObject(request);
            outToServer.writeObject(name);

            try{

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void deleteActivityCoordinator(String address, int port, String name) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "delete activity coordinator";

            outToServer.writeObject(request);
            outToServer.writeObject(name);

            try{

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void editMailer(String address, int port, Mailer mailer) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "edit mailer";

            outToServer.writeObject(request);
            outToServer.writeObject(mailer);

            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void editActivityCoordinator(String address, int port, ActivityCoordinator ac) {

        // establish a connection
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outToServer = null;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            inFromServer = new ObjectInputStream(socket.getInputStream());


            // sends output to the socket
            outToServer = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception u) {
            System.out.println(u);
        }

        //create an object and send it to te server

        try {

            String request = "edit activity coordinator";

            outToServer.writeObject(request);
            outToServer.writeObject(ac);

            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public static void main(String args[])
    {
        System.out.println("Welcome to delivery services by Ossian Adrian!");
        Controller ctrl = new Controller();
        NodeNetwork nn = ctrl.createNetwork();
        View view = new View();
    }
}

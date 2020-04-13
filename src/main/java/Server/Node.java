package Server;

import java.util.ArrayList;

public class Node implements java.io.Serializable{

    private String Adress;
    private int distanceFromA;
    private int distanceFromB;
    private int distanceFromC;
    private int distanceFromD;
    private int distanceFromE;
    private int distanceFromF;
    private int distanceFromG;
    private int distanceFromH;
    private int distanceFromI;
    private int distanceFromJ;
    private int distanceFromK;
    private int distanceFromL;


    public ArrayList<Edge> neighbors;

    public Node(String Adress){
        this.Adress = Adress;
        this.neighbors = neighbors;
    }

    public void updateEdges(ArrayList<Edge> neighbors){
        if(this.neighbors == null){
            this.neighbors = new ArrayList<Edge>();
            for(Edge neigh : neighbors){
                this.neighbors.add(neigh);
            }
        }
        else{
            for(Edge neigh : neighbors){
                this.neighbors.add(neigh);
            }
        }
    }

    public void setNodeDistances(int A, int B, int C, int D, int E, int F, int G, int H, int I, int J, int K, int L){
        distanceFromA = A;
        distanceFromB = B;
        distanceFromC = C;
        distanceFromD = D;
        distanceFromE = E;
        distanceFromF = F;
        distanceFromG = G;
        distanceFromH = H;
        distanceFromI = I;
        distanceFromJ = J;
        distanceFromK = K;
        distanceFromL = L;

    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public int getDistanceFromSpecificNode(String StartNode) {

        char node = StartNode.charAt(0);

        switch (node) {
            case 'A':
                return distanceFromA;
            case 'B':
                return distanceFromB;
            case 'C':
                return distanceFromC;
            case 'D':
                return distanceFromD;
            case 'E':
                return distanceFromE;
            case 'F':
                return distanceFromF;
            case 'G':
                return distanceFromG;
            case 'H':
                return distanceFromH;
            case 'I':
                return distanceFromI;
            case 'J':
                return distanceFromJ;
            case 'K':
                return distanceFromK;
            case 'L':
                return distanceFromL;

            default:
                return 0;

        }
    }

    @Override
    public String toString(){
        return "Node name: " + this.getAdress();
    }


}

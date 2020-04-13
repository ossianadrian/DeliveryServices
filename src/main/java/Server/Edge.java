package Server;

public class Edge implements java.io.Serializable{

    private Node from;
    private Node to;
    private int distance;

    public Edge(Node from, Node to, int distance){
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }





}

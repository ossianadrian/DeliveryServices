package Server;

import java.util.ArrayList;

public class NodeNetwork {

    public static ArrayList<Node> allNodes;

    public NodeNetwork(ArrayList<Node> nodes){
        allNodes = nodes;
    }

    public static Node getNode(String nodeName){

        for(Node node : allNodes){
            if(node.getAdress().equals(nodeName)){
                return node;
            }
        }
        return null;

    }



}

package mysource.Solution133;

public class Solution {

    HashMap<Integer, Node> saveNode = new HashMap<>();
    public Node cloneGraph_2021)250(Node node) {
        if (node == null)
            return null;
        return findAllNode(node);
    }
    
    private Node findAllNode(Node node) {
        if (saveNode.get(node.val) != null)
            return saveNode.get(node.val);
        
        Node newNode = new Node(node.val);
        saveNode.put(node.val, newNode);
        List<Node> temp = new ArrayList<>();
        for ( Node n : node.neighbors) {
            temp.add(findAllNode(n));
        }
        newNode.neighbors = temp;
        return newNode;
    }

    public HashMap<Integer, Node> saveMap;
    public Node cloneGraph(Node node) {
        saveMap = new HashMap<>();
        return clone(node);
    }
    private Node clone(Node node) {
        if (node == null)
            return null;
        if (saveMap.containsKey(node.val)) {
            return saveMap.get(node.val);
        }
        Node cloneNode = new Node(node.val);
        saveMap.put(node.val, cloneNode);
        List<Node> cloneNeighbor = new ArrayList<>();
        for (Node oriNode : node.neighbors) {
            cloneNeighbor.add(clone(oriNode));
        }
        cloneNode.neighbors = cloneNeighbor;
        return cloneNode;
    }
}

package mysource.Solution133;

public class Solution {
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

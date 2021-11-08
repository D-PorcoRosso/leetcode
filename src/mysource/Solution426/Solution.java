package mysource.Solution426;

public class Solution {
    
    Node returnRoot = null;
    Node lastNode = null;
    
    public Node treeToDoublyList_2021_Synology(Node root) {
        if (root == null)
            return null;
        trace(root);
        returnRoot.left = lastNode;
        lastNode.right = returnRoot;
        return returnRoot;
    }
    
    private void trace(Node node) {
        if (node == null)
            return;
        trace(node.left);
        if (lastNode != null) {
            lastNode.right = node;
            node.left = lastNode;
        } else {
            returnRoot = node;
        }
        lastNode = node;
        trace(node.right);
    }
}

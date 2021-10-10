package mysource.Solution173;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode currentRoot;
    public BSTIterator(TreeNode root) {
        currentRoot = root;
    }
    
    public int next() {
        while(currentRoot != null) {
            stack.push(currentRoot);
            currentRoot = currentRoot.left;
        }
        if (currentRoot == null) {
            currentRoot = stack.pop();
        }
        int v = currentRoot.val;
        currentRoot = currentRoot.right;
        return v;
    }
    
    public boolean hasNext() {
        return stack.isEmpty() ? currentRoot != null ? true : false : true;
    }
}

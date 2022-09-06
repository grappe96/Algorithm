package study;

import java.util.*;

public class Solution_LeetCode_SymmetricTree {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	static class Node {
        int val, depth;
        public Node(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
    static List<Node> leftTree, rightTree;
    public boolean isSymmetric(TreeNode root) {
        leftTree = new ArrayList<Node>();
        rightTree = new ArrayList<Node>();
        
        leftTraversal(root.left, 1);
        rightTraversal(root.right, 1);
        
        if(isSame())
            return true;
        else
            return false;
    }
    private static void leftTraversal (TreeNode now, int depth) {
        if(now == null) 
            return;
        
        leftTraversal(now.left, depth+1);
        leftTree.add(new Node(now.val, depth));
        leftTraversal(now.right, depth+1);
    }
    private static void rightTraversal (TreeNode now, int depth) {
        if(now == null) 
            return;
        
        rightTraversal(now.right, depth+1);
        rightTree.add(new Node(now.val, depth));
        rightTraversal(now.left, depth+1);
    }
    private static boolean isSame() {
        int lSize = leftTree.size(), rSize = rightTree.size();
        if(lSize != rSize)
            return false;
        
        for(int i=0;i<lSize;i++)
            if(leftTree.get(i).depth != rightTree.get(i).depth || leftTree.get(i).val != rightTree.get(i).val)
                return false;
        return true;
    }
}

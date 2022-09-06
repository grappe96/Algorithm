package study;

import java.util.*;

public class Solution_LeetCode_BinaryTreeInorderTraversal {
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
    static List<Integer> list;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        inorder(root);
        
        return list;
    }
    private static void inorder(TreeNode now) {
        if(now == null)
            return;
        
        inorder(now.left);
        list.add(now.val);
        inorder(now.right);
    }
}

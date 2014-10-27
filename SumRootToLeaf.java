/*
*given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
*An example is the root-to-leaf path 1->2->3 which represents the number 123.
*Find the total sum of all root-to-leaf numbers.
*/
/*
*递归实现
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int path = 0;
        sum = rootLeaf(root,sum,path);
        return sum;
    }
    private int rootLeaf(TreeNode root,int sum,int path){
        if(root == null) {
            return 0;
        }
        path = path*10+root.val;
        if(root.left == null && root.right == null){
            sum += path;
            return sum;
        }
        return rootLeaf(root.left,sum,path)+rootLeaf(root.right,sum,path);
    }
}

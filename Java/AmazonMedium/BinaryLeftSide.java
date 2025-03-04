/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> output = new ArrayList<Integer>();
        if (root == null){
            return output;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level = q.size();
            for (int i=0 ; i < level; i++){
            TreeNode currentNode = q.poll();
            if (i == level -1){ // for each iteration q size is 2 and we loop over 0,1 and 2-1 ==1 i.e left side ignoring right which is 2-2 == 0.
            output.add(currentNode.val);
            }
            if (currentNode.right != null){
                q.offer(currentNode.right); 
            } 
            if (currentNode.left != null){
                q.offer(currentNode.left);
            } 
            }
        }
        return output;
    }
}

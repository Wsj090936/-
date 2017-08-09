package algorithms;
/**
 *  Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.
 * @author wushijia
 *
 */
public class Binary_Tree_Maximum_Path_Sum_124 {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPath(root);
        return res;
    }
    private int maxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,maxPath(node.left));//ȡ�����ֵ
        int right = Math.max(0,maxPath(node.right));//ȡ���ұ�ֵ
        res = Math.max(res,left + right + node.val);//����res��ֵ
        return Math.max(left , right) + node.val;//ÿ�εݹ飬ȡ���������ϴ���Ǹ�����
    }
}

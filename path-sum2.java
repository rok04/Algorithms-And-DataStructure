/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /** https://leetcode.com/problems/path-sum-ii
 
  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 
 */
public class Solution {

  public void solveme(TreeNode root,int sum,List<Integer> l,int required,List<List<Integer> > ans){
        if(root==null)
            return  ;
        
        if(sum==required&&root.left==null&&root.right==null){
            List<Integer> temp= new ArrayList<Integer> ();
            temp.addAll(l);
            ans.add(temp);
           return ;
        }
        else
        {   if(root.left!=null){
                  l.add(root.left.val);
                  solveme(root.left,sum+root.left.val,l,required,ans);
                  l.remove(l.size()-1);
            }
            if(root.right!=null){
                   l.add(root.right.val);
                   solveme(root.right,sum+root.right.val,l,required,ans);
                   l.remove(l.size()-1);
            }
        }
        return ;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return new ArrayList<List<Integer> >();
        }
        else
        { List<Integer> l =new ArrayList<Integer>();
          List<List<Integer > > ans = new ArrayList<List<Integer> > ();
          l.add(root.val);
            new Solution().solveme(root,root.val,l,sum,ans);
            return ans;
            
            
        }
    }
}

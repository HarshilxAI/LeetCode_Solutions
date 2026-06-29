import java.util.*;

class Solution {
    List<Integer> ans = new ArrayList<>();

public List<Integer> inorderTraversal(TreeNode root) {
      inorder(root);
      return ans;
}

void inorder(TreeNode root)
{
    if(root==null)
        return;
      inorder(root.left);
      ans.add(root.val);
    inorder(root.right);

}

}
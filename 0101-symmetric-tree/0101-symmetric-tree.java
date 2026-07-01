class Solution {

    public boolean isSymmetric(TreeNode root) {

        if(root==null)
           return true;

            return check(root.left,root.right);

    }

    boolean check(TreeNode l,TreeNode r){

           if(l==null && r==null)
        return true;

          if(l==null || r==null)
        return false;
  
        if(l.val!=r.val)
            return false;

           boolean a = check(l.left,r.right);

         boolean b=check(l.right,r.left);

         return a&&b;
  
    }

}
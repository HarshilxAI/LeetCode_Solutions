class Solution {

int answer=0;
public int averageOfSubtree(TreeNode root) {
    dfs(root);
return answer;
    }
    private int[] dfs(TreeNode node) {
if (node==null) {
    return new int[]{0,0};
        }
int[] left=dfs(node.left);
int[] right=dfs(node.right);
int sum=node.val+left[0]+ right[0];
int count=1 +left[1]+ right[1];
    if (sum/count==node.val) {
            answer++;
        }
return new int[]{sum,count};
    }
}
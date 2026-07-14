class Solution {
    public String countAndSay(int n) {
        String ans = "1";
 for (int i = 1; i < n; i++) {
  String newAns = "";
    int count = 1;
            for (int j = 0; j < ans.length() - 1; j++) {
              if (ans.charAt(j) == ans.charAt(j + 1)) {
         count++;
          } else {
    newAns = newAns + count + ans.charAt(j);
        count = 1;
                }}
            newAns = newAns + count + ans.charAt(ans.length() - 1);
            ans = newAns;
        }
        return ans;
    }
}
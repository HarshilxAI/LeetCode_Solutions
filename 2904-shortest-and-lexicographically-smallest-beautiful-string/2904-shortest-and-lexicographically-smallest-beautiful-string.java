class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

int n =s.length();
int[] prefix= new int[n + 1];

    for (int i=0; i< n;i++) {
        prefix[i + 1]=prefix[i];
    if (s.charAt(i)== '1') {
                prefix[i+1]++;
            }}

int minLen=Integer.MAX_VALUE;
    String ans= "";

    for (int i=0; i< n; i++) {
    for (int j =i; j <n; j++) {

        int ones = prefix[j+1] -prefix[i];
        if (ones==k) {
            int len =j-i+1;
        if (len <minLen) {
            minLen= len;
                    ans= s.substring(i,j+ 1);

                    } else if (len==minLen) {

String temp =s.substring(i, j + 1);
                        if (ans.equals("")|| temp.compareTo(ans)< 0) {
    ans =temp;
                        }}
}
}}

    return ans;
    }}
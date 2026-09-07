class Solution {

    static final long MOD = 1000000007;
public int distinctSubseqII(String s) {
int n=s.length();
long[] dp= new long[n + 1];
    dp[0]= 1;
    long[] last=new long[26];
for (int i =1;i<= n;i++) {
    char ch=s.charAt(i-1);
        int index=ch-'a';
            dp[i]=(2*dp[i-1])% MOD;
            dp[i] = (dp[i]-last[index]+MOD)% MOD;
            last[index]=dp[i -1];
        }
return (int) ((dp[n]-1+MOD)% MOD);
    }
}
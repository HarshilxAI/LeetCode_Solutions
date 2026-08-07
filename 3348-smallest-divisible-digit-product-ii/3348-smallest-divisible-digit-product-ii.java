class Solution {
    static final int INF = 1000000;

    public String smallestNumber(String num, long t) {
        int n = num.length();
        char[] digs = num.toCharArray();
        int A=0,B=0,C=0,D=0;
        long tt = t;
        while (tt % 2 == 0) { A++; tt /= 2; }
        while (tt % 3 == 0) { B++;  tt/=3; }
        while(tt % 5 ==0){ C++; tt /= 5;}
        while (tt%7==0) { D++; tt/=7; }
        if(tt != 1) return "-1";
        int[] E2 = {0,0,1,0,2,0,1,0,3,0};
        int[] E3 = {0,0,0,1,0,0,1,0,0,2};
        int[] E5 = {0,0,0,0,0,1,0,0,0,0};
        int[] E7 = {0,0,0,0,0,0,0,1,0,0};
        int[][][][] dp = new int[A+1][B+1][C+1][D+1];
        for(int a=0;a<=A;a++){
        for(int b=0;b<=B;b++){
            for(int c=0;c<=C;c++){
                for (int d=0; d<=D; d++) {
                    if(a==0&&b==0&&c==0&&d==0){
                        dp[a][b][c][d]=0;
                        continue;
}
    int best=INF;
                    for(int dig=2; dig<=9; dig++){
     int na=Math.max(0,a-E2[dig]);
     int nb=Math.max(0,b-E3[dig]);
     int nc = Math.max(0, c-E5[dig]);
     int nd = Math.max(0,d-E7[dig]);
                        if(na==a&&nb==b&&nc==c&&nd==d) continue; 
int cand=1+dp[na][nb][nc][nd];
                        if (cand<best) best=cand;
                    }
                    dp[a][b][c][d]=best;
                }}
    }
    }

        int[] prefA=new int[n+1], prefB=new int[n+1], prefC=new int[n+1], prefD=new int[n+1];
        for(int i=0;i<n;i++){
            int dg = digs[i]-'0';
            prefA[i+1]=Math.min(A, prefA[i]+E2[dg]);
            prefB[i+1] = Math.min(B, prefB[i]+E3[dg]);
            prefC[i+1]=Math.min(C,prefC[i]+E5[dg]);
            prefD[i+1] = Math.min(D, prefD[i] + E7[dg]);
        }
        int zpos=-1;
        for(int i=0;i<n;i++) if(digs[i]=='0'){ zpos=i; break;}
        if(zpos==-1 && prefA[n]>=A && prefB[n]>=B && prefC[n]>=C && prefD[n]>=D) {
            return num;
        }

        int z = (zpos==-1)? n : zpos;
        for(int i=n-1;i>=0;i--){
            if(i>z) continue;   
            int startD=(digs[i]-'0')+1;
            if (startD>9) continue;
            int remainPos=n-1-i;
            for(int dig=startD; dig<=9; dig++){
                int ra=Math.min(A,prefA[i]+E2[dig]);
                int rb =Math.min(B,prefB[i]+E3[dig]);
                int rc=Math.min(C, prefC[i]+E5[dig]);
                int rd=Math.min(D, prefD[i]+E7[dig]);
                int needA=A-ra, needB=B-rb,needC=C-rc,needD=D-rd;
                if(dp[needA][needB][needC][needD] <= remainPos) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(digs,0,i);
                    sb.append((char)('0'+dig));
                    fillGreedy(sb,needA,needB,needC,needD,remainPos,dp,E2,E3,E5,E7);
                    return sb.toString();
    }
}
}
        int minLen=dp[A][B][C][D];
        int L = Math.max(n+1,minLen);
        StringBuilder sb=new StringBuilder();
        fillGreedy(sb,A,B,C,D,L,dp,E2,E3,E5,E7);
        return sb.toString();
    }
    private void fillGreedy(StringBuilder sb,int ra,int rb,int rc,int rd,int slots,
                              int[][][][] dp,int[] E2,int[] E3,int[] E5,int[] E7){
        int curA=ra,curB=rb,curC=rc,curD=rd;
        for (int pos=0; pos<slots; pos++) {
            int remainAfter=slots-pos-1;
            for(int dig=1;dig<=9;dig++){
                int na=Math.max(0,curA-E2[dig]);
                int nb = Math.max(0,curB-E3[dig]);
                int nc=Math.max(0,curC-E5[dig]);
                int nd=Math.max(0,curD-E7[dig]);
                if(dp[na][nb][nc][nd]<=remainAfter){
                    sb.append((char)('0'+dig));
                    curA=na; curB=nb; curC=nc; curD=nd;
                    break;
                }
            }
        }
    }
}
class Solution {
       public int[] plusOne(int[] dts) {
          for (int i=dts.length-1; i>=0; i--) {
              if (dts[i]<9) {
                   dts[i]++;
                  return dts;
              }
               dts[i]=0;
          }
           int[] res=new int[dts.length+1];
          res[0]=1;
           return res;
      }
}  
class Solution {

public int mySqrt(int x) {
    if(x==0 || x==1)
        return x;
      int low = 1;
    int high = x;

    while(low<=high)
    {
        int mid = low + (high-low)/2;
        long sq = (long)mid * mid;
        if(sq==x)
        {
            return mid;
        }
        else if(sq < x) {
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }}
      return high;

}
}
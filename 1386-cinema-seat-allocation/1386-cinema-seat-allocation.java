import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

    HashMap<Integer, Integer> map= new HashMap<>();
    for (int[] seat : reservedSeats) {
int row= seat[0];
int col= seat[1];
    if (col>=2 && col<=9) {
        map.put(row, map.getOrDefault(row, 0) | (1<<col));
            }}

    int ans = (n - map.size())*2;

    for (int mask : map.values()) {

        boolean left= true;
    boolean middle= true;
    boolean right= true;
    for (int j= 2; j<=5; j++) {
    if ((mask&(1<<j)) !=0) {
        left= false;
            break;
}
}
    for (int j= 4; j<= 7; j++) {
        if ((mask & (1 << j)) != 0) {
                    middle = false;
                    break;
                }
            }

    for (int j= 6; j<= 9; j++) {
        if ((mask &(1<<j)) != 0) {
                    right = false;
            break;
                }
            }
    if (left &&right) {
        ans +=2;
            } else if (left || middle || right) {
    ans +=1;
            }
        }
 return ans;
    }
}
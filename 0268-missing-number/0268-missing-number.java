class Solution {
    public int missingNumber(int[] nums) {

    int n = nums.length;
     int TS = (n*(n +1)) /2;
     int ASum = 0;

for (int i = 0; i<n; i++) {
    ASum = ASum + nums[i];
        }

        return TS - ASum;
    }
}
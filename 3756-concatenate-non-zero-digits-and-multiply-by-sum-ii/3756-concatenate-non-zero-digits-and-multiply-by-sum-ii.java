class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1_000_000_007;
            int n = s.length();
          long[] prefixSum = new long[n + 1];
           ArrayList<Integer> positions = new ArrayList<>();
ArrayList<Long> prefixValue = new ArrayList<>();
        prefixValue.add(0L);
        for (int i = 0; i < n; i++) {
              int digit = s.charAt(i) - '0';
              prefixSum[i + 1] = prefixSum[i];
            if (digit != 0) {
                   prefixSum[i + 1] += digit;
                 positions.add(i);
long value = (prefixValue.get(prefixValue.size() - 1) * 10 + digit) % MOD;
                prefixValue.add(value);
              } }
          int k = positions.size();
           long[] pow10 = new long[k + 1];
           pow10[0] = 1;
         for (int i = 1; i <= k; i++) {
              pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int[] answer = new int[queries.length];
          for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
             int r = queries[q][1];
 int left = lowerBound(positions, l);
            int right = upperBound(positions, r) - 1;
            if (left > right) {
                answer[q] = 0;
                continue;
            }
              int count = right - left + 1;
              long x = (prefixValue.get(right + 1)
                     - (prefixValue.get(left) * pow10[count]) % MOD
                    + MOD) % MOD;
            long sum = prefixSum[r + 1] - prefixSum[l];
            answer[q] = (int) ((x * (sum % MOD)) % MOD);
        }
        return answer;
    }
    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }}
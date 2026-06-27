import java.util.*;
class Solution {
public int maximumLength(int[] nums) {
HashMap<Long, Integer> map = new HashMap<>();
for (int x : nums) {
 map.put((long)x, map.getOrDefault((long)x, 0) + 1);
 }
 int ans = 1;
if (map.containsKey(1L)) {
int cnt = map.get(1L); 
ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
    }
for (long x : map.keySet()) {
 if (x == 1)
            continue;
        long cur = x;
 int len = 0;
 while (true) {
  int freq = map.getOrDefault(cur, 0);
                if (freq >= 2) {
            len += 2;
   if (cur > (long)Math.sqrt(Long.MAX_VALUE))
              break;
  cur = cur * cur;
               }
             else {
             if (freq == 1)
         len++;
         else
            len--;

           break;
          }
  }

 ans = Math.max(ans, len);
        }

return ans;
    }
}
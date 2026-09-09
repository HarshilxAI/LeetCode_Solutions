class Solution {

    public long countCommas(long n) {
long answer = 0;

    if (n>=1000) {
            answer+=Math.min(n,999999L)- 1000+ 1;
        }
    if (n >=1000000){
            answer+=2L*(Math.min(n,999999999L)-1000000+ 1);
        }
    if (n >= 1000000000L) {
            answer += 3L * (Math.min(n, 999999999999L) - 1000000000L + 1);
        }
    if (n >= 1000000000000L) {
            answer += 4L * (Math.min(n, 999999999999999L)
                    - 1000000000000L + 1);
        }
    if (n >= 1000000000000000L) {
            answer += 5L * (n - 1000000000000000L + 1);
        }
 return answer;
    }
}